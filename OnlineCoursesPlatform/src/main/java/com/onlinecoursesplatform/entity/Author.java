package com.onlinecoursesplatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@DiscriminatorValue("AUTHOR")
public class Author extends User {
    private String displayName;
    private String miniBiography;
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
}
