package com.frico.website.common.model;

import lombok.Data;

@Data
public class LoginInfo {
    private String username;
    private String realName;
    private Integer ip;
    private Integer id;
    private String sessionId;
}
