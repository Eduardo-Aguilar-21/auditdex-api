package com.ast.auditdex_api.services.impl;

import com.ast.auditdex_api.dto.AlertDTO;
import com.ast.auditdex_api.enums.AlertSeverity;
import com.ast.auditdex_api.enums.AlertType;
import com.ast.auditdex_api.mappers.AlertMapper;
import com.ast.auditdex_api.models.AlertModel;
import com.ast.auditdex_api.models.AuditExecutionModel;
import com.ast.auditdex_api.models.AuditModel;
import com.ast.auditdex_api.models.UserModel;
import com.ast.auditdex_api.repositories.AlertRepository;
import com.ast.auditdex_api.repositories.AuditExecutionRepository;
import com.ast.auditdex_api.repositories.AuditRepository;
import com.ast.auditdex_api.repositories.UserRepository;
import com.ast.auditdex_api.services.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;

    private final AuditRepository auditRepository;

    private final AuditExecutionRepository executionRepository;

    private final UserRepository userRepository;

    @Override
    public Optional<AlertDTO> findById(Long id) {
        return alertRepository.findById(id)
                .map(AlertMapper::toDTO);
    }

    @Override
    public List<AlertDTO> findAll() {
        return alertRepository.findAll()
                .stream()
                .map(AlertMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlertDTO> findAll(Pageable pageable) {
        return alertRepository.findAll(pageable)
                .map(AlertMapper::toDTO);
    }

    @Override
    public AlertDTO save(AlertDTO dto) {
        AuditModel audit = dto.getAuditId() != null ? auditRepository.findById(dto.getAuditId()).orElse(null) : null;
        AuditExecutionModel execution = dto.getExecutionId() != null ? executionRepository.findById(dto.getExecutionId()).orElse(null) : null;
        UserModel user = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;

        AlertModel model = AlertMapper.toEntity(dto, audit, execution, user);
        return AlertMapper.toDTO(alertRepository.save(model));
    }

    @Override
    public AlertDTO update(AlertDTO dto) {
        if (dto.getId() == null || !alertRepository.existsById(dto.getId())) {
            throw new RuntimeException("La alerta con id " + dto.getId() + " no existe.");
        }
        return save(dto);
    }

    @Override
    public void deleteById(Long id) {
        alertRepository.deleteById(id);
    }

    @Override
    public List<AlertDTO> findByUser(Long userId) {
        return alertRepository.findByUserId(userId)
                .stream()
                .map(AlertMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlertDTO> findByUser(Long userId, Pageable pageable) {
        return alertRepository.findByUserId(userId, pageable)
                .map(AlertMapper::toDTO);
    }

    @Override
    public List<AlertDTO> findByAudit(Long auditId) {
        return alertRepository.findByAuditId(auditId)
                .stream()
                .map(AlertMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlertDTO> findByAudit(Long auditId, Pageable pageable) {
        return alertRepository.findByAuditId(auditId, pageable)
                .map(AlertMapper::toDTO);
    }

    @Override
    public List<AlertDTO> findByExecution(Long executionId) {
        return alertRepository.findByExecutionId(executionId)
                .stream()
                .map(AlertMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlertDTO> findByExecution(Long executionId, Pageable pageable) {
        return alertRepository.findByExecutionId(executionId, pageable)
                .map(AlertMapper::toDTO);
    }

    @Override
    public List<AlertDTO> findByType(AlertType type) {
        return alertRepository.findByType(type)
                .stream()
                .map(AlertMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlertDTO> findByType(AlertType type, Pageable pageable) {
        return alertRepository.findByType(type, pageable)
                .map(AlertMapper::toDTO);
    }

    @Override
    public List<AlertDTO> findBySeverity(AlertSeverity severity) {
        return alertRepository.findBySeverity(severity)
                .stream()
                .map(AlertMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlertDTO> findBySeverity(AlertSeverity severity, Pageable pageable) {
        return alertRepository.findBySeverity(severity, pageable)
                .map(AlertMapper::toDTO);
    }

    @Override
    public List<AlertDTO> findUnreadByUser(Long userId) {
        return alertRepository.findByUserIdAndReadFalse(userId)
                .stream()
                .map(AlertMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlertDTO> findUnreadByUser(Long userId, Pageable pageable) {
        return alertRepository.findByUserIdAndReadFalse(userId, pageable)
                .map(AlertMapper::toDTO);
    }

    // 🔹 Marcar como leída
    @Override
    public AlertDTO markAsRead(Long id) {
        AlertModel alert = alertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La alerta con id " + id + " no existe."));
        alert.setRead(true);
        return AlertMapper.toDTO(alertRepository.save(alert));
    }

    @Override
    public List<AlertDTO> findByCompanyId(Long userId) {
        return alertRepository.findByCompanyId(userId)
                .stream()
                .map(AlertMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlertDTO> findByCompanyId(Long companyId, Pageable pageable) {
        return alertRepository.findByUserIdAndReadFalse(companyId, pageable)
                .map(AlertMapper::toDTO);
    }

    @Override
    public List<AlertDTO> findByCompanyIdAndReadFalse(Long companyId) {
        return alertRepository.findByCompanyIdAndReadFalse(companyId)
                .stream()
                .map(AlertMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlertDTO> findByCompanyIdAndReadFalse(Long companyId, Pageable pageable) {
        return alertRepository.findByCompanyIdAndReadFalse(companyId, pageable)
                .map(AlertMapper::toDTO);
    }

    @Override
    public List<AlertDTO> findByAuditIdAndReadFalse(Long auditId) {
        return alertRepository.findByAuditIdAndReadFalse(auditId)
                .stream()
                .map(AlertMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<AlertDTO> findByAuditIdAndReadFalse(Long auditId, Pageable pageable) {
        return alertRepository.findByAuditIdAndReadFalse(auditId, pageable)
                .map(AlertMapper::toDTO);
    }
}
