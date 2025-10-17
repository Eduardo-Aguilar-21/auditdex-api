package com.ast.auditdex_api.repositories;

import com.ast.auditdex_api.enums.AlertSeverity;
import com.ast.auditdex_api.enums.AlertType;
import com.ast.auditdex_api.models.AlertModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<AlertModel, Long> {
    List<AlertModel> findByUserId(Long userId);
    Page<AlertModel> findByUserId(Long userId, Pageable pageable);

    List<AlertModel> findByAuditId(Long auditId);
    Page<AlertModel> findByAuditId(Long auditId, Pageable pageable);

    List<AlertModel> findByExecutionId(Long executionId);
    Page<AlertModel> findByExecutionId(Long executionId, Pageable pageable);

    List<AlertModel> findByType(AlertType type);
    Page<AlertModel> findByType(AlertType type, Pageable pageable);

    List<AlertModel> findBySeverity(AlertSeverity severity);
    Page<AlertModel> findBySeverity(AlertSeverity severity, Pageable pageable);

    List<AlertModel> findByUserIdAndIsReadFalse(Long userId);
    Page<AlertModel> findByUserIdAndIsReadFalse(Long userId, Pageable pageable);

    List<AlertModel> findByCompanyId(Long companyId);
    Page<AlertModel> findByCompanyId(Long companyId, Pageable pageable);

    List<AlertModel> findByCompanyIdAndIsReadFalse(Long companyId);
    Page<AlertModel> findByCompanyIdAndIsReadFalse(Long companyId, Pageable pageable);

    List<AlertModel> findByAuditIdAndIsReadFalse(Long auditId);
    Page<AlertModel> findByAuditIdAndIsReadFalse(Long auditId, Pageable pageable);
}
