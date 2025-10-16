package com.ast.auditdex_api.repositories;

import com.ast.auditdex_api.models.UserModel;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
    Optional<UserModel> findByEmail(String email);
    List<UserModel> findByCompanyId(Long companyId);
    Page<UserModel> findByCompanyId(Long companyId, Pageable pageable);
}
