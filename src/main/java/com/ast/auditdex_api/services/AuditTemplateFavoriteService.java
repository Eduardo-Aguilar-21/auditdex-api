package com.ast.auditdex_api.services;

import com.ast.auditdex_api.dto.AuditTemplateFavoriteDTO;
import com.ast.auditdex_api.models.AuditTemplateFavoriteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AuditTemplateFavoriteService {

    Optional<AuditTemplateFavoriteDTO> findById(Long id);

    AuditTemplateFavoriteDTO save(AuditTemplateFavoriteDTO dto);

    AuditTemplateFavoriteDTO update(AuditTemplateFavoriteDTO dto);

    void deleteById(Long id);

    List<AuditTemplateFavoriteModel> findByCompany(Long companyId);

    Page<AuditTemplateFavoriteModel> findByCompany(Long companyId, Pageable pageable);

    List<AuditTemplateFavoriteModel> findFavoritesByCompany(Long companyId);

    Page<AuditTemplateFavoriteModel> findFavoritesByCompany(Long companyId, Pageable pageable);

    Optional<AuditTemplateFavoriteDTO> findByCompanyAndTemplate(Long companyId, Long templateId);
}
