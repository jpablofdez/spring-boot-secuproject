package com.security.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.jwt.models.FileData;

public interface FileRepository extends JpaRepository<FileData, Long> {
	 // List<Tutorial> findByPublished(boolean published);
	 // List<Tutorial> findByTitleContaining(String title);
	}