package com.ast.auditdex_api.repositories;

import com.ast.auditdex_api.models.AuditTemplateFavoriteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuditTemplateFavoriteRepository extends JpaRepository<AuditTemplateFavoriteModel, Long> {
    Optional<AuditTemplateFavoriteModel> findByCompanyIdAndTemplateId(Long companyId, Long templateId);

    List<AuditTemplateFavoriteModel> findByCompanyId(Long companyId);

    Page<AuditTemplateFavoriteModel> findByCompanyId(Long companyId, Pageable pageable);

    List<AuditTemplateFavoriteModel> findByCompanyIdAndFavoriteTrue(Long companyId);

    Page<AuditTemplateFavoriteModel> findByCompanyIdAndFavoriteTrue(Long companyId, Pageable pageable);
}
