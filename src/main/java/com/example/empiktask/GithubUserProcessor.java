package com.example.empiktask;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
class GithubUserProcessor {

    private static final int SCALE = 10;

    GithubUserInfo processUserCalculation(GithubUserInfo githubUserInfo) {
        BigDecimal initialValue = BigDecimal.valueOf(6);
        BigDecimal followersCount = BigDecimal.valueOf(ensureFollowersCountIsNotZero(githubUserInfo.followersCount));
        BigDecimal publicReposCountPlusTwo = BigDecimal.valueOf(githubUserInfo.publicReposCount + 2);

        githubUserInfo.calculation = initialValue.divide(followersCount, SCALE, RoundingMode.DOWN)
                .multiply(publicReposCountPlusTwo);
        return githubUserInfo;
    }
    //If user had no followers then arithmetic exception was thrown, to avoid that case I'm adding extra follower
    //for accounts with zero followers.
    private int ensureFollowersCountIsNotZero(int followersCount) {
        return followersCount == 0 ? 1 : followersCount;
    }
}
