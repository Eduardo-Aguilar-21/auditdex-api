package com.ast.auditdex_api.repositories;

import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.enums.AuditType;
import com.ast.auditdex_api.models.AuditModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<AuditModel, Long> {
    List<AuditModel> findByAuditStatus(AuditStatus status);
    Page<AuditModel> findByAuditStatus(AuditStatus status, Pageable pageable);
    List<AuditModel> findByAuditType(AuditType type);
    Page<AuditModel> findByAuditType(AuditType type, Pageable pageable);
    List<AuditModel> findByGlobalTrue();
    Page<AuditModel> findByGlobalTrue(Pageable pageable);
    List<AuditModel> findByCompanyId(Long companyId);
    Page<AuditModel> findByCompanyId(Long companyId, Pageable pageable);

    @Query("SELECT a FROM AuditModel a WHERE a.global = true OR a.company.id = :companyId")
    List<AuditModel> findVisibleByCompanyId(@Param("companyId") Long companyId);

    @Query("SELECT a FROM AuditModel a WHERE a.global = true OR a.company.id = :companyId")
    Page<AuditModel> findVisibleByCompanyId(@Param("companyId") Long companyId, Pageable pageable);
}
