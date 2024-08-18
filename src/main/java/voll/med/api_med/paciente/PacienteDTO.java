package voll.med.api_med.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import voll.med.api_med.endereco.EnderecoDTO;

public record PacienteDTO(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotNull
        @Valid
        EnderecoDTO endereco
) {
}
