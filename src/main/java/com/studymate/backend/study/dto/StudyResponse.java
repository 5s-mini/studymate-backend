package com.studymate.backend.study.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudyResponse {
    private Long id;
    private String title;
    private String description;
    private String category;
    private Long leaderId;
    private Integer maxMembers;
    private LocalDateTime createdAt;
}