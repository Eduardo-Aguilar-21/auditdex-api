package com.ast.auditdex_api.services;

import com.ast.auditdex_api.dto.AlertDTO;
import com.ast.auditdex_api.enums.AlertSeverity;
import com.ast.auditdex_api.enums.AlertType;
import com.ast.auditdex_api.models.AlertModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AlertService {

    Optional<AlertDTO> findById(Long id);

    List<AlertDTO> findAll();
    Page<AlertDTO> findAll(Pageable pageable);

    AlertDTO save(AlertDTO dto);
    AlertDTO update(AlertDTO dto);
    void deleteById(Long id);

    List<AlertDTO> findByUser(Long userId);
    Page<AlertDTO> findByUser(Long userId, Pageable pageable);

    List<AlertDTO> findByAudit(Long auditId);
    Page<AlertDTO> findByAudit(Long auditId, Pageable pageable);

    List<AlertDTO> findByExecution(Long executionId);
    Page<AlertDTO> findByExecution(Long executionId, Pageable pageable);

    List<AlertDTO> findByType(AlertType type);
    Page<AlertDTO> findByType(AlertType type, Pageable pageable);

    List<AlertDTO> findBySeverity(AlertSeverity severity);
    Page<AlertDTO> findBySeverity(AlertSeverity severity, Pageable pageable);

    List<AlertDTO> findUnreadByUser(Long userId);
    Page<AlertDTO> findUnreadByUser(Long userId, Pageable pageable);

    AlertDTO markAsRead(Long id);

    List<AlertDTO> findByCompanyId(Long companyId);
    Page<AlertDTO> findByCompanyId(Long companyId, Pageable pageable);

    List<AlertDTO> findByCompanyIdAndReadFalse(Long companyId);
    Page<AlertDTO> findByCompanyIdAndReadFalse(Long companyId, Pageable pageable);

    List<AlertDTO> findByAuditIdAndReadFalse(Long auditId);
    Page<AlertDTO> findByAuditIdAndReadFalse(Long auditId, Pageable pageable);
}
