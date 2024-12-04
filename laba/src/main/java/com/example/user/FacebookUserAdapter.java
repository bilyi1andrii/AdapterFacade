package com.example.user;

public class FacebookUserAdapter implements User {
    private final FacebookUser facebookUser;


    public FacebookUserAdapter(FacebookUser facebookUser) {
        this.facebookUser = facebookUser;
    }

    @Override
    public String getEmail() {
        return facebookUser.getEmail();
    }

    @Override
    public String getCountryCode() {
        return facebookUser.getUserCountry();
    }

    @Override
    public long getLastActiveAt() {
        return facebookUser.getUserActiveTime();
    }

}