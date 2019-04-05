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

package com.github.juanmbellini.wchallenge.jph.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderAddress;

/**
 * Extension of a {@link JsonPlaceholderAddress} that allows instantiation using Jackson.
 */
public class AddressDto extends JsonPlaceholderAddress {

    /**
     * Constructor.
     *
     * @param street      The street of the address.
     * @param suite       The suite.
     * @param city        The city.
     * @param zipCode     The zip code.
     * @param geoLocation The {@link GeoLocationDto} of the address.
     */
    @JsonCreator
    public AddressDto(
            @JsonProperty(value = "street", access = JsonProperty.Access.WRITE_ONLY) final String street,
            @JsonProperty(value = "suite", access = JsonProperty.Access.WRITE_ONLY) final String suite,
            @JsonProperty(value = "city", access = JsonProperty.Access.WRITE_ONLY) final String city,
            @JsonProperty(value = "zipcode", access = JsonProperty.Access.WRITE_ONLY) final String zipCode,
            @JsonProperty(value = "geo", access = JsonProperty.Access.WRITE_ONLY) final GeoLocationDto geoLocation) {
        super(street, suite, city, zipCode, geoLocation);
    }


    /**
     * Extension of a {@link JsonPlaceholderAddress.JsonPlaceholderGeoLocation} that allows instantiation using Jackson.
     */
    private static class GeoLocationDto extends JsonPlaceholderAddress.JsonPlaceholderGeoLocation {

        /**
         * Constructor.
         *
         * @param longitude The longitude.
         * @param latitude  The latitude.
         */
        @JsonCreator
        private GeoLocationDto(
                @JsonProperty(value = "lng", access = JsonProperty.Access.WRITE_ONLY) final double longitude,
                @JsonProperty(value = "lat", access = JsonProperty.Access.WRITE_ONLY) final double latitude) {
            super(longitude, latitude);
        }
    }
}
