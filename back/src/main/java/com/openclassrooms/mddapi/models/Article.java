package com.openclassrooms.mddapi.models;

import lombok.*;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.Instant;
import java.util.List;

@Entity(name = "article")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_article")
	private Long id;

    @Column(name = "titre")
    private String titre;
    
    @Column(name = "contenu")
    private String contenu;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant created_at;

    @ManyToOne
    @JoinColumn(name = "fk_id_theme", updatable = false)
    private Theme theme;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_user", updatable = false)
    private User user;

    @OneToMany(
            mappedBy = "articleEntity",
            cascade = CascadeType.ALL
    )
    private List<Comment> comments;
}
