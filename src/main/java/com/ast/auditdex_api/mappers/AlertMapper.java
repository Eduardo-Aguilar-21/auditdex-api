package com.ast.auditdex_api.mappers;

import com.ast.auditdex_api.dto.AlertDTO;
import com.ast.auditdex_api.models.*;

public class AlertMapper {

    public static AlertDTO toDTO(AlertModel model) {
        if (model == null) return null;

        AlertDTO dto = new AlertDTO();
        dto.setId(model.getId());
        dto.setType(model.getType());
        dto.setSeverity(model.getSeverity());
        dto.setMessage(model.getMessage());
        dto.setObservation(model.getObservation());
        dto.setAuditId(model.getAudit() != null ? model.getAudit().getId() : null);
        dto.setExecutionId(model.getExecution() != null ? model.getExecution().getId() : null);
        dto.setUserId(model.getUser() != null ? model.getUser().getId() : null);
        dto.setRead(model.isRead());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static AlertModel toEntity(AlertDTO dto, AuditModel audit, AuditExecutionModel execution, UserModel user) {
        if (dto == null) return null;

        AlertModel model = new AlertModel();
        model.setId(dto.getId());
        model.setType(dto.getType());
        model.setSeverity(dto.getSeverity());
        model.setMessage(dto.getMessage());
        model.setObservation(dto.getObservation());
        model.setAudit(audit);
        model.setExecution(execution);
        model.setUser(user);
        model.setRead(dto.isRead());
        return model;
    }
}
