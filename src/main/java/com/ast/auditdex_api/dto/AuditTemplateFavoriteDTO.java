package com.ast.auditdex_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditTemplateFavoriteDTO {
    private Long id;
    private Long companyId;
    private Long templateId;
    private boolean favorite;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
