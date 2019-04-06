package com.github.juanmbellini.wchallenge.jph;

import com.bellotapps.webapps_commons.exceptions.ExternalServiceException;
import com.github.juanmbellini.wchallenge.jph.dtos.AlbumDto;
import com.github.juanmbellini.wchallenge.jph.dtos.CommentDto;
import com.github.juanmbellini.wchallenge.jph.dtos.PhotoDto;
import com.github.juanmbellini.wchallenge.jph.dtos.UserDto;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderAlbum;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderComment;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderPhoto;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Concrete implementation of {@link JsonPlaceholderClient}, using {@link RestTemplate}.
 */
@Component
public class RestTemplateJsonPlaceholderClient implements JsonPlaceholderClient {

    /**
     * The external service name (i.e used for reporting it when an {@link ExternalServiceException} is thrown).
     */
    private final static String SERVICE_NAME = "JsonPlaceholder";

    /**
     * The base URL of the Json Placeholder service.
     */
    private final String baseUrl;
    /**
     * The {@link RestTemplate} used for consuming the JsonPlaceholder service.
     */
    private final RestTemplate restTemplate;
    /**
     * A {@link ParameterizedTypeReference} of {@link List} of {@link UserDto} used to instantiate
     * a {@link List} of {@link UserDto} when receiving the data from the Json Placeholder service.
     */
    private final ParameterizedTypeReference<List<UserDto>> userDtoParameterizedTypeReference;
    /**
     * A {@link ParameterizedTypeReference} of {@link List} of {@link AlbumDto} used to instantiate
     * a {@link List} of {@link AlbumDto} when receiving the data from the Json Placeholder service.
     */
    private final ParameterizedTypeReference<List<AlbumDto>> albumDtoParameterizedTypeReference;
    /**
     * A {@link ParameterizedTypeReference} of {@link List} of {@link PhotoDto} used to instantiate
     * a {@link List} of {@link PhotoDto} when receiving the data from the Json Placeholder service.
     */
    private final ParameterizedTypeReference<List<PhotoDto>> photoDtoParameterizedTypeReference;

    /**
     * A {@link ParameterizedTypeReference} of {@link List} of {@link CommentDto} used to instantiate
     * a {@link List} of {@link CommentDto} when receiving the data from the Json Placeholder service.
     */
    private final ParameterizedTypeReference<List<CommentDto>> commentDtoParameterizedTypeReference;


    /**
     * Constructor.
     *
     * @param baseUrl      The base URL of the Json Placeholder service.
     * @param restTemplate The {@link RestTemplate} used for consuming the JsonPlaceholder service.
     */
    @Autowired
    public RestTemplateJsonPlaceholderClient(
            @Value("${wchallenge.jsonplacehoder.url}") final String baseUrl,
            final RestTemplate restTemplate) {
        this.baseUrl = baseUrl;
        this.restTemplate = restTemplate;
        this.userDtoParameterizedTypeReference = new ParameterizedTypeReference<>() {
        };
        this.albumDtoParameterizedTypeReference = new ParameterizedTypeReference<>() {
        };
        this.photoDtoParameterizedTypeReference = new ParameterizedTypeReference<>() {
        };
        this.commentDtoParameterizedTypeReference = new ParameterizedTypeReference<>() {
        };
    }


    @Override
    public List<JsonPlaceholderUser> retrieveUsers() {
        return getList(userDtoParameterizedTypeReference, baseUrl + "/users")
                .stream()
                .map(dto -> (JsonPlaceholderUser) dto)
                .collect(Collectors.toList());
    }


    @Override
    public List<JsonPlaceholderPhoto> retrievePhotos() {
        return getList(photoDtoParameterizedTypeReference, baseUrl + "/photos")
                .stream()
                .map(dto -> (JsonPlaceholderPhoto) dto)
                .collect(Collectors.toList());
    }

    @Override
    public List<JsonPlaceholderAlbum> retrieveAlbums() {
        return getList(albumDtoParameterizedTypeReference, baseUrl + "/albums")
                .stream()
                .map(dto -> (JsonPlaceholderAlbum) dto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JsonPlaceholderUser> getUserById(final long userId) {
        // TODO: improve this
        try {
            return Optional.ofNullable(getEntity(UserDto.class, baseUrl + "/users/{id}", userId));
        } catch (final ExternalServiceException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean existsUserWithId(final long userId) {
        try {
            // If headForHeaders returns successfully, then the resource exists.
            restTemplate.headForHeaders(baseUrl + "/users/{id}", userId); // Ignore results
            return true;
        } catch (final HttpClientErrorException.NotFound e) {
            return false;
        } catch (final RestClientException e) {
            throw new ExternalServiceException(SERVICE_NAME, "Exception encountered when accessing JsonPlaceholder", e);
        }
    }

    @Override
    public List<JsonPlaceholderAlbum> retrieveUserAlbums(final long userId) {
        return getList(albumDtoParameterizedTypeReference, baseUrl + "/albums?userId={userId}", userId)
                .stream()
                .map(dto -> (JsonPlaceholderAlbum) dto)
                .collect(Collectors.toList());
    }

    @Override
    public List<JsonPlaceholderPhoto> retrieveUserPhotos(final long userId) {
        final var albums = retrieveUserAlbums(userId)
                .stream()
                .collect(Collectors.toMap(JsonPlaceholderAlbum::getId, Function.identity()));
        if (albums.isEmpty()) {
            return Collections.emptyList();
        }
        final var url = Stream.generate(() -> "albumId={albumId}")
                .limit(albums.size())
                .collect(Collectors.joining("&", baseUrl + "/photos?", ""));
        return getList(photoDtoParameterizedTypeReference, url, albums.keySet().toArray())
                .stream()
                .map(dto -> (JsonPlaceholderPhoto) dto)
                .collect(Collectors.toList());
    }

    @Override
    public List<JsonPlaceholderComment> retrieveComments(final String nameFilter, final String emailFilter) {
        final var builder = new StringBuilder().append(baseUrl)
                .append("/comments");
        final List<String> args = new LinkedList<>();
        if (StringUtils.hasText(nameFilter)) {
            builder.append("?name={name}");
            args.add(nameFilter);
        }
        if (StringUtils.hasText(emailFilter)) {
            builder.append(args.isEmpty() ? "?" : "&");
            builder.append("email={email}");
            args.add(emailFilter);
        }

        return getList(commentDtoParameterizedTypeReference, builder.toString(), args.toArray())
                .stream()
                .map(dto -> (JsonPlaceholderComment) dto)
                .collect(Collectors.toList());
    }


    /**
     * Retrieves a {@link List} of entities of type {@code E} from the given {@code url}.
     *
     * @param parameterizedTypeReference A {@link ParameterizedTypeReference} of {@link List} of {@code E},
     *                                   used by the {@link RestTemplate} to instantiating the DTOs when downloading.
     * @param url                        The url from where entities will be downloaded.
     * @param uriVariables               The  variables for the url to be expanded.
     * @param <E>                        The type of the entities.
     * @return The downloaded {@link List}.
     */
    private <E> List<E> getList(
            final ParameterizedTypeReference<List<E>> parameterizedTypeReference,
            final String url,
            final Object... uriVariables) throws ExternalServiceException {
        try {
            final var response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    parameterizedTypeReference,
                    uriVariables
            );
            if (response.getStatusCode() != HttpStatus.OK) {
                throw new ExternalServiceException(
                        SERVICE_NAME,
                        "JsonPlaceholder returned an unexpected HTTP status code"
                );
            }
            return Optional.ofNullable(response.getBody())
                    .orElseThrow(() -> new ExternalServiceException(SERVICE_NAME, "No body in the response"));
        } catch (final RestClientException e) {
            throw new ExternalServiceException(SERVICE_NAME, "Exception encountered when accessing JsonPlaceholder", e);
        }
    }

    /**
     * Retrieves an entity of type {@code E} from the given {@code url}.
     *
     * @param klass        The class of the entity being returned.
     * @param url          The url from where the entity will be downloaded.
     * @param uriVariables The  variables for the url to be expanded.
     * @param <E>          The type of the entity.
     * @return The downloaded entity.
     */
    private <E> E getEntity(
            final Class<E> klass,
            final String url,
            final Object... uriVariables)
            throws ExternalServiceException {
        try {
            return restTemplate.getForObject(url, klass, uriVariables);
        } catch (final RestClientException e) {
            throw new ExternalServiceException(SERVICE_NAME, "Exception encountered when accessing JsonPlaceholder", e);
        }
    }
}
