package com.infsus.suhs.repository;

import com.infsus.suhs.model.Zove;
import com.infsus.suhs.model.ZoveId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoveRepository extends JpaRepository<Zove, ZoveId> {
}
