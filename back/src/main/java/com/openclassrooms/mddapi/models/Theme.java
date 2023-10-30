package com.openclassrooms.mddapi.models;

import lombok.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "theme")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Theme {

    @Id
    private long id;

    @Column(name = "titre")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(
            mappedBy = "theme", //TODO for mapped spring need that !
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Subscription> subscriptionList;

    
    @OneToMany(
            mappedBy = "id", //TODO for mapped spring need that !
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @EmbeddedId
    private List<Article> articleEntities;
}
