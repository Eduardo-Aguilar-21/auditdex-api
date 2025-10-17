package com.ast.auditdex_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    private String address;
    private String phone;
    private String email;

    @Column(nullable = false)
    private Boolean active = true;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserModel> users;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuditModel> audits;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<AuditExecutionModel> auditExecutions;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<AlertModel> alerts;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
