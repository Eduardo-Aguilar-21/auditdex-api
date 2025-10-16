package com.ast.auditdex_api.models;

import com.ast.auditdex_api.enums.AuditStatus;
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
@Table(name = "audit_executions",indexes = {
        @Index(name = "idx_execution_audit_id", columnList = "audit_id"),
        @Index(name = "idx_execution_user_id", columnList = "user_id"),
        @Index(name = "idx_execution_company_id", columnList = "company_id"),
        @Index(name = "idx_execution_status", columnList = "status"),
        @Index(name = "idx_execution_created_at", columnList = "createdAt")
})
public class AuditExecutionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuditStatus status;

    // optional: If you want to customize the name
    private String executionTitle;

    // auditor's general observations
    private String notes;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String resultJson;

    @ManyToOne
    @JoinColumn(name = "audit_id", nullable = false)
    private AuditModel audit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel auditor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyModel company;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
