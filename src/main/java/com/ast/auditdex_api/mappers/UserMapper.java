package com.ast.auditdex_api.mappers;

import com.ast.auditdex_api.dto.UserDTO;
import com.ast.auditdex_api.models.UserModel;

public class UserMapper {
    public static UserDTO toDTO(UserModel entity) {
        if (entity == null) {
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());

        if (entity.getCompany() != null) {
            dto.setCompanyId(entity.getCompany().getId());
            dto.setCompanyName(entity.getCompany().getName();
        }

        return dto;
    }

    public static UserModel toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        UserModel entity = new UserModel();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        return entity;
    }
}