package com.ast.auditdex_api.repositories;

import com.ast.auditdex_api.models.AuditExecutionModel;
import com.ast.auditdex_api.enums.AuditStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditExecutionRepository extends JpaRepository<AuditExecutionModel, Long> {

    List<AuditExecutionModel> findByAuditId(Long auditId);
    Page<AuditExecutionModel> findByAuditId(Long auditId, Pageable pageable);

    List<AuditExecutionModel> findByAuditorId(Long auditorId);
    Page<AuditExecutionModel> findByAuditorId(Long auditorId, Pageable pageable);

    List<AuditExecutionModel> findByStatus(AuditStatus status);
    Page<AuditExecutionModel> findByStatus(AuditStatus status, Pageable pageable);

    List<AuditExecutionModel> findByCompanyId(Long companyId);
    Page<AuditExecutionModel> findByCompanyId(Long companyId, Pageable pageable);
}
