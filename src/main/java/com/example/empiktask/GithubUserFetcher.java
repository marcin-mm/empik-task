package com.example.empiktask;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubUserFetcher {

    private RestTemplate restTemplate;

    @Value("${github.api.users}")
    private String githubApiUsers;

    public GithubUserFetcher(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    GithubUserInfo fetchGithubUserInfo(String login) {
        URI githubUserApiUri = URI.create(String.format("%s/%s", githubApiUsers, login));
        return restTemplate.getForEntity(githubUserApiUri, GithubUserInfo.class).getBody();
    }
}
