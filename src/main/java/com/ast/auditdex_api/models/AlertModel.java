package com.ast.auditdex_api.models;


import com.ast.auditdex_api.enums.AlertSeverity;
import com.ast.auditdex_api.enums.AlertType;
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
        name = "alerts",
        indexes = {
                @Index(name = "idx_alert_audit_id", columnList = "audit_id"),
                @Index(name = "idx_alert_execution_id", columnList = "execution_id"),
                @Index(name = "idx_alert_company_id", columnList = "company_id"),
                @Index(name = "idx_alert_user_id", columnList = "user_id"),
                @Index(name = "idx_alert_read", columnList = "read"),
                @Index(name = "idx_alert_created_at", columnList = "createdAt")
        }
)
public class AlertModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlertType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlertSeverity severity;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(nullable = false, length = 500)
    private String observation;

    @ManyToOne
    @JoinColumn(name = "audit_id")
    private AuditModel audit;

    @ManyToOne
    @JoinColumn(name = "execution_id")
    private AuditExecutionModel execution;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyModel company;

    // Estado: si ya fue vista / atendida
    @Column(nullable = false)
    private boolean read = false;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}