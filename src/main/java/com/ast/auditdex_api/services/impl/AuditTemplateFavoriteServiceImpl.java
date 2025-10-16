package com.ast.auditdex_api.services.impl;

import com.ast.auditdex_api.dto.AuditTemplateFavoriteDTO;
import com.ast.auditdex_api.mappers.AuditTemplateFavoriteMapper;
import com.ast.auditdex_api.models.AuditModel;
import com.ast.auditdex_api.models.AuditTemplateFavoriteModel;
import com.ast.auditdex_api.repositories.AuditTemplateFavoriteRepository;
import com.ast.auditdex_api.services.AuditTemplateFavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuditTemplateFavoriteServiceImpl implements AuditTemplateFavoriteService {

    private final AuditTemplateFavoriteRepository repository;

    @Override
    public Optional<AuditTemplateFavoriteDTO> findById(Long id) {
        return repository.findById(id)
                .map(AuditTemplateFavoriteMapper::toDTO);
    }

    @Override
    public AuditTemplateFavoriteDTO save(AuditTemplateFavoriteDTO dto) {
        AuditTemplateFavoriteModel entity = AuditTemplateFavoriteMapper.toEntity(dto);
        AuditTemplateFavoriteModel saved = repository.save(entity);
        return AuditTemplateFavoriteMapper.toDTO(saved);
    }

    @Override
    public AuditTemplateFavoriteDTO update(AuditTemplateFavoriteDTO dto) {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo para actualizar.");
        }
        if (!repository.existsById(dto.getId())) {
            throw new RuntimeException("No existe un favorito con ID " + dto.getId());
        }
        AuditTemplateFavoriteModel entity = AuditTemplateFavoriteMapper.toEntity(dto);
        AuditTemplateFavoriteModel updated = repository.save(entity);
        return AuditTemplateFavoriteMapper.toDTO(updated);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No existe un favorito con ID " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<AuditTemplateFavoriteModel> findByCompany(Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    @Override
    public Page<AuditTemplateFavoriteModel> findByCompany(Long companyId, Pageable pageable) {
        return repository.findByCompanyId(companyId, pageable);
    }

    @Override
    public List<AuditTemplateFavoriteModel> findFavoritesByCompany(Long companyId) {
        return repository.findByCompanyIdAndFavoriteTrue(companyId);
    }

    @Override
    public Page<AuditTemplateFavoriteModel> findFavoritesByCompany(Long companyId, Pageable pageable) {
        return repository.findByCompanyIdAndFavoriteTrue(companyId, pageable);
    }

    @Override
    public Optional<AuditTemplateFavoriteDTO> findByCompanyIdAndAuditId(Long companyId, Long templateId) {
        return repository.findByCompanyIdAndAuditId(companyId, templateId)
                .map(AuditTemplateFavoriteMapper::toDTO);
    }

    public List<AuditModel> findFavoriteAuditsByCompanyId(Long companyId) {
        return repository.findFavoriteAuditsByCompanyId(companyId)
                .stream()
                .map(obj -> (AuditModel) obj)
                .collect(Collectors.toList());
    }
}
