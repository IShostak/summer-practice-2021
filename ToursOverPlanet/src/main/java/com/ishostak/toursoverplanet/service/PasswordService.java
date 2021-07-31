package com.ishostak.toursoverplanet.service;

import com.ishostak.toursoverplanet.dto.RegistrationDto;
import com.ishostak.toursoverplanet.entity.Password;
import com.ishostak.toursoverplanet.entity.User;
import com.ishostak.toursoverplanet.exception.PasswordServiceException;
import com.ishostak.toursoverplanet.repository.PasswordRepository;
import com.ishostak.toursoverplanet.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
public class PasswordService {
    private final static Logger logger = LoggerFactory.getLogger(PasswordService.class);

    private PasswordRepository passwordRepository;
    private UserRepository userRepository;

    @Autowired
    public PasswordService(PasswordRepository passwordRepository, UserRepository userRepository) {
        this.passwordRepository = passwordRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Password create(String email, String userPassword) throws PasswordServiceException {
        try {
            final User user = userRepository.findByEmail(email)
                    .orElseThrow(()-> new NoSuchElementException("User was not found"));

            logger.debug("Trying to save password for user {} ", email);

            Password password = passwordRepository.saveAndFlush(new Password(user, userPassword));

            return password;
        } catch (Exception ex) {
            logger.error("Error saving password", ex);
            throw new PasswordServiceException("Error while inserting password into db");
        }
    }
}
