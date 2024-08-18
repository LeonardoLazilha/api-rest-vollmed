package voll.med.api_med.medico;

import jakarta.validation.constraints.NotNull;
import voll.med.api_med.endereco.EnderecoDTO;

public record MedicoAtualizacaoDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {
}
