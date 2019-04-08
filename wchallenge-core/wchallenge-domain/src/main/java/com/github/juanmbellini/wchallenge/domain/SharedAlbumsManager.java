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

package com.github.juanmbellini.wchallenge.domain;

import com.github.juanmbellini.wchallenge.jph.JsonPlaceholderClient;
import com.github.juanmbellini.wchallenge.models.Permission;
import com.github.juanmbellini.wchallenge.models.SharedAlbumPermission;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderUser;
import com.github.juanmbellini.wchallenge.repositories.SharedAlbumPermissionsRepository;
import com.github.juanmbellini.wchallenge.services.SharedAlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Manager in charge of providing services to share albums.
 */
@Service
@Transactional(readOnly = true)
public class SharedAlbumsManager implements SharedAlbumsService {

    /**
     * Repository in charge of persisting shared albums permissions.
     */
    private final SharedAlbumPermissionsRepository sharedAlbumPermissionsRepository;

    /**
     * A client for the JsonPlaceholder service.
     */
    private final JsonPlaceholderClient jsonPlaceholderClient;

    /**
     * Constructor.
     *
     * @param sharedAlbumPermissionsRepository Repository in charge of persisting shared albums permissions.
     * @param jsonPlaceholderClient            A client for the JsonPlaceholder service.
     */
    @Autowired
    public SharedAlbumsManager(
            final SharedAlbumPermissionsRepository sharedAlbumPermissionsRepository,
            final JsonPlaceholderClient jsonPlaceholderClient) {
        this.sharedAlbumPermissionsRepository = sharedAlbumPermissionsRepository;
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }


    @Override
    @Transactional
    public void addPermission(final long albumId, final long userId, final Permission permission) {
        Assert.notNull(permission, "The permission must not be null");
        doAddPermission(albumId, userId, permission);
    }

    @Override
    @Transactional
    public void removePermission(final long albumId, final long userId, final Permission permission) {
        Assert.notNull(permission, "The permission must not be null");
        sharedAlbumPermissionsRepository.retrieve(albumId, userId, permission)
                .ifPresent(sharedAlbumPermissionsRepository::delete);
    }

    @Override
    @Transactional
    public void setPermissions(final long albumId, final long userId, final Set<Permission> permissions) {
        Assert.notEmpty(permissions, "The permissions Set must not be null nor empty");
        Assert.isTrue(permissions.stream().noneMatch(Objects::isNull), "The permissions set must not contain nulls");
        permissions.forEach(permission -> doAddPermission(albumId, userId, permission));
    }

    @Override
    @Transactional
    public void removeAllPermissions(final long albumId, final long userId) {
        sharedAlbumPermissionsRepository.removeAllForAlbumAndUser(albumId, userId);
    }

    @Override
    @Transactional
    public void removeUserPermissions(final long userId) {
        sharedAlbumPermissionsRepository.removeAllForUser(userId);
    }

    @Override
    @Transactional
    public void removeAlbumPermissions(final long albumId) {
        sharedAlbumPermissionsRepository.removeAllForAlbum(albumId);
    }

    @Override
    public List<JsonPlaceholderUser> hasPermission(final long albumId, final Permission permission) {
        // TODO: create some method in the JsonPlaceholderClient to retrieve all the users with the given ids.
        //  This avoids N requests
        return sharedAlbumPermissionsRepository.usersWithPermission(albumId, permission)
                .stream()
                .distinct()
                .map(jsonPlaceholderClient::getUserById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }


    /**
     * Performs the action of saving a granting a {@link Permission} to the album with the given {@code albumId},
     * to the user with the given {@code userId}.
     *
     * @param albumId    The id of the album.
     * @param userId     The id of the user.
     * @param permission The {@link Permission} to be granted.
     */
    private void doAddPermission(final long albumId, final long userId, final Permission permission) {
        if (sharedAlbumPermissionsRepository.hasPermission(albumId, userId, permission)) {
            // If it already exists, do nothing and be idempotent
            return;
        }
        final var sharedAlbumPermission = new SharedAlbumPermission(albumId, userId, permission);
        this.sharedAlbumPermissionsRepository.save(sharedAlbumPermission);
    }
}
