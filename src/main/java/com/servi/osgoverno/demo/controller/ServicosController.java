package com.servi.osgoverno.demo.controller;

import com.servi.osgoverno.demo.model.domain.Servicos;
import com.servi.osgoverno.demo.model.dto.ServicosDTO;
import com.servi.osgoverno.demo.service.ServicosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/Servicos")
@Api(value = "Cadastro de serviços.")
public class ServicosController {

    @Autowired
    private ServicosService servicosService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Realiza a criação do serviço.")
    public ServicosDTO criar(@RequestBody final ServicosDTO dto) {
        final Servicos servicos = modelMapper.map(dto, Servicos.class);
        final Servicos servicosSalvo = servicosService.criar(servicos);
        return modelMapper.map(servicosSalvo, ServicosDTO.class);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Realiza a obtenção do serviço por id.")
    public ServicosDTO obter(@PathVariable final Long id) {
        final Servicos servicos = servicosService.obter(id);
        return modelMapper.map(servicos, ServicosDTO.class);
    }

    @GetMapping
    @ApiOperation(value = "Realiza a listagem do serviço.")
    public List<ServicosDTO> listar() {
        final List<Servicos> servicos = servicosService.listar();
        return servicos.stream().map(servico -> modelMapper.map(servicos, ServicosDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    @ApiOperation(value = "Realiza a edição do serviço.")
    public ServicosDTO editar(@RequestBody final ServicosDTO dto) {
        final Servicos servicos = modelMapper.map(dto, Servicos.class);
        final Servicos servicosAtualizados = servicosService.editar(servicos);
        return modelMapper.map(servicosAtualizados, ServicosDTO.class);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta o serviço.")
    public void deletar(@PathVariable final Long id) {
        servicosService.deletar(id);
    }

}
