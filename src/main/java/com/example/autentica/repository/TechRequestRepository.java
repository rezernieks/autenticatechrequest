package com.example.autentica.repository;

import com.example.autentica.entity.TechRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechRequestRepository extends JpaRepository<TechRequest, Integer> {

    public boolean existsByEmail(String email);

    public List<TechRequest> findByEmail(String email);

    @Query("select max(s.id) from TechRequest s")
    public Integer findMaxId();
}
