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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.juanmbellini.wchallenge.models.json_placeholder.JsonPlaceholderAddress;

/**
 * Extension of {@link JsonPlaceholderAddress} used for sending address information through our REST API.
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
    private AddressDto(
            final String street,
            final String suite,
            final String city,
            final String zipCode,
            final GeoLocationDto geoLocation) {
        super(street, suite, city, zipCode, geoLocation);
    }


    /**
     * @return The street of the address.
     */
    @JsonProperty(value = "street", access = JsonProperty.Access.READ_ONLY)
    public String getStreet() {
        return super.getStreet();
    }

    /**
     * @return The suite.
     */
    @JsonProperty(value = "suite", access = JsonProperty.Access.READ_ONLY)
    public String getSuite() {
        return super.getSuite();
    }

    /**
     * @return The city.
     */
    @JsonProperty(value = "city", access = JsonProperty.Access.READ_ONLY)
    public String getCity() {
        return super.getCity();
    }

    /**
     * @return The zip code.
     */
    @JsonProperty(value = "zipcode", access = JsonProperty.Access.READ_ONLY)
    public String getZipCode() {
        return super.getZipCode();
    }

    /**
     * @return The {@link GeoLocationDto} of the address.
     */
    @JsonProperty(value = "geo", access = JsonProperty.Access.READ_ONLY)
    public JsonPlaceholderGeoLocation getGeoLocation() {
        return super.getGeoLocation();
    }


    /**
     * Data transfer object for receiving geo location information from the Json Placeholder service.
     */
    public static class GeoLocationDto extends JsonPlaceholderGeoLocation {

        /**
         * Constructor.
         *
         * @param longitude The longitude.
         * @param latitude  The latitude.
         */
        public GeoLocationDto(final double longitude, final double latitude) {
            super(longitude, latitude);
        }


        /**
         * @return The longitude.
         */
        @JsonProperty(value = "lng", access = JsonProperty.Access.READ_ONLY)
        public double getLongitude() {
            return super.getLongitude();
        }

        /**
         * @return The latitude.
         */
        @JsonProperty(value = "lat", access = JsonProperty.Access.READ_ONLY)
        public double getLatitude() {
            return super.getLatitude();
        }
    }

    /**
     * Factory method that creates an {@link AddressDto} from a {@link JsonPlaceholderAddress}.
     *
     * @param address The {@link JsonPlaceholderAddress} from where data will be taken.
     * @return The given {@code address} but with an {@link AddressDto} view.
     */
    public static AddressDto fromJsonPlaceholderAddress(final JsonPlaceholderAddress address) {
        final var geoLocation = address.getGeoLocation();
        return new AddressDto(
                address.getStreet(),
                address.getSuite(),
                address.getCity(),
                address.getZipCode(),
                new GeoLocationDto(
                        geoLocation.getLongitude(),
                        geoLocation.getLatitude()
                )
        );
    }
}
