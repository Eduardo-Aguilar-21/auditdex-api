package com.ast.auditdex_api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "attachments",
        indexes = {
                @Index(name = "idx_attachment_execution_id", columnList = "execution_id"),
                @Index(name = "idx_attachment_created_at", columnList = "createdAt")
        }
)
public class AttachmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String fileType; // photo, video, audio

    private String fileUrl;

    private String fileName;

    private String size;

    private String description;

    @ManyToOne
    @JoinColumn(name = "execution_id", referencedColumnName = "id", nullable = false)
    private AuditExecutionModel execution;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

}