package com.ba.obs.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor public class CustomUserModel
{
    private String username;
    private String password;
    private String passwordConfirm;
    private boolean enabled = true;
    private List<Role> roles = new ArrayList<>();

    public CustomUserModel(String username, String password, boolean enabled)
    {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }
}