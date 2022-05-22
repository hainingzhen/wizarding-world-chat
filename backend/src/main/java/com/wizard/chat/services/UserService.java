package com.wizard.chat.services;

import com.wizard.chat.models.Wizard;
import com.wizard.chat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Wizard> getAllWizards() {
        return userRepository.findAll();
    }

    public Optional<Wizard> getWizard(Long id) {
        return userRepository.findById(id);
    }

    public List<Wizard> findWizardsByHouse(String house) {
        return userRepository.findByHouse(house);
    }

    public Wizard addNewWizard(Wizard wizard) throws DataIntegrityViolationException {
        return userRepository.save(wizard);
    }
}
