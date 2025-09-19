package com.ast.auditdex_api.controllers;

import com.ast.auditdex_api.dto.AuditExecutionDTO;
import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.services.AuditExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/audit-executions")
@RequiredArgsConstructor
public class AuditExecutionController {

    private final AuditExecutionService service;

    @PostMapping
    public ResponseEntity<AuditExecutionDTO> create(@RequestBody AuditExecutionDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditExecutionDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AuditExecutionDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<AuditExecutionDTO>> getAllPaged(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/audit/{auditId}")
    public ResponseEntity<List<AuditExecutionDTO>> getByAuditId(@PathVariable Long auditId) {
        return ResponseEntity.ok(service.findByAuditId(auditId));
    }

    @GetMapping("/audit/{auditId}/paged")
    public ResponseEntity<Page<AuditExecutionDTO>> getByAuditIdPaged(@PathVariable Long auditId, Pageable pageable) {
        return ResponseEntity.ok(service.findByAuditId(auditId, pageable));
    }

    @GetMapping("/auditor/{auditorId}")
    public ResponseEntity<List<AuditExecutionDTO>> getByAuditorId(@PathVariable Long auditorId) {
        return ResponseEntity.ok(service.findByAuditorId(auditorId));
    }

    @GetMapping("/auditor/{auditorId}/paged")
    public ResponseEntity<Page<AuditExecutionDTO>> getByAuditorIdPaged(@PathVariable Long auditorId, Pageable pageable) {
        return ResponseEntity.ok(service.findByAuditorId(auditorId, pageable));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<AuditExecutionDTO>> getByStatus(@PathVariable AuditStatus status) {
        return ResponseEntity.ok(service.findByStatus(status));
    }

    @GetMapping("/status/{status}/paged")
    public ResponseEntity<Page<AuditExecutionDTO>> getByStatusPaged(@PathVariable AuditStatus status, Pageable pageable) {
        return ResponseEntity.ok(service.findByStatus(status, pageable));
    }
}
