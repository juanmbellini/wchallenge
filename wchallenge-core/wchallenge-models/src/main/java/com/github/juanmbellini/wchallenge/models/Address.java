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

package com.github.juanmbellini.wchallenge.models;

import org.springframework.util.Assert;

import java.util.Objects;

/**
 * Represents an address of a {@link User}.
 */
public class Address {

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
     * The {@link GeoLocation} of the address.
     */
    private final GeoLocation geoLocation;


    /**
     * Constructor.
     *
     * @param street      The street of the address.
     * @param suite       The suite.
     * @param city        The city.
     * @param zipCode     The zip code.
     * @param geoLocation The {@link GeoLocation} of the address.
     */
    public Address(
            final String street,
            final String suite,
            final String city,
            final String zipCode,
            final GeoLocation geoLocation) {
        Assert.hasText(street, "The street must have text");
        Assert.hasText(suite, "The suite must have text");
        Assert.hasText(city, "The city must have text");
        Assert.hasText(zipCode, "The zip code must have text");
        Assert.notNull(geoLocation, "The geo location must not be null");
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
     * @return The {@link GeoLocation} of the address.
     */
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        final var address = (Address) o;
        return street.equals(address.street) &&
                suite.equals(address.suite) &&
                city.equals(address.city) &&
                zipCode.equals(address.zipCode) &&
                geoLocation.equals(address.geoLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, suite, city, zipCode, geoLocation);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", geoLocation=" + geoLocation +
                '}';
    }


    /**
     * Represents a geo location (i.e a point on The Earth).
     */
    public final static class GeoLocation {

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
        private GeoLocation(final double longitude, final double latitude) {
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


        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof GeoLocation)) {
                return false;
            }
            final var that = (GeoLocation) o;
            return Double.compare(that.longitude, longitude) == 0 && Double.compare(that.latitude, latitude) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(longitude, latitude);
        }

        @Override
        public String toString() {
            return "GeoLocation{" +
                    "longitude=" + longitude +
                    ", latitude=" + latitude +
                    '}';
        }
    }
}
