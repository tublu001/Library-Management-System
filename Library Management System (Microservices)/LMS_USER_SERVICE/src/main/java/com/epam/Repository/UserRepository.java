package com.epam.Repository;

import com.epam.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String userName);
}
