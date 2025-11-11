package com.studymate.backend.study.service;

import com.studymate.backend.study.domain.Study;
import com.studymate.backend.study.repository.StudyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudyService {

    private final StudyRepository studyRepository;

    public StudyService(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public Study createStudy(Study study) {
        return studyRepository.save(study);
    }

    public List<Study> getAllStudies() {
        return studyRepository.findAll();
    }

    public Optional<Study> getStudyById(Long id) {
        return studyRepository.findById(id);
    }

    public Study updateStudy(Long id, Study newStudy) {
        Study existing = studyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Study not found with id: " + id));
        existing.update(
                newStudy.getTitle(),
                newStudy.getDescription(),
                newStudy.getCategory(),
                newStudy.getMaxMembers()
        );
        return studyRepository.save(existing);
    }

    public void deleteStudy(Long id) {
        if (!studyRepository.existsById(id)) {
            throw new IllegalArgumentException("Study not found with id: " + id);
        }
        studyRepository.deleteById(id);
    }
}