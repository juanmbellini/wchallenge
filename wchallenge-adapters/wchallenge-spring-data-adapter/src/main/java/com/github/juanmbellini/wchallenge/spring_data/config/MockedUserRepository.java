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
