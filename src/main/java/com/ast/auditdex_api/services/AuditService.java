package com.ast.auditdex_api.services;

import com.ast.auditdex_api.dto.AuditDTO;
import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.enums.AuditType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AuditService {

    Optional<AuditDTO> findById(Long id);

    List<AuditDTO> findAll();

    Page<AuditDTO> findAll(Pageable pageable);

    AuditDTO save(AuditDTO auditDTO);

    AuditDTO update(AuditDTO auditDTO);

    void deleteById(Long id);

    List<AuditDTO> findByStatus(AuditStatus status);

    Page<AuditDTO> findByStatus(AuditStatus status, Pageable pageable);

    List<AuditDTO> findByType(AuditType type);

    Page<AuditDTO> findByType(AuditType type, Pageable pageable);
}
