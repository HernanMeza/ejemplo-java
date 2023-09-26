package com.ntt.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ntt.app.vo.entity.UserEntity;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the user entity
	 */
	UserEntity findByEmail(@Param("email") String email);

}
