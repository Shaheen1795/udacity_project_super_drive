package com.udacity.jwdnd.course1.cloudstorage.model;

/**
 * credentialid INT PRIMARY KEY auto_increment,
 *     url VARCHAR(100),
 *     username VARCHAR (30),
 *     key VARCHAR,
 *     password VARCHAR,
 *     userid INT,
 */
public class CredentialData {
    Integer credentialId ;
    String url;
    String username  ;
    String key ;
    String password;
    Integer userId;



    public CredentialData(Integer credentialId, String url, String username, String key, String password, Integer userId) {

        this.credentialId = credentialId ;
        this.url = url;
        this.username = username;
        this.key = key;
        this.password = password;
        this.userId = userId;
    }
    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
