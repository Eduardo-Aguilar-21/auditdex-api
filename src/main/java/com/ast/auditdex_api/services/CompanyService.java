package com.ast.auditdex_api.services;

import com.ast.auditdex_api.dto.CompanyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Optional<CompanyDTO> findById(Long id);

    List<CompanyDTO> findAll();

    Page<CompanyDTO> findAll(Pageable pageable);

    CompanyDTO save(CompanyDTO companyDTO);

    CompanyDTO update(CompanyDTO companyDTO);

    void deleteById(Long id);
}
