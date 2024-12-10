package com.onlinecoursesplatform.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {
    public Long id;
    public String email;
    public String password;
    public String firstName;
    public String lastName;
    private String displayName;
    private String miniBiography;
    private String profilePicture;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
