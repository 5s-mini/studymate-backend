package com.studymate.backend.study.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "studies")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private String category;

    @Column(name = "leader_id")
    private Long leaderId;

    @Column(name = "max_members")
    private Integer maxMembers;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public void update(String title, String description, String category, Integer maxMembers) {
        if (title != null) this.title = title;
        if (description != null) this.description = description;
        if (category != null) this.category = category;
        if (maxMembers != null) this.maxMembers = maxMembers;
    }
}