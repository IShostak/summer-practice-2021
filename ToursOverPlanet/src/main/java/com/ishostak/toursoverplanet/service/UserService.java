package com.ishostak.toursoverplanet.service;

import com.ishostak.toursoverplanet.dto.RegistrationDto;
import com.ishostak.toursoverplanet.entity.Password;
import com.ishostak.toursoverplanet.entity.User;
import com.ishostak.toursoverplanet.exception.PasswordServiceException;
import com.ishostak.toursoverplanet.exception.UserServiceException;
import com.ishostak.toursoverplanet.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private PasswordService passwordService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordService service, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordService = service;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User create(RegistrationDto dto) throws UserServiceException {
        logger.info("User registration: email = {}", dto.getEmail());

        final Optional<User> userFromDb = userRepository.findByEmail(dto.getEmail());

        if (userFromDb.isPresent()) {
            logger.error("User already exists in DB: email = {}", dto.getEmail());
            throw new UserServiceException("User already exists");
        }

        final User actualUser = userRepository.save(new User(dto.getFullName(), dto.getEmail()));

        try {
            final Password password = passwordService.create(actualUser.getEmail(), passwordEncoder.encode(dto.getPassword()));
        } catch (PasswordServiceException ex) {
            logger.error("Error while register user", ex);
            throw new UserServiceException("Error creating user");
        }

        return actualUser;
    }
}
