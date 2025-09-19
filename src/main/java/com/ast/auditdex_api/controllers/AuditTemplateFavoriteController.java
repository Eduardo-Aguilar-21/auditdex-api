package com.ast.auditdex_api.controllers;

import com.ast.auditdex_api.dto.AuditTemplateFavoriteDTO;
import com.ast.auditdex_api.models.AuditTemplateFavoriteModel;
import com.ast.auditdex_api.services.AuditTemplateFavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class AuditTemplateFavoriteController {

    private final AuditTemplateFavoriteService service;

    @GetMapping("/{id}")
    public ResponseEntity<AuditTemplateFavoriteDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AuditTemplateFavoriteDTO> create(@RequestBody AuditTemplateFavoriteDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditTemplateFavoriteDTO> update(@PathVariable Long id, @RequestBody AuditTemplateFavoriteDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<AuditTemplateFavoriteModel>> getByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(service.findByCompany(companyId));
    }

    @GetMapping("/company/{companyId}/page")
    public ResponseEntity<Page<AuditTemplateFavoriteModel>> getByCompanyPaged(@PathVariable Long companyId, Pageable pageable) {
        return ResponseEntity.ok(service.findByCompany(companyId, pageable));
    }

    @GetMapping("/company/{companyId}/favorites")
    public ResponseEntity<List<AuditTemplateFavoriteModel>> getFavoritesByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(service.findFavoritesByCompany(companyId));
    }

    @GetMapping("/company/{companyId}/favorites/page")
    public ResponseEntity<Page<AuditTemplateFavoriteModel>> getFavoritesByCompanyPaged(@PathVariable Long companyId, Pageable pageable) {
        return ResponseEntity.ok(service.findFavoritesByCompany(companyId, pageable));
    }

    @GetMapping("/company/{companyId}/template/{templateId}")
    public ResponseEntity<AuditTemplateFavoriteDTO> getByCompanyAndTemplate(
            @PathVariable Long companyId,
            @PathVariable Long templateId
    ) {
        return service.findByCompanyAndTemplate(companyId, templateId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
