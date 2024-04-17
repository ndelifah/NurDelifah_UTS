package com.example.nurdelifah_uts.ui.login;

public class UserList {

    private String nik_nim;
    private String password;

    public UserList(String nik_nim, String password) {
        this.nik_nim = nik_nim;
        this.password = password;
    }

    public String getNik_nim() {
        return nik_nim;
    }

    public void setNik_nim(String username) {
        this.nik_nim = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
