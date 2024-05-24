package com.infsus.suhs.repository;

import com.infsus.suhs.model.Pozivatelj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PozivateljRepository extends JpaRepository<Pozivatelj, String> {
}
