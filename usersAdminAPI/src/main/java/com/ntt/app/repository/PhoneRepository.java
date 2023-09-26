package com.ntt.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntt.app.vo.entity.PhoneEntity;

/**
 * The Interface PhoneRepository.
 */
@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, UUID> {
	
}
