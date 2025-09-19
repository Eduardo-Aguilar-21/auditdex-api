package com.ast.auditdex_api.dto;

import com.ast.auditdex_api.enums.AuditStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditExecutionDTO {
    private Long id;
    private Long auditId;
    private Long auditorId;
    private AuditStatus status;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
