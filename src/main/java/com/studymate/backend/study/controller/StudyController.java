package com.studymate.backend.study.controller;

import com.studymate.backend.study.domain.Study;
import com.studymate.backend.study.service.StudyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studies")
public class StudyController {

    private final StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    @PostMapping
    public ResponseEntity<Study> createStudy(@RequestBody Study study) {
        return ResponseEntity.ok(studyService.createStudy(study));
    }

    @GetMapping
    public ResponseEntity<List<Study>> getAllStudies() {
        return ResponseEntity.ok(studyService.getAllStudies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Study> getStudyById(@PathVariable Long id) {
        return studyService.getStudyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Study> updateStudy(@PathVariable Long id, @RequestBody Study study) {
        return ResponseEntity.ok(studyService.updateStudy(id, study));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudy(@PathVariable Long id) {
        studyService.deleteStudy(id);
        return ResponseEntity.noContent().build();
    }
}