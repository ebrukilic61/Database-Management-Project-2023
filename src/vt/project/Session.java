package vt.project;

import java.awt.event.ActionListener;

public class Session {
    private static Login loggedInUser;

    public static Login getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(Login user) {
        loggedInUser = user;
    }
}