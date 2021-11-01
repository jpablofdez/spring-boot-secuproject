package com.security.jwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.jwt.models.ni_project_npi;


@Repository
public interface ProjectRepository extends JpaRepository<ni_project_npi, Long>{

}