package com.example.empiktask;

import org.springframework.stereotype.Service;

@Service
public class UserCounterService {

    private final UserCounterRepository userCounterRepository;

    public UserCounterService(UserCounterRepository userCounterRepository) {
        this.userCounterRepository = userCounterRepository;
    }

    void incrementFetchCount(String login) {
        userCounterRepository.findById(login).ifPresentOrElse(
                this::incrementCounter,
                () -> addLogin(login)
        );
    }

    private void addLogin(String login) {
        UserCounter newUserCounter = new UserCounter(login, 1);
        userCounterRepository.save(newUserCounter);
    }

    private void incrementCounter(UserCounter userCounter) {
        userCounter.setCounter(userCounter.getCounter() + 1);
        userCounterRepository.save(userCounter);
    }
}
