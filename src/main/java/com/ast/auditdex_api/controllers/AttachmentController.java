package com.ast.auditdex_api.controllers;

import com.ast.auditdex_api.dto.AttachmentDTO;
import com.ast.auditdex_api.services.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachments")
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentService attachmentService;

    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<AttachmentDTO> getById(@PathVariable Long id) {
        return attachmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/page")
    public ResponseEntity<List<AttachmentDTO>> getAll() {
        return ResponseEntity.ok(attachmentService.findAll());
    }

    // Obtener todos con paginación
    @GetMapping
    public ResponseEntity<Page<AttachmentDTO>> getAllPaged(@PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(attachmentService.findAll(pageable));
    }

    // Crear nuevo
    @PostMapping
    public ResponseEntity<AttachmentDTO> create(@RequestBody AttachmentDTO dto) {
        return ResponseEntity.ok(attachmentService.save(dto));
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<AttachmentDTO> update(@PathVariable Long id, @RequestBody AttachmentDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(attachmentService.update(dto));
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        attachmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Filtrar por ejecución
    @GetMapping("/execution/{executionId}")
    public ResponseEntity<List<AttachmentDTO>> getByExecution(@PathVariable Long executionId) {
        return ResponseEntity.ok(attachmentService.findByExecutionId(executionId));
    }

    // Filtrar por ejecución con paginación
    @GetMapping("/execution/{executionId}/page")
    public ResponseEntity<Page<AttachmentDTO>> getByExecutionPaged(@PathVariable Long executionId,
                                                                   @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(attachmentService.findByExecutionId(executionId, pageable));
    }

    // Filtrar por ejecución y ordenar descendente
    @GetMapping("/execution/{executionId}/desc")
    public ResponseEntity<List<AttachmentDTO>> getByExecutionDesc(@PathVariable Long executionId) {
        return ResponseEntity.ok(attachmentService.findByExecutionIdOrderByCreatedAtDesc(executionId));
    }

    // Filtrar por ejecución y ordenar descendente con paginación
    @GetMapping("/execution/{executionId}/desc/page")
    public ResponseEntity<Page<AttachmentDTO>> getByExecutionDescPaged(@PathVariable Long executionId,
                                                                       @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(attachmentService.findByExecutionIdOrderByCreatedAtDesc(executionId, pageable));
    }
}
