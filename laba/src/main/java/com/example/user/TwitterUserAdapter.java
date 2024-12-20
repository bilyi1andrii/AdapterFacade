package com.example.user;

public class TwitterUserAdapter implements User {
    private final TwitterUser twitterUser;


    public TwitterUserAdapter(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    @Override
    public String getEmail() {
        return twitterUser.getUserEmail();
    }

    @Override
    public String getCountryCode() {
        return twitterUser.getCountry();
    }

    @Override
    public long getLastActiveAt() {
        return twitterUser.getLastActiveTime();
    }


}
