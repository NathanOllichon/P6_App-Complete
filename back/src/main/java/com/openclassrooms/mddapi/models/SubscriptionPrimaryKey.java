package com.openclassrooms.mddapi.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * The type Subscription primary key.
 */
@Embeddable
@Getter
@Setter
public class SubscriptionPrimaryKey{
	
    @Column(name = "user_id")
    Long user_id;


    @Column(name = "theme_id")
    Long theme_id;
}
