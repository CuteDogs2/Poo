package com.project.service;




import com.project.model.pessoas.Veterinario;
import com.project.repository.VeterinarioRepository;

import java.sql.SQLException;
import java.util.List;

public class VeterinarioService {




    private final VeterinarioRepository veterinarioRepository;




    public VeterinarioService() {
        this.veterinarioRepository = new VeterinarioRepository();
    }




    public List<Veterinario> getVeterinariosDisponiveis() throws SQLException {
        return this.veterinarioRepository.buscarTodos();
    }
}
