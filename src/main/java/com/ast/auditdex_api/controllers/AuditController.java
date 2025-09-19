package com.ast.auditdex_api.controllers;

import com.ast.auditdex_api.dto.AuditDTO;
import com.ast.auditdex_api.enums.AuditStatus;
import com.ast.auditdex_api.enums.AuditType;
import com.ast.auditdex_api.services.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/audits")
@RequiredArgsConstructor
public class AuditController {

    private final AuditService auditService;

    @GetMapping
    public ResponseEntity<List<AuditDTO>> getAllAudits() {
        return ResponseEntity.ok(auditService.findAll());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<AuditDTO>> getAuditsPage(Pageable pageable) {
        return ResponseEntity.ok(auditService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditDTO> getAuditById(@PathVariable Long id) {
        Optional<AuditDTO> audit = auditService.findById(id);
        return audit.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AuditDTO> createAudit(@RequestBody AuditDTO auditDTO) {
        AuditDTO created = auditService.save(auditDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditDTO> updateAudit(@PathVariable Long id, @RequestBody AuditDTO auditDTO) {
        auditDTO.setId(id);
        AuditDTO updated = auditService.update(auditDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAudit(@PathVariable Long id) {
        auditService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<AuditDTO>> getAuditsByStatus(@PathVariable AuditStatus status) {
        return ResponseEntity.ok(auditService.findByStatus(status));
    }

    @GetMapping("/status/{status}/page")
    public ResponseEntity<Page<AuditDTO>> getAuditsByStatusPaged(@PathVariable AuditStatus status, Pageable pageable) {
        return ResponseEntity.ok(auditService.findByStatus(status, pageable));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<AuditDTO>> getAuditsByType(@PathVariable AuditType type) {
        return ResponseEntity.ok(auditService.findByType(type));
    }

    @GetMapping("/type/{type}/page")
    public ResponseEntity<Page<AuditDTO>> getAuditsByTypePaged(@PathVariable AuditType type, Pageable pageable) {
        return ResponseEntity.ok(auditService.findByType(type, pageable));
    }
}
