package com.openclassrooms.mddapi.models;


import lombok.*;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity(name = "subscription")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subscription {

    @EmbeddedId
    private SubscriptionPrimaryKey id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "FK_id_user", insertable = false, updatable = false)
    User user;

    @ManyToOne
    @MapsId("theme_id")
    @JoinColumn(name = "FK_id_theme", insertable = false, updatable = false)
    Theme theme;

}
