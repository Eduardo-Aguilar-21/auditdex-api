package com.ast.auditdex_api.services;

import com.ast.auditdex_api.dto.UserDTO;
import com.ast.auditdex_api.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserDTO> findById(Long id);

    List<UserDTO> findAll();

    Page<UserDTO> findAll(Pageable pageable);

    UserDTO save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    void deleteById(Long id);

    Optional<UserDTO> findByUsername(String username);

    Optional<UserDTO> findByEmail(String email);

    List<UserDTO> findByCompanyId(Long companyId);

    Page<UserDTO> findByCompanyId(Long companyId, Pageable pageable);
}
