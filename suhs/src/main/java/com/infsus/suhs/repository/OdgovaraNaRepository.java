package com.infsus.suhs.repository;

import com.infsus.suhs.model.OdgovaraNa;
import com.infsus.suhs.model.OdgovaraNaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OdgovaraNaRepository extends JpaRepository<OdgovaraNa, OdgovaraNaId> {
    List<OdgovaraNa> findByIntervencijaIntervencijaId(Long id);

    List<OdgovaraNa> findByVoziloRegistracija(String registracija);
}
