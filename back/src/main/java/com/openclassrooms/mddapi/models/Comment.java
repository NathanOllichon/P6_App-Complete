package com.openclassrooms.mddapi.models;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity(name = "commentaire")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_commentaire")
	private Long id;

    @Column(name = "contenu")
    private String contenu;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant created_at;

    @ManyToOne
    @JoinColumn(name = "FK_id_user", nullable = false)
    private User userEntity;
    
    @ManyToOne
    @JoinColumn(name = "FK_id_article", nullable = false)
    private Article articleEntity;
}
