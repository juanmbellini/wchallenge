package com.github.juanmbellini.wchallenge.domain;

import com.github.juanmbellini.wchallenge.models.User;
import com.github.juanmbellini.wchallenge.repositories.UserRepository;
import com.github.juanmbellini.wchallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Manager for {@link User}s.
 */
@Service
public class UserManager implements UserService {

    /**
     * Repository for {@link User}s.
     */
    private final UserRepository userRepository;

    /**
     * Constructor.
     *
     * @param userRepository Repository for {@link User}s.
     */
    @Autowired
    public UserManager(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
