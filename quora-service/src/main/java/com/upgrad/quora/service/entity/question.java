package com.upgrad.quora.service.entity;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "question")
public class question {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")

    private String uuid;
    private String content;
    private Timestamp date;
    private Long user_id;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private answer answer;

    @ManyToOne
    @JoinColumn(name = "question_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private answer questions;

}
