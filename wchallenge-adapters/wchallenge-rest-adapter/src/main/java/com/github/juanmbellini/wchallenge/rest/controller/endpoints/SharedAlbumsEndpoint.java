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
import com.github.juanmbellini.wchallenge.models.Permission;
import com.github.juanmbellini.wchallenge.rest.controller.dtos.PermissionListDto;
import com.github.juanmbellini.wchallenge.rest.controller.dtos.UserDto;
import com.github.juanmbellini.wchallenge.services.SharedAlbumsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

/**
 * API endpoint that acts as an adapter of the {@link SharedAlbumsService}.
 */
@Path("albums/{albumId : \\d+}/shares")
@Produces(MediaType.APPLICATION_JSON)
@JerseyController
public class SharedAlbumsEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(SharedAlbumsEndpoint.class);

    /**
     * The {@link SharedAlbumsService} being adapted.
     */
    private final SharedAlbumsService sharedAlbumsService;

    /**
     * Constructor.
     *
     * @param sharedAlbumsService The {@link SharedAlbumsService} being adapted.
     */
    @Autowired
    public SharedAlbumsEndpoint(final SharedAlbumsService sharedAlbumsService) {
        this.sharedAlbumsService = sharedAlbumsService;
    }


    @PUT
    @Path("{userId : \\d+}")
    public Response setPermissions(
            @PathParam("albumId") final long albumId,
            @PathParam("userId") final long userId,
            @Valid final PermissionListDto permissionListDto) {
        LOGGER.debug("Granting {} permissions to user with id {} for album with id {}",
                permissionListDto.getPermissions(), userId, albumId);
        sharedAlbumsService.setPermissions(albumId, userId, permissionListDto.getPermissions());
        return Response.noContent().build();
    }

    @DELETE
    @Path("{userId : \\d+}")
    public Response removePermissions(
            @PathParam("albumId") final long albumId,
            @PathParam("userId") final long userId) {
        LOGGER.debug("Removing all permissions to user with id {} for album with id {}", userId, albumId);
        sharedAlbumsService.removeAllPermissions(albumId, userId);
        return Response.noContent().build();
    }

    @PUT
    @Path("{userId : \\d+}/{permission : .+}")
    public Response addPermission(
            @PathParam("albumId") final long albumId,
            @PathParam("userId") final long userId,
            @PathParam("permission") final Permission permission) {
        LOGGER.debug("Granting {} permission to user with id {} for album with id {}", permission, userId, albumId);
        sharedAlbumsService.addPermission(albumId, userId, permission);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{userId : \\d+}/{permission : .+}")
    public Response removePermission(
            @PathParam("albumId") final long albumId,
            @PathParam("userId") final long userId,
            @PathParam("permission") final Permission permission) {
        LOGGER.debug("Removing {} permission to user with id {} for album with id {}", permission, userId, albumId);
        sharedAlbumsService.removePermission(albumId, userId, permission);
        return Response.noContent().build();
    }

    @DELETE
    public Response removeAllPermissionsForAlbum(@PathParam("albumId") final long albumId) {
        LOGGER.debug("Removing all permissions for album with id {}", albumId);
        sharedAlbumsService.removeAlbumPermissions(albumId);
        return Response.noContent().build();
    }

    @GET
    public Response hasPermissions(
            @PathParam("albumId") final long albumId,
            @QueryParam("permission") final Permission permission) {
        LOGGER.debug("Retrieving users with {} permission over album with id {}", permission, albumId);
        final var users = sharedAlbumsService.hasPermission(albumId, permission).stream()
                .map(UserDto::fromJsonPlaceholderUser)
                .collect(Collectors.toList());
        return Response.ok(users).build();
    }
}
