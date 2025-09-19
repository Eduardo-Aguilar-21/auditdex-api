package com.ast.auditdex_api.mappers;

import com.ast.auditdex_api.dto.AuditTemplateFavoriteDTO;
import com.ast.auditdex_api.models.AuditTemplateFavoriteModel;
import com.ast.auditdex_api.models.CompanyModel;
import com.ast.auditdex_api.models.AuditModel;

public class AuditTemplateFavoriteMapper {

    public static AuditTemplateFavoriteDTO toDTO(AuditTemplateFavoriteModel model) {
        if (model == null) return null;

        AuditTemplateFavoriteDTO dto = new AuditTemplateFavoriteDTO();
        dto.setId(model.getId());
        dto.setCompanyId(model.getCompany().getId());
        dto.setTemplateId(model.getTemplate().getId());
        dto.setFavorite(model.isFavorite());
        dto.setCreatedAt(model.getCreatedAt());
        dto.setUpdatedAt(model.getUpdatedAt());
        return dto;
    }

    public static AuditTemplateFavoriteModel toEntity(AuditTemplateFavoriteDTO dto) {
        if (dto == null) return null;

        CompanyModel company = new CompanyModel();
        company.setId(dto.getCompanyId());

        AuditModel template = new AuditModel();
        template.setId(dto.getTemplateId());

        AuditTemplateFavoriteModel entity = new AuditTemplateFavoriteModel();
        entity.setId(dto.getId());
        entity.setCompany(company);
        entity.setTemplate(template);
        entity.setFavorite(dto.isFavorite());
        return entity;
    }

}
