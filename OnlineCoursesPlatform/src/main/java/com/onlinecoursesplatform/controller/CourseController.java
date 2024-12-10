package com.onlinecoursesplatform.controller;

import com.onlinecoursesplatform.dto.request.CourseRequest;
import com.onlinecoursesplatform.dto.response.CourseResponse;
import com.onlinecoursesplatform.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponse> createCourse(@RequestBody @Valid CourseRequest courseRequest) {
        return ResponseEntity
                .status(201)
                .body(courseService.createCourse(courseRequest));
    }

    @GetMapping
    public ResponseEntity<Page<CourseResponse>> getCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "DESC") String sortDirection) {
        return ResponseEntity.ok(courseService.getCourses(page, size, sortDirection));
    }

    @GetMapping("/authors/{authorId}")
    public ResponseEntity<Page<CourseResponse>> getCoursesByAuthorId(
            @PathVariable long authorId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "DESC") String sortDirection) {
        return ResponseEntity.ok(courseService.getCoursesByAuthorId(authorId, page, size, sortDirection));
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<CourseResponse> updateCourse(
            @PathVariable long courseId,
            @RequestBody @Valid CourseRequest courseRequest) {
        return ResponseEntity.ok(courseService.updateCourse(courseId, courseRequest));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable long courseId) {
        return ResponseEntity.ok(courseService.deleteCourse(courseId));
    }
}
