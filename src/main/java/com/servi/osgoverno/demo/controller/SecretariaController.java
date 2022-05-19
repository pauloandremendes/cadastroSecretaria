package com.servi.osgoverno.demo.controller;

import com.servi.osgoverno.demo.model.domain.Secretaria;
import com.servi.osgoverno.demo.model.dto.SecretariaDTO;
import com.servi.osgoverno.demo.service.SecretariaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Secretaria")
@Api(value = "Cadastro de secretarias.")
public class SecretariaController {

    @Autowired
    private SecretariaService secretariaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Realiza a criação de secretaria.")
    public SecretariaDTO criar(@RequestBody final SecretariaDTO dto) {
        final Secretaria secretaria = modelMapper.map(dto, Secretaria.class);
        final Secretaria secretariaSalvo = secretariaService.criar(secretaria);
        return modelMapper.map(secretariaSalvo, SecretariaDTO.class);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Realiza a obteção por id.")
    public SecretariaDTO obter(@PathVariable final Long id) {
        final Secretaria secretaria = secretariaService.obter(id);
        return modelMapper.map(secretaria, SecretariaDTO.class);
    }

    @GetMapping
    @ApiOperation(value = "Realiza a listagem geral da secretaria.")
    public List<SecretariaDTO> listar() {
        final List<Secretaria> secretarias = secretariaService.listar();
        return secretarias.stream().map(secretaria -> modelMapper.map(secretaria, SecretariaDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    @ApiOperation(value = "Realiza a edição da secretaria.")
    public SecretariaDTO editar(@RequestBody final SecretariaDTO dto) {
        final Secretaria secretaria = modelMapper.map(dto, Secretaria.class);
        final Secretaria secretariaAtualizado = secretariaService.editar(secretaria);
        return modelMapper.map(secretariaAtualizado, SecretariaDTO.class);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta a secretaria.")
    public void deletar(@PathVariable final Long id) {
        secretariaService.deletar(id);
    }
}

