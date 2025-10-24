package com.ast.auditdex_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private Long id;
    private String name;
    private Boolean active;
    private ZonedDateTime createdAt;
}