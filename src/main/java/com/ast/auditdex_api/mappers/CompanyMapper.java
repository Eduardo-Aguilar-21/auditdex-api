package com.ast.auditdex_api.mappers;

import com.ast.auditdex_api.dto.CompanyDTO;
import com.ast.auditdex_api.models.CompanyModel;

public class CompanyMapper {

    public static CompanyDTO toDTO(CompanyModel company) {
        if (company == null) return null;
        return new CompanyDTO(
                company.getId(),
                company.getName(),
                company.getAddress(),
                company.getPhone(),
                company.getEmail(),
                company.getActive()
        );
    }

    public static CompanyModel toEntity(CompanyDTO dto) {
        if (dto == null) return null;
        CompanyModel company = new CompanyModel();
        company.setId(dto.getId());
        company.setName(dto.getName());
        company.setAddress(dto.getAddress());
        company.setPhone(dto.getPhone());
        company.setEmail(dto.getEmail());
        company.setActive(dto.getActive());
        return company;
    }
}
