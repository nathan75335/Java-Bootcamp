package com.onlinecoursesplatform.repository;

import com.onlinecoursesplatform.entity.Author;
import com.onlinecoursesplatform.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Page<Course> findCoursesById(Long id, Pageable pageable);
}
