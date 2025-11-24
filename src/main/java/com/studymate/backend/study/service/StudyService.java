package com.studymate.backend.study.service;

import com.studymate.backend.study.domain.Study;
import com.studymate.backend.study.dto.StudyRequest;
import com.studymate.backend.study.dto.StudyResponse;
import com.studymate.backend.study.repository.StudyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudyService {

    private final StudyRepository studyRepository;

    public StudyService(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public StudyResponse createStudy(StudyRequest studyRequest) {
        Study study = Study.builder()
                .title(studyRequest.getTitle())
                .description(studyRequest.getDescription())
                .category(studyRequest.getCategory())
                .leaderId(studyRequest.getLeaderId())
                .maxMembers(studyRequest.getMaxMembers())
                .build();
        return toResponse(studyRepository.save(study));
    }

    public List<StudyResponse> getAllStudies() {
        return studyRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<StudyResponse> getStudyById(Long id) {
        return studyRepository.findById(id)
                .map(this::toResponse);
    }

    public StudyResponse updateStudy(Long id, StudyRequest newStudy) {
        Study existing = studyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Study not found with id: " + id));
        existing.update(
                newStudy.getTitle(),
                newStudy.getDescription(),
                newStudy.getCategory(),
                newStudy.getMaxMembers()
        );
        return toResponse(studyRepository.save(existing));
    }

    public void deleteStudy(Long id) {
        if (!studyRepository.existsById(id)) {
            throw new IllegalArgumentException("Study not found with id: " + id);
        }
        studyRepository.deleteById(id);
    }

    private StudyResponse toResponse(Study study) {
        return StudyResponse.builder()
                .id(study.getId())
                .title(study.getTitle())
                .description(study.getDescription())
                .category(study.getCategory())
                .leaderId(study.getLeaderId())
                .maxMembers(study.getMaxMembers())
                .createdAt(study.getCreatedAt())
                .build();
    }
}