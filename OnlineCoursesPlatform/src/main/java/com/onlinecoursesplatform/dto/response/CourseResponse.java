package com.onlinecoursesplatform.dto.response;

import com.onlinecoursesplatform.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    private Long id;
    private String shortTitle;
    private String title;
    private String description;
    private String languageCode;
    private String videoPresentationUrl;
    private Long isVideoBase;
    private String location;
    private Long courseTypeId;
    private Long categoryId;
    private List<Author> authors = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
