package com.ast.auditdex_api.dto;

import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.enums.AuditType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDTO {
    private Long id;
    private String title;
    private AuditStatus auditStatus;
    private AuditType auditType;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
