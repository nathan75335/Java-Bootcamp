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
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String videoUrl;
    private String title;
    private Integer chapterOrder;
    private Integer displayChapterOrder;

    @Column(name = "chapter_parent_id")
    private Long chapterParentId;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "lines", joinColumns = @JoinColumn(name = "chapter_id"))
    @Column(name = "line", nullable = false)
    private List<String> lines =  new ArrayList<String>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapterparent_id", insertable = false, updatable = false)
    private Chapter chapterParent;

    @OneToMany
    private List<Chapter> chapters = new ArrayList<Chapter>();

    @CreationTimestamp
    public LocalDateTime createdAt;
    @UpdateTimestamp
    public LocalDateTime updatedAt;
}
