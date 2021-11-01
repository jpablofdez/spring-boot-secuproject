package com.security.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.security.jwt.models.Group;
import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}