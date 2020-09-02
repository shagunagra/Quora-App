package com.upgrad.quora.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upgrad.quora.service.entity.users;

public interface usersrepo extends JpaRepository<users, Long> {
}
