package inventory.inventory.Service;

import java.util.List;

import org.springframework.stereotype.Service;


import inventory.inventory.Model.inventory;
import inventory.inventory.Repository.Repositoryinventory;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final Repositoryinventory repository;

    // LISTAR
    public List<inventory> listar(){
        return repository.findAll();
    }

    // BUSCAR POR ID
    public inventory buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    // GUARDAR
    public inventory guardar(inventory inventario){
        return repository.save(inventario);
    }

    // ELIMINAR
    public void eliminar(Long id){
        repository.deleteById(id);
    }
}