package com.ast.auditdex_api.controllers;

import com.ast.auditdex_api.dto.AlertDTO;
import com.ast.auditdex_api.enums.AlertSeverity;
import com.ast.auditdex_api.enums.AlertType;
import com.ast.auditdex_api.services.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @GetMapping("/{id}")
    public ResponseEntity<AlertDTO> getById(@PathVariable Long id) {
        return alertService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AlertDTO>> getAll() {
        return ResponseEntity.ok(alertService.findAll());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<AlertDTO>> getAllPage(@PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(alertService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<AlertDTO> create(@RequestBody AlertDTO dto) {
        return ResponseEntity.ok(alertService.save(dto));
    }

    /*
        @PutMapping("/{id}")
        public ResponseEntity<AlertDTO> update(@PathVariable Long id, @RequestBody AlertDTO dto) {
            dto.setId(id);
            return ResponseEntity.ok(alertService.update(dto));
        }
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alertService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AlertDTO>> getByUserList(@PathVariable Long userId) {
        return ResponseEntity.ok(alertService.findByUser(userId));
    }

    @GetMapping("/user/{userId}/page")
    public ResponseEntity<Page<AlertDTO>> getByUser(@PathVariable Long userId,
                                                    @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(alertService.findByUser(userId, pageable));
    }

    @GetMapping("/audit/{auditId}")
    public ResponseEntity<List<AlertDTO>> getByAudit(@PathVariable Long auditId) {
        return ResponseEntity.ok(alertService.findByAudit(auditId));
    }

    @GetMapping("/audit/{auditId}/page")
    public ResponseEntity<Page<AlertDTO>> getByAuditPage(@PathVariable Long auditId,
                                                         @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(alertService.findByAudit(auditId, pageable));
    }

    @GetMapping("/execution/{executionId}")
    public ResponseEntity<List<AlertDTO>> getByExecution(@PathVariable Long executionId) {
        return ResponseEntity.ok(alertService.findByExecution(executionId));
    }

    @GetMapping("/execution/{executionId}/page")
    public ResponseEntity<Page<AlertDTO>> getByExecutionPage(@PathVariable Long executionId,
                                                             @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(alertService.findByExecution(executionId, pageable));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<AlertDTO>> getByType(@PathVariable AlertType type) {
        return ResponseEntity.ok(alertService.findByType(type));
    }

    @GetMapping("/type/{type}/page")
    public ResponseEntity<Page<AlertDTO>> getByTypePage(@PathVariable AlertType type,
                                                        @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(alertService.findByType(type, pageable));
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<List<AlertDTO>> getBySeverity(@PathVariable AlertSeverity severity) {
        return ResponseEntity.ok(alertService.findBySeverity(severity));
    }

    @GetMapping("/severity/{severity}/page")
    public ResponseEntity<Page<AlertDTO>> getBySeverityPage(@PathVariable AlertSeverity severity,
                                                            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(alertService.findBySeverity(severity, pageable));
    }

    @GetMapping("/user/{userId}/unread")
    public ResponseEntity<List<AlertDTO>> getUnreadByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(alertService.findUnreadByUser(userId));
    }

    @GetMapping("/user/{userId}/unread/page")
    public ResponseEntity<Page<AlertDTO>> getUnreadByUser(@PathVariable Long userId,
                                                          @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(alertService.findUnreadByUser(userId, pageable));
    }

    @PatchMapping("/{id}/read")
    public ResponseEntity<AlertDTO> markAsRead(@PathVariable Long id) {
        return ResponseEntity.ok(alertService.markAsRead(id));
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<AlertDTO>> getByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(alertService.findByCompanyId(companyId));
    }

    @GetMapping("/company/{companyId}/page")
    public ResponseEntity<Page<AlertDTO>> getByCompanyPage(@PathVariable Long companyId,
                                                           @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(alertService.findByCompanyId(companyId, pageable));
    }

    @GetMapping("/company/{companyId}/unread")
    public ResponseEntity<List<AlertDTO>> getUnreadByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(alertService.findByCompanyIdAndReadFalse(companyId));
    }

    @GetMapping("/company/{companyId}/unread/page")
    public ResponseEntity<Page<AlertDTO>> getUnreadByCompany(@PathVariable Long companyId,
                                                             @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(alertService.findByCompanyIdAndReadFalse(companyId, pageable));
    }

    @GetMapping("/audit/{auditId}/unread")
    public ResponseEntity<List<AlertDTO>> getAllUnreadByAudit(@PathVariable Long auditId) {
        return ResponseEntity.ok(alertService.findByAuditIdAndReadFalse(auditId));
    }

    @GetMapping("/audit/{auditId}/unread/page")
    public ResponseEntity<Page<AlertDTO>> getUnreadByAudit(@PathVariable Long auditId,
                                                           @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(alertService.findByAuditIdAndReadFalse(auditId, pageable));
    }

}
