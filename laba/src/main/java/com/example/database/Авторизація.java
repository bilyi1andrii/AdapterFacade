package com.example.database;

public class Авторизація {

    public boolean авторизуватися(БазаДаних db) {
        db.отриматиДаніКористувача();
        return true;
    }
}
