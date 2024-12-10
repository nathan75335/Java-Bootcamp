package com.onlinecoursesplatform.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    @NotBlank
    private String shortTitle;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String languageCode;
    @NotBlank
    private String videoPresentationUrl;
    @NotNull
    private Boolean isVideoBase;
    @NotBlank
    private String location;
    @NotNull
    private Long courseTypeId;
    @NotNull
    private Long categoryId;
}
