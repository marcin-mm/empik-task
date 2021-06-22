package com.example.empiktask;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class GithubUserInfo {

    String id;

    String login;

    String name;

    String type;

    @JsonProperty("avatar_url")
    String avatarUrl;

    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty("followers")
    int followersCount;

    @JsonProperty("public_repos")
    int publicReposCount;

    BigDecimal calculation;
}

