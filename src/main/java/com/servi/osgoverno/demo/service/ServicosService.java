package com.servi.osgoverno.demo.service;

import com.servi.osgoverno.demo.model.domain.Secretaria;
import com.servi.osgoverno.demo.model.domain.Servicos;
import com.servi.osgoverno.demo.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ServicosService {

    @Autowired
    private ServicosRepository servicosRepository;

    public Servicos criar(final Servicos servicos) {
        return servicosRepository.save(servicos);
    }

    public Servicos obter(final Long id) {
        return servicosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));
    }

    public List<Servicos> listar() {
        List<Servicos> servicos = servicosRepository.findAll();
        return servicos;
    }

    public Servicos editar(final Servicos servicos) {
        return servicosRepository.save(servicos);
    }

    public void deletar(final Long id) {
        servicosRepository.deleteById(id);
    }
}
