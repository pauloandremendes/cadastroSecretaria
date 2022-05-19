package com.servi.osgoverno.demo.service;

import com.servi.osgoverno.demo.model.domain.Secretaria;
import com.servi.osgoverno.demo.repository.SecretariaRepository;
import com.servi.osgoverno.demo.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SecretariaService {

    @Autowired
    private SecretariaRepository secretariaRepository;

    @Autowired
    private ServicosRepository servicosRepository;

    public Secretaria criar(final Secretaria secretaria) {
        return secretariaRepository.save(secretaria);
    }

    public Secretaria obter(final Long id) {
        return secretariaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Secretaria não encontrada"));
    }

    public List<Secretaria> listar() {
        List<Secretaria> secretarias = secretariaRepository.findAll();
        return secretarias;
    }

    public Secretaria editar(final Secretaria secretaria) {
        return secretariaRepository.save(secretaria);
    }

    //Colocar uma validação...Se tiver um serviço, não deve excluir a secretaria
    public void deletar(final Long id) {
        secretariaRepository.deleteById(id);
    }
}
