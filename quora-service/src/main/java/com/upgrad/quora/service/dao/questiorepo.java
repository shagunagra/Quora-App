package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface questiorepo extends JpaRepository<question, Long> {
}
