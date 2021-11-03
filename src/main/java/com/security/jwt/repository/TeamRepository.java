package com.security.jwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.jwt.models.ni_team;


@Repository
public interface TeamRepository extends JpaRepository<ni_team, Long>{

}