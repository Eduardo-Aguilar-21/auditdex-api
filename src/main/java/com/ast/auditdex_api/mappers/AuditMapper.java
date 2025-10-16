package com.ast.auditdex_api.mappers;

import com.ast.auditdex_api.dto.AuditDTO;
import com.ast.auditdex_api.models.AuditModel;
import com.ast.auditdex_api.models.CompanyModel;

public class AuditMapper {

    public static AuditDTO toDTO(AuditModel entity) {
        if (entity == null) return null;

        AuditDTO dto = new AuditDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setAuditStatus(entity.getAuditStatus());
        dto.setAuditType(entity.getAuditType());
        dto.setGlobal(entity.isGlobal());
        dto.setBodyJson(entity.getBodyJson());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        if (entity.getCompany() != null) {
            dto.setCompanyId(entity.getCompany().getId());
        }

        return dto;
    }

    public static AuditModel toEntity(AuditDTO dto) {
        if (dto == null) return null;

        AuditModel entity = new AuditModel();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setAuditStatus(dto.getAuditStatus());
        entity.setAuditType(dto.getAuditType());
        entity.setGlobal(dto.isGlobal());
        entity.setBodyJson(dto.getBodyJson());

        if (dto.getCompanyId() != null) {
            CompanyModel company = new CompanyModel();
            company.setId(dto.getCompanyId());
            entity.setCompany(company);
        }

        return entity;
    }
}
