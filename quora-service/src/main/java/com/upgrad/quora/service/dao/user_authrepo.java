package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.user_auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface user_authrepo extends JpaRepository<user_auth, Long> {
}
