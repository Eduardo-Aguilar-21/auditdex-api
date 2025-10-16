package com.ast.auditdex_api.repositories;

import com.ast.auditdex_api.models.AuditModel;
import com.ast.auditdex_api.models.AuditTemplateFavoriteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuditTemplateFavoriteRepository extends JpaRepository<AuditTemplateFavoriteModel, Long> {
    Optional<AuditTemplateFavoriteModel> findByCompanyIdAndAuditId(Long companyId, Long auditId);

    List<AuditTemplateFavoriteModel> findByCompanyId(Long companyId);

    Page<AuditTemplateFavoriteModel> findByCompanyId(Long companyId, Pageable pageable);

    List<AuditTemplateFavoriteModel> findByCompanyIdAndFavoriteTrue(Long companyId);

    Page<AuditTemplateFavoriteModel> findByCompanyIdAndFavoriteTrue(Long companyId, Pageable pageable);

    @Query("""
                SELECT f.audit
                FROM AuditTemplateFavoriteModel f
                WHERE f.company.id = :companyId
                AND f.favorite = true
            """)
    List<AuditModel> findFavoriteAuditsByCompanyId(@Param("companyId") Long companyId);
}
