package com.ast.auditdex_api.services.impl;

import com.ast.auditdex_api.dto.AttachmentDTO;
import com.ast.auditdex_api.mappers.AttachmentMapper;
import com.ast.auditdex_api.models.AttachmentModel;
import com.ast.auditdex_api.repositories.AttachmentRepository;
import com.ast.auditdex_api.services.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;

    @Override
    public Optional<AttachmentDTO> findById(Long id) {
        return attachmentRepository.findById(id)
                .map(AttachmentMapper::toDTO);
    }

    @Override
    public List<AttachmentDTO> findAll() {
        return attachmentRepository.findAll()
                .stream()
                .map(AttachmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AttachmentDTO> findAll(Pageable pageable) {
        return attachmentRepository.findAll(pageable)
                .map(AttachmentMapper::toDTO);
    }

    @Override
    public AttachmentDTO save(AttachmentDTO dto) {
        AttachmentModel model = AttachmentMapper.toEntity(dto);
        AttachmentModel saved = attachmentRepository.save(model);
        return AttachmentMapper.toDTO(saved);
    }

    @Override
    public AttachmentDTO update(AttachmentDTO dto) {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Attachment ID cannot be null for update");
        }
        AttachmentModel model = AttachmentMapper.toEntity(dto);
        AttachmentModel updated = attachmentRepository.save(model);
        return AttachmentMapper.toDTO(updated);
    }

    @Override
    public void deleteById(Long id) {
        attachmentRepository.deleteById(id);
    }

    // Métodos adicionales para filtrar por ejecución
    public List<AttachmentDTO> findByExecutionId(Long executionId) {
        return attachmentRepository.findByExecutionId(executionId)
                .stream()
                .map(AttachmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Page<AttachmentDTO> findByExecutionId(Long executionId, Pageable pageable) {
        return attachmentRepository.findByExecutionId(executionId, pageable)
                .map(AttachmentMapper::toDTO);
    }

    public List<AttachmentDTO> findByExecutionIdOrderByCreatedAtDesc(Long executionId) {
        return attachmentRepository.findByExecutionIdOrderByCreatedAtDesc(executionId)
                .stream()
                .map(AttachmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Page<AttachmentDTO> findByExecutionIdOrderByCreatedAtDesc(Long executionId, Pageable pageable) {
        return attachmentRepository.findByExecutionIdOrderByCreatedAtDesc(executionId, pageable)
                .map(AttachmentMapper::toDTO);
    }
}
