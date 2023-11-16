package com.openclassrooms.mddapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * The type Subscription primary key.
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPrimaryKey implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "FK_id_user")
    Long user_id;

    @Column(name = "FK_id_theme")
    Long theme_id;
}
