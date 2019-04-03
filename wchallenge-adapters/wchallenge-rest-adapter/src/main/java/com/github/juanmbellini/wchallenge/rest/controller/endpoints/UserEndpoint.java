package com.github.juanmbellini.wchallenge.rest.controller.endpoints;

import com.github.juanmbellini.wchallenge.models.User;
import com.github.juanmbellini.wchallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * API endpoint for {@link User} management.
 */
@Component
public class UserEndpoint {

    /**
     * The {@link UserService} that will be used to manage {@link User}s.
     */
    private final UserService userService;

    /**
     * Constructor.
     *
     * @param userService The {@link UserService} that will be used to manage {@link User}s.
     */
    @Autowired
    public UserEndpoint(final UserService userService) {
        this.userService = userService;
    }
}
