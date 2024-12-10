package com.onlinecoursesplatform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortTitle;
    private String title;
    private String description;
    private String languageCode;
    private String videoPresentationUrl;
    private Boolean isVideoBase;
    private String location;
    //private boolean isOnline;
    @Column(name = "coursetype_id")
    private Long courseTypeId;
    @Column(name = "category_id")
    private Long categoryId;
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "coursertype_id")
    private CourseType courseType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "category_id")
    private Category category;
    @ManyToMany(mappedBy = "courses")
    private List<Author> authors = new ArrayList<>();
    @OneToMany
    private List<Chapter> chapters = new ArrayList<>();
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
 }
