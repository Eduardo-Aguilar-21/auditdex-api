package com.ast.auditdex_api.controllers;

import com.ast.auditdex_api.dto.AlertDTO;
import com.ast.auditdex_api.enums.AlertSeverity;
import com.ast.auditdex_api.enums.AlertType;
import com.ast.auditdex_api.services.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @GetMapping
    public ResponseEntity<Page<AlertDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(alertService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertDTO> getById(@PathVariable Long id) {
        return alertService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlertDTO> create(@RequestBody AlertDTO dto) {
        return ResponseEntity.ok(alertService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertDTO> update(@PathVariable Long id, @RequestBody AlertDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(alertService.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alertService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Page<AlertDTO>> getByUser(@PathVariable Long userId, Pageable pageable) {
        return ResponseEntity.ok(alertService.findByUser(userId, pageable));
    }

    @GetMapping("/audit/{auditId}")
    public ResponseEntity<Page<AlertDTO>> getByAudit(@PathVariable Long auditId, Pageable pageable) {
        return ResponseEntity.ok(alertService.findByAudit(auditId, pageable));
    }

    @GetMapping("/execution/{executionId}")
    public ResponseEntity<Page<AlertDTO>> getByExecution(@PathVariable Long executionId, Pageable pageable) {
        return ResponseEntity.ok(alertService.findByExecution(executionId, pageable));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<Page<AlertDTO>> getByType(@PathVariable AlertType type, Pageable pageable) {
        return ResponseEntity.ok(alertService.findByType(type, pageable));
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<Page<AlertDTO>> getBySeverity(@PathVariable AlertSeverity severity, Pageable pageable) {
        return ResponseEntity.ok(alertService.findBySeverity(severity, pageable));
    }

    @GetMapping("/user/{userId}/unread")
    public ResponseEntity<Page<AlertDTO>> getUnreadByUser(@PathVariable Long userId, Pageable pageable) {
        return ResponseEntity.ok(alertService.findUnreadByUser(userId, pageable));
    }

    @PatchMapping("/{id}/read")
    public ResponseEntity<AlertDTO> markAsRead(@PathVariable Long id) {
        return ResponseEntity.ok(alertService.markAsRead(id));
    }
}
