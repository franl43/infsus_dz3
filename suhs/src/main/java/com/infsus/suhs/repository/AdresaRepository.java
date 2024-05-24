package com.infsus.suhs.repository;

import com.infsus.suhs.model.Adresa;
import com.infsus.suhs.model.AdresaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresaRepository extends JpaRepository<Adresa, AdresaId> {
}
