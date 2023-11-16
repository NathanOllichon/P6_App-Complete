package com.openclassrooms.mddapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.openclassrooms.mddapi.models.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Subscription s WHERE s.FK_id_theme = ?1 AND s.FK_id_user = ?2", nativeQuery = true)
	void deleteSubscriptionByIds(Long id_theme, Long id_user);
	
}