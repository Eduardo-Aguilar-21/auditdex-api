package com.ast.auditdex_api.services.impl;

import com.ast.auditdex_api.dto.CompanyDTO;
import com.ast.auditdex_api.mappers.CompanyMapper;
import com.ast.auditdex_api.models.CompanyModel;
import com.ast.auditdex_api.repositories.CompanyRepository;
import com.ast.auditdex_api.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Optional<CompanyDTO> findById(Long id) {
        return companyRepository.findById(id)
                .map(CompanyMapper::toDTO);
    }

    @Override
    public List<CompanyDTO> findAll() {
        return companyRepository.findAll()
                .stream()
                .map(CompanyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<CompanyDTO> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable)
                .map(CompanyMapper::toDTO);
    }

    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
        CompanyModel entity = CompanyMapper.toEntity(companyDTO);
        CompanyModel saved = companyRepository.save(entity);
        return CompanyMapper.toDTO(saved);
    }

    @Override
    public CompanyDTO update(CompanyDTO companyDTO) {
        if (companyDTO.getId() == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo para actualizar.");
        }

        CompanyModel existing = companyRepository.findById(companyDTO.getId())
                .orElseThrow(() -> new RuntimeException("Compañía no encontrada con ID " + companyDTO.getId()));

        existing.setName(companyDTO.getName());
        existing.setAddress(companyDTO.getAddress());
        existing.setPhone(companyDTO.getPhone());
        existing.setEmail(companyDTO.getEmail());

        CompanyModel updated = companyRepository.save(existing);
        return CompanyMapper.toDTO(updated);
    }

    @Override
    public void deleteById(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new RuntimeException("Compañía no encontrada con ID " + id);
        }
        companyRepository.deleteById(id);
    }
}
