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

package com.github.juanmbellini.wchallenge.spring_data;

import com.github.juanmbellini.wchallenge.models.Permission;
import com.github.juanmbellini.wchallenge.models.SharedAlbumPermission;
import com.github.juanmbellini.wchallenge.repositories.SharedAlbumPermissionsRepository;
import com.github.juanmbellini.wchallenge.spring_data.interfaces.SpringDataSharedAlbumPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A concrete implementation of {@link SharedAlbumPermissionsRepository},
 * which acts as an adapter for a {@link SpringDataSharedAlbumPermissionRepository}.
 */
@Repository
public class SpringDataAlbumPermissionsRepositoryAdapter implements SharedAlbumPermissionsRepository {

    /**
     * The {@link SpringDataAlbumPermissionsRepositoryAdapter} to which operations are delegated.
     */
    private final SpringDataSharedAlbumPermissionRepository repository;

    /**
     * Constructor.
     *
     * @param repository The {@link SpringDataAlbumPermissionsRepositoryAdapter} to which operations are delegated.
     */
    @Autowired
    public SpringDataAlbumPermissionsRepositoryAdapter(final SpringDataSharedAlbumPermissionRepository repository) {
        this.repository = repository;
    }


    @Override
    public <S extends SharedAlbumPermission> S save(final S sharedAlbumPermission)
            throws IllegalArgumentException {
        return repository.save(sharedAlbumPermission);
    }

    @Override
    public <S extends SharedAlbumPermission> void delete(final S sharedAlbumPermission) {
        repository.delete(sharedAlbumPermission);
    }

    @Override
    public List<Long> usersWithPermission(final long albumId, final Permission permission) {
        return repository.getUserIdByAlbumIdAndPermission(albumId, permission).stream()
                .map(SpringDataSharedAlbumPermissionRepository.OnlyUserIdOfSharedAlbumPermissionProjection::getId)
                .collect(Collectors.toList());
    }

    @Override
    public boolean hasPermission(final long albumId, final long userId, final Permission permission) {
        return repository.existsByAlbumIdAndUserIdAndPermission(albumId, userId, permission);
    }

    @Override
    public Optional<SharedAlbumPermission> retrieve(final long albumId, final long userId, final Permission permission) {
        return repository.getByAlbumIdAndUserIdAndPermission(albumId, userId, permission);
    }

    @Override
    public void removeAllForAlbumAndUser(final long albumId, final long userId) {
        repository.deleteByAlbumIdAndUserId(albumId, userId);
    }

    @Override
    public void removeAllForUser(final long userId) {
        repository.deleteByUserId(userId);
    }

    @Override
    public void removeAllForAlbum(final long albumId) {
        repository.deleteByAlbumId(albumId);
    }
}
