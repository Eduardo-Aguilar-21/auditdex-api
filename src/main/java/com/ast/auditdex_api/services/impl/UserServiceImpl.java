package com.ast.auditdex_api.services.impl;

import com.ast.auditdex_api.dto.UserDTO;
import com.ast.auditdex_api.mappers.UserMapper;
import com.ast.auditdex_api.models.UserModel;
import com.ast.auditdex_api.repositories.CompanyRepository;
import com.ast.auditdex_api.repositories.UserRepository;
import com.ast.auditdex_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @Override
    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDTO);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserMapper::toDTO);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserModel entity = UserMapper.toEntity(userDTO);

        if (userDTO.getCompanyId() == null) {
            throw new IllegalArgumentException("companyId no puede ser nulo");
        }

        var company = companyRepository.findById(userDTO.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found with id " + userDTO.getCompanyId()));
        entity.setCompany(company);

        UserModel saved = userRepository.save(entity);
        return UserMapper.toDTO(saved);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        if (userDTO.getId() == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo para actualizar.");
        }

        if (!userRepository.existsById(userDTO.getId())) {
            throw new RuntimeException("Usuario no encontrado con ID " + userDTO.getId());
        }

        UserModel entity = UserMapper.toEntity(userDTO);

        var company = companyRepository.findById(userDTO.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found with id " + userDTO.getCompanyId()));
        entity.setCompany(company);

        UserModel updated = userRepository.save(entity);
        return UserMapper.toDTO(updated);
    }

    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con ID " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return userRepository.findByUsername(username).map(UserMapper::toDTO);
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email).map(UserMapper::toDTO);
    }

    @Override
    public List<UserDTO> findByCompanyId(Long companyId) {
        return userRepository.findByCompanyId(companyId)
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<UserDTO> findByCompanyId(Long companyId, Pageable pageable) {
        return userRepository.findByCompanyId(companyId, pageable).map(UserMapper::toDTO);
    }
}
