package com.ast.auditdex_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "audit_template_favorites",
        indexes = {
                @Index(name = "idx_favorite_company_id", columnList = "company_id"),
                @Index(name = "idx_favorite_audit_id", columnList = "audit_id"),
                @Index(name = "idx_favorite_company_audit", columnList = "company_id, audit_id", unique = true),
                @Index(name = "idx_favorite_created_at", columnList = "createdAt")
        })
public class AuditTemplateFavoriteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private boolean favorite = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private CompanyModel company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audit_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AuditModel audit;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
