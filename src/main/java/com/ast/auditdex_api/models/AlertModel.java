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
@Table(name = "Alert")
public class AlertModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tipo de alerta (ej: vencimiento, hallazgo, recordatorio)
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

    // Relación opcional con auditoría
    @ManyToOne
    @JoinColumn(name = "audit_id")
    private AuditModel audit;

    // Relación opcional con ejecución de auditoría
    @ManyToOne
    @JoinColumn(name = "execution_id")
    private AuditExecutionModel execution;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    // Estado: si ya fue vista / atendida
    @Column(nullable = false)
    private boolean read = false;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}