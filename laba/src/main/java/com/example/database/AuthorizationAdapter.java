package com.example.database;

public class AuthorizationAdapter {
    private Авторизація auth;

    public AuthorizationAdapter(Авторизація auth) {
        this.auth = auth;
    }
    public boolean authorize(БазаДаних db) {
        return auth.авторизуватися(db);
    }
}
