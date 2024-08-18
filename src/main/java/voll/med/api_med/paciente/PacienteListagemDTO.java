package voll.med.api_med.paciente;

public record PacienteListagemDTO(Long id, String nome, String email, String cpg) {

    public PacienteListagemDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
