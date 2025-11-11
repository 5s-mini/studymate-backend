package com.studymate.backend.study.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudyRequest {
    private String title;
    private String description;
    private String category;
    private Integer maxMembers;
    private Long leaderId;
}