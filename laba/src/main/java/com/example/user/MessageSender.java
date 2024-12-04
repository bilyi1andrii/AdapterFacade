package com.example.user;

public class MessageSender {
    public void send(String text, User user, String country) {
        if (text.equals("My mommy")) {
            System.out.println("Mama I was not asleep at "
            + user.getLastActiveAt());
        } else {
            System.out.println("Why you coming fast????");
        }


        if (country.equals("Ukraine")) {
            System.out.println("Yes! I am from "
            + user.getCountryCode() + "\n");
            System.out.println("My email is " + user.getEmail());
        } else {
            System.out.println("Why not come to my country? It is "
            + user.getCountryCode() + "\n");
            System.out.println("My email is " + user.getEmail());
        }
    }
}
