package com.ast.auditdex_api.services.impl;


import com.ast.auditdex_api.dto.AuditExecutionDTO;
import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.mappers.AuditExecutionMapper;
import com.ast.auditdex_api.models.AuditExecutionModel;
import com.ast.auditdex_api.repositories.AuditExecutionRepository;
import com.ast.auditdex_api.services.AuditExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuditExecutionServiceImpl implements AuditExecutionService {

    private final AuditExecutionRepository repository;

    @Override
    public AuditExecutionDTO save(AuditExecutionDTO dto) {
        AuditExecutionModel model = AuditExecutionMapper.toEntity(dto);
        return AuditExecutionMapper.toDTO(repository.save(model));
    }

    @Override
    public Optional<AuditExecutionDTO> findById(Long id) {
        return repository.findById(id).map(AuditExecutionMapper::toDTO);
    }

    @Override
    public List<AuditExecutionDTO> findAll() {
        return repository.findAll().stream()
                .map(AuditExecutionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AuditExecutionDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(AuditExecutionMapper::toDTO);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AuditExecutionDTO> findByAuditId(Long auditId) {
        return repository.findByAuditId(auditId).stream()
                .map(AuditExecutionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AuditExecutionDTO> findByAuditId(Long auditId, Pageable pageable) {
        return repository.findByAuditId(auditId, pageable).map(AuditExecutionMapper::toDTO);
    }

    @Override
    public List<AuditExecutionDTO> findByAuditorId(Long auditorId) {
        return repository.findByAuditorId(auditorId).stream()
                .map(AuditExecutionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AuditExecutionDTO> findByAuditorId(Long auditorId, Pageable pageable) {
        return repository.findByAuditorId(auditorId, pageable).map(AuditExecutionMapper::toDTO);
    }

    @Override
    public List<AuditExecutionDTO> findByStatus(AuditStatus status) {
        return repository.findByStatus(status).stream()
                .map(AuditExecutionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AuditExecutionDTO> findByStatus(AuditStatus status, Pageable pageable) {
        return repository.findByStatus(status, pageable).map(AuditExecutionMapper::toDTO);
    }
}