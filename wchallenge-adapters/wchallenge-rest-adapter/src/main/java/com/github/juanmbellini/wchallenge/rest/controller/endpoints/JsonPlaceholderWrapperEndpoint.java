/*
 * Copyright 2019 Juan Marcos Bellini
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.juanmbellini.wchallenge.rest.controller.endpoints;

import com.bellotapps.webapps_commons.config.JerseyController;
import com.github.juanmbellini.wchallenge.rest.controller.dtos.AlbumDto;
import com.github.juanmbellini.wchallenge.rest.controller.dtos.PhotoDto;
import com.github.juanmbellini.wchallenge.rest.controller.dtos.UserDto;
import com.github.juanmbellini.wchallenge.services.JsonPlaceholderWrapperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

/**
 * API endpoint that acts as an adapter of the {@link JsonPlaceholderWrapperService}.
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@JerseyController
public class JsonPlaceholderWrapperEndpoint {

    /**
     * The {@link Logger} object.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonPlaceholderWrapperEndpoint.class);

    /**
     * The {@link JsonPlaceholderWrapperService}.
     */
    private final JsonPlaceholderWrapperService jsonPlaceholderWrapperService;

    /**
     * Constructor.
     *
     * @param jsonPlaceholderWrapperService The {@link JsonPlaceholderWrapperService}.
     */
    @Autowired
    public JsonPlaceholderWrapperEndpoint(final JsonPlaceholderWrapperService jsonPlaceholderWrapperService) {
        this.jsonPlaceholderWrapperService = jsonPlaceholderWrapperService;
    }

    @GET
    @Path("users")
    public Response getUsers() {
        LOGGER.debug("Getting all users");
        final var users = jsonPlaceholderWrapperService.getUsers().stream()
                .map(UserDto::fromJsonPlaceholderUser)
                .collect(Collectors.toList());
        return Response.ok(users).build();
    }

    @GET
    @Path("photos")
    public Response getPhotos() {
        LOGGER.debug("Getting all photos");
        final var photos = jsonPlaceholderWrapperService.getAllPhotos().stream()
                .map(PhotoDto::fromJsonPlaceholderPhoto)
                .collect(Collectors.toList());
        return Response.ok(photos).build();
    }

    @GET
    @Path("albums")
    public Response getAlbums() {
        LOGGER.debug("Getting all albums");
        final var albums = jsonPlaceholderWrapperService.getAllAlbums().stream()
                .map(AlbumDto::fromJsonPlaceholderAlbum)
                .collect(Collectors.toList());
        return Response.ok(albums).build();
    }

    @GET
    @Path("/users/{id : \\d+}/albums")
    public Response getUserAlbums(@PathParam("id") final long id) {
        LOGGER.debug("Getting all albums of user with id {}", id);
        final var albums = jsonPlaceholderWrapperService.getUserAlbums(id).stream()
                .map(AlbumDto::fromJsonPlaceholderAlbum)
                .collect(Collectors.toList());
        return Response.ok(albums).build();
    }

    @GET
    @Path("/users/{id : \\d+}/photos")
    public Response getUserPhotos(@PathParam("id") final long id) {
        LOGGER.debug("Getting all photos of user with id {}", id);
        final var photos = jsonPlaceholderWrapperService.getUserPhotos(id).stream()
                .map(PhotoDto::fromJsonPlaceholderPhoto)
                .collect(Collectors.toList());
        return Response.ok(photos).build();
    }
}
