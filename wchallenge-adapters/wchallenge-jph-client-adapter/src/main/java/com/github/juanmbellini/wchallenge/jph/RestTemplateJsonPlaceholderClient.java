package com.github.juanmbellini.wchallenge.jph;

import com.bellotapps.webapps_commons.exceptions.NotImplementedException;
import com.github.juanmbellini.wchallenge.models.Album;
import com.github.juanmbellini.wchallenge.models.Comment;
import com.github.juanmbellini.wchallenge.models.Photo;
import com.github.juanmbellini.wchallenge.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * Concrete implementation of {@link JsonPlaceholderClient}, using {@link org.springframework.web.client.RestTemplate}.
 */
@Component
public class RestTemplateJsonPlaceholderClient implements JsonPlaceholderClient {

    /**
     * The {@link RestTemplate} used for consuming the JsonPlaceholder service.
     */
    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateJsonPlaceholderClient(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<User> retrieveUsers() {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public List<Photo> retrievePhotos() {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public List<Album> retrieveAlbums() {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public Optional<User> getUserById(final long userId) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public List<Album> retrieveUserAlbums(final long userId) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public List<Photo> retrieveUserPhotos(final long userId) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public List<Comment> retrieveComments(final String nameFilter, final String emailFilter) {
        throw new NotImplementedException("Not implemented yet");
    }
}
