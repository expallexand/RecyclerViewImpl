package com.example.alekseynd.recyclerviewimpl.data;

public class User {

    private String mFirstname;
    private String mSecondName;

    public User(String firstName, String secondName) {
        mFirstname = firstName;
        mSecondName = secondName;
    }

    public String getFirstname() {
        return mFirstname;
    }

    public String getSecondName() {
        return mSecondName;
    }
}
