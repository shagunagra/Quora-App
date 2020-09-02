package com.upgrad.quora.service.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_auth")
public class user_auth {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private String uuid;
    private Long user_id;
    private String access_token;
    private Timestamp expires_at;
    private Timestamp login_at;
    private Timestamp logout_at;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Timestamp getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Timestamp expires_at) {
        this.expires_at = expires_at;
    }

    public Timestamp getLogin_at() {
        return login_at;
    }

    public void setLogin_at(Timestamp login_at) {
        this.login_at = login_at;
    }

    public Timestamp getLogout_at() {
        return logout_at;
    }

    public void setLogout_at(Timestamp logout_at) {
        this.logout_at = logout_at;
    }


}
