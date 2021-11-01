package com.security.jwt.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.security.jwt.models.User;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	User findByEmailContaining(String email);
	
	@Query(
            value = "SELECT COUNT(*) FROM users WHERE event_id = ?1",
            nativeQuery = true
    )
    int findAllByEvent(Long id);

    @Query(
            value = "SELECT users.first_name, users.last_name, users.age, users.email, events.name \n" +
                    "AS event_name FROM users INNER JOIN events ON users.event_id = events.id",
            nativeQuery = true)
    List<?> findAllBookings();
}