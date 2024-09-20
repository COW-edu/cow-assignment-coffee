package org.cafe;

import java.util.ArrayList;
import java.util.List;

public class User {
    int total = 0;


    private static User user = new User();

    private User() {
    }

    public static User getUser() {
        return user;
    }


    static List<String> orders = new ArrayList<>();



}
