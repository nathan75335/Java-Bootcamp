package com.onlinecoursesplatform.service;

import com.onlinecoursesplatform.dto.request.CourseRequest;
import com.onlinecoursesplatform.dto.response.CourseResponse;
import com.onlinecoursesplatform.entity.Course;
import com.onlinecoursesplatform.exception.CourseNotFoundException;
import com.onlinecoursesplatform.repository.AuthorRepository;
import com.onlinecoursesplatform.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final AuthorRepository authorRepository;
    @Autowired
    private final ModelMapper modelMapper;

    private Course getOneCourseById(Long courseId){
        return courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
    }

    public CourseResponse createCourse(CourseRequest request){
        Course course = modelMapper.map(request, Course.class);
        return modelMapper.map(courseRepository.save(course), CourseResponse.class);
    }

    public Page<CourseResponse> getCourses(Integer page, Integer size, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), "createdAt");
        Pageable pageable = PageRequest.of(page, size, sort);
        return modelMapper.map(courseRepository.findAll(pageable), new TypeToken<Page<CourseResponse>>(){}.getType());
    }

    public Page<CourseResponse> getCoursesByAuthorId(Long authorId, Integer page, Integer size, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), "createdAt");
        Pageable pageable = PageRequest.of(page, size, sort);
        return modelMapper.map(authorRepository.findCoursesById(authorId, pageable), new TypeToken<Page<CourseResponse>>(){}.getType());
    }

    public CourseResponse updateCourse(Long courseId, CourseRequest request){
        Course course = getOneCourseById(courseId);
        modelMapper.map(course, request);
        return modelMapper.map(courseRepository.save(course), CourseResponse.class);
    }

    public String deleteCourse(Long courseId){
        Course course = getOneCourseById(courseId);
        courseRepository.delete(course);
        return String.format("Course with id  %s deleted", courseId);
    }


}
