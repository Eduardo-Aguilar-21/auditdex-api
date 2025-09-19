package com.ast.auditdex_api.models;

import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.enums.AuditType;
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
@Table(name = "Audit")
public class AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuditStatus auditStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuditType auditType;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String bodyJson;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
