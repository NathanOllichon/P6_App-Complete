package com.openclassrooms.mddapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.models.Subscription;
import com.openclassrooms.mddapi.models.SubscriptionPrimaryKey;

@Repository
public interface SubscriptionDeleteRepository extends JpaRepository<Subscription, SubscriptionPrimaryKey> {

//	void deleteByThemeId_UserId(Long themeId, Long userId);
	
	



    	
}