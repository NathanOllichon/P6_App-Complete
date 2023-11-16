package com.openclassrooms.mddapi.models;


import lombok.*;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity(name = "subscription")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subscription implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private SubscriptionPrimaryKey id;

    @ManyToOne
    @MapsId("id_user")
    @JoinColumn(name = "FK_id_user", insertable = false, updatable = true)
    User user;

    @ManyToOne
    @MapsId("id_theme")
    @JoinColumn(name = "FK_id_theme", referencedColumnName = "id", insertable = false, updatable = true)
    Theme theme;

}
