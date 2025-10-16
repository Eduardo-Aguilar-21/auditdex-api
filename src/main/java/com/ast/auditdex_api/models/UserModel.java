package com.ast.auditdex_api.models;

import com.ast.auditdex_api.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name = "users",
        indexes = {
                @Index(name = "idx_user_username", columnList = "username", unique = true),
                @Index(name = "idx_user_email", columnList = "email", unique = true),
                @Index(name = "idx_user_role", columnList = "role"),
                @Index(name = "idx_user_company_id", columnList = "company_id"),
                @Index(name = "idx_user_created_at", columnList = "created_at")
        })
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotEmpty(message = "Username is required")
    @Column(unique = true, nullable = false, length = 50)
    private String username;
    private String password;

    @NotEmpty(message = "Name to user is required")
    @Column(nullable = false, length = 50)
    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private Boolean active = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    CompanyModel company;

    @JsonIgnore
    @OneToMany(mappedBy = "auditor", cascade = CascadeType.ALL)
    private List<AuditExecutionModel> auditExecutions;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
