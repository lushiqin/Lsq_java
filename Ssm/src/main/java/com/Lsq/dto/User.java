package com.Lsq.dto;
public class User {
    private Integer id;

    private String username;

    private String usermobi;

    private String useradde;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsermobi() {
        return usermobi;
    }

    public void setUsermobi(String usermobi) {
        this.usermobi = usermobi == null ? null : usermobi.trim();
    }

    public String getUseradde() {
        return useradde;
    }

    public void setUseradde(String useradde) {
        this.useradde = useradde == null ? null : useradde.trim();
    }
}