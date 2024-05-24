package com.infsus.suhs.repository;

import com.infsus.suhs.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, String> {
}
