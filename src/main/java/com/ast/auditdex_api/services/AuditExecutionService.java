package com.ast.auditdex_api.services;

import com.ast.auditdex_api.dto.AuditExecutionDTO;
import com.ast.auditdex_api.enums.AuditStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AuditExecutionService {
    AuditExecutionDTO save(AuditExecutionDTO dto);
    Optional<AuditExecutionDTO> findById(Long id);
    List<AuditExecutionDTO> findAll();
    Page<AuditExecutionDTO> findAll(Pageable pageable);
    void deleteById(Long id);

    List<AuditExecutionDTO> findByAuditId(Long auditId);
    Page<AuditExecutionDTO> findByAuditId(Long auditId, Pageable pageable);

    List<AuditExecutionDTO> findByAuditorId(Long auditorId);
    Page<AuditExecutionDTO> findByAuditorId(Long auditorId, Pageable pageable);

    List<AuditExecutionDTO> findByStatus(AuditStatus status);
    Page<AuditExecutionDTO> findByStatus(AuditStatus status, Pageable pageable);
}
