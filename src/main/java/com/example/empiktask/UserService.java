package com.example.empiktask;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final GithubUserFetcher githubUserFetcher;
    private final GithubUserProcessor githubUserProcessor;
    private final UserCounterService userCounterService;

    public UserService(GithubUserFetcher githubUserFetcher, GithubUserProcessor githubUserProcessor,
            UserCounterService userCounterService) {
        this.githubUserFetcher = githubUserFetcher;
        this.githubUserProcessor = githubUserProcessor;
        this.userCounterService = userCounterService;
    }

    GithubUserInfo fetchUserInfo(String login) {
        GithubUserInfo githubUserInfo = githubUserFetcher.fetchGithubUserInfo(login);
        userCounterService.incrementFetchCount(login);
        return githubUserProcessor.processUserCalculation(githubUserInfo);
    }

}
