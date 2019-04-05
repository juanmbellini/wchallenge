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

package com.github.juanmbellini.wchallenge.models.json_placeholder;

/**
 * Data transfer object for receiving address information from the Json Placeholder service.
 */
public class JsonPlaceholderAddress {

    /**
     * The street of the address.
     */
    private final String street;
    /**
     * The suite.
     */
    private final String suite;
    /**
     * The city.
     */
    private final String city;
    /**
     * The zip code.
     */
    private final String zipCode;
    /**
     * The {@link JsonPlaceholderGeoLocation} of the address.
     */
    private final JsonPlaceholderGeoLocation geoLocation;


    /**
     * Constructor.
     *
     * @param street      The street of the address.
     * @param suite       The suite.
     * @param city        The city.
     * @param zipCode     The zip code.
     * @param geoLocation The {@link JsonPlaceholderGeoLocation} of the address.
     */
    public JsonPlaceholderAddress(
            final String street,
            final String suite,
            final String city,
            final String zipCode,
            final JsonPlaceholderGeoLocation geoLocation) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipCode = zipCode;
        this.geoLocation = geoLocation;
    }


    /**
     * @return The street of the address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * @return The suite.
     */
    public String getSuite() {
        return suite;
    }

    /**
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @return The zip code.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @return The {@link JsonPlaceholderGeoLocation} of the address.
     */
    public JsonPlaceholderGeoLocation getGeoLocation() {
        return geoLocation;
    }


    /**
     * Data transfer object for receiving geo location information from the Json Placeholder service.
     */
    public static class JsonPlaceholderGeoLocation {

        /**
         * The longitude.
         */
        private final double longitude;

        /**
         * The latitude.
         */
        private final double latitude;


        /**
         * Constructor.
         *
         * @param longitude The longitude.
         * @param latitude  The latitude.
         */
        public JsonPlaceholderGeoLocation(
                final double longitude,
                final double latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }


        /**
         * @return The longitude.
         */
        public double getLongitude() {
            return longitude;
        }

        /**
         * @return The latitude.
         */
        public double getLatitude() {
            return latitude;
        }
    }
}
