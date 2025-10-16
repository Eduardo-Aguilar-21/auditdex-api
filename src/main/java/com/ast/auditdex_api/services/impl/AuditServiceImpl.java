package com.ast.auditdex_api.services.impl;

import com.ast.auditdex_api.dto.AuditDTO;
import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.enums.AuditType;
import com.ast.auditdex_api.mappers.AuditMapper;
import com.ast.auditdex_api.models.AuditModel;
import com.ast.auditdex_api.repositories.AuditRepository;
import com.ast.auditdex_api.services.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    @Override
    public Optional<AuditDTO> findById(Long id) {
        return auditRepository.findById(id).map(AuditMapper::toDTO);
    }

    @Override
    public List<AuditDTO> findAll() {
        return auditRepository.findAll()
                .stream()
                .map(AuditMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AuditDTO> findAll(Pageable pageable) {
        return auditRepository.findAll(pageable).map(AuditMapper::toDTO);
    }

    @Override
    public AuditDTO save(AuditDTO auditDTO) {
        AuditModel entity = AuditMapper.toEntity(auditDTO);
        AuditModel saved = auditRepository.save(entity);
        return AuditMapper.toDTO(saved);
    }

    @Override
    public AuditDTO update(AuditDTO auditDTO) {
        if (auditDTO.getId() == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo para actualizar.");
        }

        Optional<AuditModel> existing = auditRepository.findById(auditDTO.getId());
        if (existing.isEmpty()) {
            throw new RuntimeException("Auditoría no encontrada con ID " + auditDTO.getId());
        }

        AuditModel entity = AuditMapper.toEntity(auditDTO);
        AuditModel updated = auditRepository.save(entity);
        return AuditMapper.toDTO(updated);
    }

    @Override
    public void deleteById(Long id) {
        if (!auditRepository.existsById(id)) {
            throw new RuntimeException("Auditoría no encontrada con ID " + id);
        }
        auditRepository.deleteById(id);
    }

    @Override
    public List<AuditDTO> findByStatus(AuditStatus status) {
        return auditRepository.findByAuditStatus(status)
                .stream()
                .map(AuditMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AuditDTO> findByStatus(AuditStatus status, Pageable pageable) {
        return auditRepository.findByAuditStatus(status, pageable)
                .map(AuditMapper::toDTO);
    }

    @Override
    public List<AuditDTO> findByType(AuditType type) {
        return auditRepository.findByAuditType(type)
                .stream()
                .map(AuditMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AuditDTO> findByType(AuditType type, Pageable pageable) {
        return auditRepository.findByAuditType(type, pageable)
                .map(AuditMapper::toDTO);
    }

    @Override
    public List<AuditDTO> findByGlobalTrue() {
        return auditRepository.findByGlobalTrue()
                .stream()
                .map(AuditMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AuditDTO> findByGlobalTrue(Pageable pageable) {
        return auditRepository.findByGlobalTrue(pageable)
                .map(AuditMapper::toDTO);
    }

    @Override
    public List<AuditDTO> findByCompanyId(Long companyId) {
        return auditRepository.findByCompanyId(companyId)
                .stream()
                .map(AuditMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AuditDTO> findByCompanyId(Long companyId, Pageable pageable) {
        return auditRepository.findByCompanyId(companyId, pageable)
                .map(AuditMapper::toDTO);
    }

    @Override
    public List<AuditDTO> findVisibleByCompanyId(Long companyId) {
        return auditRepository.findVisibleByCompanyId(companyId)
                .stream()
                .map(AuditMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AuditDTO> findVisibleByCompanyId(Long companyId, Pageable pageable) {
        return auditRepository.findVisibleByCompanyId(companyId, pageable)
                .map(AuditMapper::toDTO);
    }
}
