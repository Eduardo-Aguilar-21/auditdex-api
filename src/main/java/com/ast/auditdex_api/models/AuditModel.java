package com.ast.auditdex_api.models;

import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.enums.AuditType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "audits",
        indexes = {
                @Index(name = "idx_audit_company_id", columnList = "company_id"),
                @Index(name = "idx_audit_status", columnList = "auditStatus"),
                @Index(name = "idx_audit_type", columnList = "auditType"),
                @Index(name = "idx_audit_global", columnList = "global"),
                @Index(name = "idx_audit_created_at", columnList = "createdAt")
        })
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

    @Column(nullable = false)
    private boolean global = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    CompanyModel company;

    @JsonIgnore
    @OneToMany(mappedBy = "audit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuditTemplateFavoriteModel> favorites;

    @JsonIgnore
    @OneToMany(mappedBy = "audit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuditExecutionModel> executions;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
