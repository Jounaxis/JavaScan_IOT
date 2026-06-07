package com.agroscan.agroscan_api.repository;

import com.agroscan.agroscan_api.model.Vegetal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VegetalRepository extends JpaRepository<Vegetal, Long> {
}