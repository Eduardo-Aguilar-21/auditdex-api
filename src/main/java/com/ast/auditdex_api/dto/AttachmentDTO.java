package com.ast.auditdex_api.dto;

import java.time.ZonedDateTime;
import lombok.Data;

@Data
public class AttachmentDTO {
    private Long id;
    private String fileType;
    private String fileUrl;
    private String fileName;
    private String size;
    private String description;
    private Long executionId;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
