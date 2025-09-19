package com.ast.auditdex_api.mappers;

import com.ast.auditdex_api.dto.AuditExecutionDTO;
import com.ast.auditdex_api.models.AuditExecutionModel;
import com.ast.auditdex_api.models.AuditModel;
import com.ast.auditdex_api.models.UserModel;

public class AuditExecutionMapper {

    public static AuditExecutionDTO toDTO(AuditExecutionModel model) {
        if (model == null) return null;

        AuditExecutionDTO dto = new AuditExecutionDTO();
        dto.setId(model.getId());
        dto.setAuditId(model.getAudit() != null ? model.getAudit().getId() : null);
        dto.setAuditorId(model.getAuditor() != null ? model.getAuditor().getId() : null);
        dto.setStatus(model.getStatus());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());

        return dto;
    }

    public static AuditExecutionModel toEntity(AuditExecutionDTO dto) {
        if (dto == null) return null;

        AuditExecutionModel model = new AuditExecutionModel();
        model.setId(dto.getId());

        if (dto.getAuditId() != null) {
            AuditModel audit = new AuditModel();
            audit.setId(dto.getAuditId());
            model.setAudit(audit);
        }

        if (dto.getAuditorId() != null) {
            UserModel auditor = new UserModel();
            auditor.setId(dto.getAuditorId());
            model.setAuditor(auditor);
        }

        model.setStatus(dto.getStatus());
        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());

        return model;
    }
}
