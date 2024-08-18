package voll.med.api_med.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import voll.med.api_med.paciente.*;



@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar (@RequestBody @Valid PacienteDTO dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<PacienteListagemDTO> listar(@PageableDefault (size = 5, page = 0, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(PacienteListagemDTO::new);
   }

    @PutMapping
    @Transactional
    public void atualizar (@RequestBody @Valid PacienteAtualizacaoDTO dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir (@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
    }

}
