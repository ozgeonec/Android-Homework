package com.hfad.mobiletechapp;

/**
 * @author ozgeonec
 */

public class UserListData {

    private String username;
    private String password;
    private int imgId;
    public UserListData(String username, String password, int imgId) {
        this.username = username;
        this.password= password;
        this.imgId = imgId;
    }
    public String getUsername() {
        return this.username;
    }

    public int getImgId() {
        return this.imgId;
    }

    public String getPassword() {
        return this.password;
    }
}
