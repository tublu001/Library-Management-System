package com.epam.repository;

import com.epam.security.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long>
{
    List<AuthGroup> findByUsername(String username);
}