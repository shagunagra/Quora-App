package com.upgrad.quora.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upgrad.quora.service.entity.answer;

public interface answerrepo extends JpaRepository<answer, Long> {
}
