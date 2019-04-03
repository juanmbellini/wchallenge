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

package com.github.juanmbellini.wchallenge.spring_data.config;

import com.github.juanmbellini.wchallenge.repositories.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * A mocked {@link com.github.juanmbellini.wchallenge.models.User} repository used to boot the application.
 * Remove when Spring Data dependencies are added.
 */
@Repository
// TODO: remove this class as Spring Data will create all the needed repositories.
public class MockedUserRepository implements UserRepository {
}
