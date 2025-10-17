package com.ast.auditdex_api.services;

import com.ast.auditdex_api.dto.AlertDTO;
import com.ast.auditdex_api.dto.AttachmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AttachmentService {
    Optional<AttachmentDTO> findById(Long id);

    List<AttachmentDTO> findAll();
    Page<AttachmentDTO> findAll(Pageable pageable);

    AttachmentDTO save(AttachmentDTO dto);
    AttachmentDTO update(AttachmentDTO dto);
    void deleteById(Long id);

    List<AttachmentDTO> findByExecutionId(Long executionId);
    Page<AttachmentDTO> findByExecutionId(Long executionId, Pageable pageable);

    List<AttachmentDTO> findByExecutionIdOrderByCreatedAtDesc(Long executionId);
    Page<AttachmentDTO> findByExecutionIdOrderByCreatedAtDesc(Long executionId, Pageable pageable);
}
