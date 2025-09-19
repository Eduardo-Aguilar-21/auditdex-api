package com.ast.auditdex_api.dto;

import com.ast.auditdex_api.enums.AlertSeverity;
import com.ast.auditdex_api.enums.AlertType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertDTO {
    private Long id;
    private AlertType type;
    private AlertSeverity severity;
    private String message;
    private String observation;
    private Long auditId;
    private Long executionId;
    private Long userId;
    private boolean read;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}