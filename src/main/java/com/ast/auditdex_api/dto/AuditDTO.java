package com.ast.auditdex_api.dto;

import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.enums.AuditType;
import com.ast.auditdex_api.models.CompanyModel;
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
    private String bodyJson;
    private boolean global;
    private Long companyId;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
