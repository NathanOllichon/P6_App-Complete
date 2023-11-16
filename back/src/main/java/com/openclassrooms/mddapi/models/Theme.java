package com.openclassrooms.mddapi.models;

import lombok.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "theme")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@IdClass(Theme.class)
public class Theme {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Id
	private long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;

    @OneToMany(
            mappedBy = "theme", //TODO for mapped spring need that !
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Subscription> subscriptionList;

//    @EmbeddedId
    @OneToMany(
            mappedBy = "id", //TODO for mapped spring need that !
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Article> articleEntities;
}
