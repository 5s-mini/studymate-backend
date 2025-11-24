package com.studymate.backend.study.controller;

import com.studymate.backend.study.dto.StudyRequest;
import com.studymate.backend.study.dto.StudyResponse;
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
    public ResponseEntity<StudyResponse> createStudy(@RequestBody StudyRequest studyRequest) {
        return ResponseEntity.ok(studyService.createStudy(studyRequest));
    }

    @GetMapping
    public ResponseEntity<List<StudyResponse>> getAllStudies() {
        return ResponseEntity.ok(studyService.getAllStudies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyResponse> getStudyById(@PathVariable Long id) {
        return studyService.getStudyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudyResponse> updateStudy(@PathVariable Long id, @RequestBody StudyRequest studyRequest) {
        return ResponseEntity.ok(studyService.updateStudy(id, studyRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudy(@PathVariable Long id) {
        studyService.deleteStudy(id);
        return ResponseEntity.noContent().build();
    }
}