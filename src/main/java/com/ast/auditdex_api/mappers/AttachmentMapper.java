package com.ast.auditdex_api.mappers;

import com.ast.auditdex_api.dto.AttachmentDTO;
import com.ast.auditdex_api.models.AttachmentModel;
import com.ast.auditdex_api.models.AuditExecutionModel;

public class AttachmentMapper {

    public static AttachmentDTO toDTO(AttachmentModel model) {
        if (model == null) return null;

        AttachmentDTO dto = new AttachmentDTO();
        dto.setId(model.getId());
        dto.setFileType(model.getFileType());
        dto.setFileUrl(model.getFileUrl());
        dto.setFileName(model.getFileName());
        dto.setSize(model.getSize());
        dto.setDescription(model.getDescription());
        dto.setExecutionId(model.getExecution() != null ? model.getExecution().getId() : null);
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());

        return dto;
    }

    public static AttachmentModel toEntity(AttachmentDTO dto) {
        if (dto == null) return null;

        AttachmentModel model = new AttachmentModel();
        model.setId(dto.getId());
        model.setFileType(dto.getFileType());
        model.setFileUrl(dto.getFileUrl());
        model.setFileName(dto.getFileName());
        model.setSize(dto.getSize());
        model.setDescription(dto.getDescription());

        if (dto.getExecutionId() != null) {
            AuditExecutionModel execution = new AuditExecutionModel();
            execution.setId(dto.getExecutionId());
            model.setExecution(execution);
        }

        model.setCreatedAt(dto.getCreatedAt());
        model.setUpdatedAt(dto.getUpdatedAt());

        return model;
    }
}
