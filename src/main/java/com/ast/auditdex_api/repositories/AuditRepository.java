package com.ast.auditdex_api.repositories;

import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.enums.AuditType;
import com.ast.auditdex_api.models.AuditModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<AuditModel, Long> {
    List<AuditModel> findByAuditStatus(AuditStatus status);
    Page<AuditModel> findByAuditStatus(AuditStatus status, Pageable pageable);
    List<AuditModel> findByAuditType(AuditType type);
    Page<AuditModel> findByAuditType(AuditType type, Pageable pageable);
}
