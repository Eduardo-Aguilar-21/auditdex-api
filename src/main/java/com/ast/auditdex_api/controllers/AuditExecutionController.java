package com.ast.auditdex_api.controllers;

import com.ast.auditdex_api.dto.AuditExecutionDTO;
import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.services.AuditExecutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/page")
    public ResponseEntity<Page<AuditExecutionDTO>> getAllPaged(@PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
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
    public ResponseEntity<Page<AuditExecutionDTO>> getByAuditIdPaged(@PathVariable Long auditId,
                                                                     @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(service.findByAuditId(auditId, pageable));
    }

    @GetMapping("/auditor/{auditorId}")
    public ResponseEntity<List<AuditExecutionDTO>> getByAuditorId(@PathVariable Long auditorId) {
        return ResponseEntity.ok(service.findByAuditorId(auditorId));
    }

    @GetMapping("/auditor/{auditorId}/")
    public ResponseEntity<Page<AuditExecutionDTO>> getByAuditorIdPaged(@PathVariable Long auditorId,
                                                                       @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(service.findByAuditorId(auditorId, pageable));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<AuditExecutionDTO>> getByStatus(@PathVariable AuditStatus status) {
        return ResponseEntity.ok(service.findByStatus(status));
    }

    @GetMapping("/status/{status}/page")
    public ResponseEntity<Page<AuditExecutionDTO>> getByStatusPaged(@PathVariable AuditStatus status,
                                                                    @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(service.findByStatus(status, pageable));
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<AuditExecutionDTO>> getByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(service.findByCompanyId(companyId));
    }

    @GetMapping("/company/{status}/page")
    public ResponseEntity<Page<AuditExecutionDTO>> getByCompanyPaged(@PathVariable Long companyId,
                                                                     @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(service.findByCompanyId(companyId, pageable));
    }
}
