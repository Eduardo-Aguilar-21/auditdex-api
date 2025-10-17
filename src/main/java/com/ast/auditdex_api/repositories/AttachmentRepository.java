package com.ast.auditdex_api.repositories;

import com.ast.auditdex_api.models.AttachmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AttachmentRepository extends JpaRepository<AttachmentModel, Long> {
    List<AttachmentModel> findByExecutionId(Long executionId);
    Page<AttachmentModel> findByExecutionId(Long executionId, Pageable pageable);
    List<AttachmentModel> findByExecutionIdOrderByCreatedAtDesc(Long executionId);
    Page<AttachmentModel> findByExecutionIdOrderByCreatedAtDesc(Long executionId, Pageable pageable);
}
