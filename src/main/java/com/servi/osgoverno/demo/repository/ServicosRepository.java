package com.servi.osgoverno.demo.repository;

import com.servi.osgoverno.demo.model.domain.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicosRepository extends JpaRepository<Servicos, Long> {
}
