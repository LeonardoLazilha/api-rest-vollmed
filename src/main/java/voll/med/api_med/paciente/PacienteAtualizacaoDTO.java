package voll.med.api_med.paciente;

import jakarta.validation.constraints.NotNull;
import voll.med.api_med.endereco.EnderecoDTO;

public record PacienteAtualizacaoDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {
}
