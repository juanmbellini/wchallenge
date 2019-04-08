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

package com.github.juanmbellini.wchallenge.rest.controller.dtos;

import com.bellotapps.webapps_commons.errors.ConstraintViolationError.ErrorCausePayload.IllegalValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.juanmbellini.wchallenge.models.Permission;
import com.github.juanmbellini.wchallenge.rest.controller.validation.NotNullsInIterable;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * Data transfer object that allows instantiation using jackson.
 * It validates the input.
 */
public class PermissionListDto {

    /**
     * The {@link Permission}s.
     */
    @NotEmpty(message = "The permissions list must not be null nor empty", payload = IllegalValue.class)
    @NotNullsInIterable(message = "The permissions list must not contain nulls", payload = IllegalValue.class)
    private final Set<Permission> permissions;

    @JsonCreator
    public PermissionListDto(
            @JsonProperty(
                    value = "permissions",
                    access = JsonProperty.Access.WRITE_ONLY
            ) final Set<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * @return The {@link Permission}s.
     */
    public Set<Permission> getPermissions() {
        return permissions;
    }
}
