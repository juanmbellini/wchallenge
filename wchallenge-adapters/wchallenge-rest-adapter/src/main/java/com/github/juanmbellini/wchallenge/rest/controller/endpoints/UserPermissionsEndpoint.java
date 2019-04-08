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
import com.github.juanmbellini.wchallenge.services.SharedAlbumsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * API endpoint that acts as an adapter of the {@link SharedAlbumsService#removeUserPermissions(long)} method.
 */
@Path("users/{userId : \\d+}/permissions")
@Produces(MediaType.APPLICATION_JSON)
@JerseyController
public class UserPermissionsEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPermissionsEndpoint.class);

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
    public UserPermissionsEndpoint(final SharedAlbumsService sharedAlbumsService) {
        this.sharedAlbumsService = sharedAlbumsService;
    }

    @DELETE
    public Response removeAllPermissionsForUser(@PathParam("userId") final long userId) {
        LOGGER.debug("Removing all permissions for user with id {}", userId);
        sharedAlbumsService.removeUserPermissions(userId);
        return Response.noContent().build();
    }
}
