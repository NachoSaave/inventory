package inventory.inventory.Service;

import org.springframework.stereotype.Service;

import inventory.inventory.Model.inventory.Inventory;
import inventory.inventory.Repository.Repositoryinventory;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ServiceInventory {
  private final Repositoryinventory repository;

    public Inventory getByMoto(Long motoId) {

        return repository.findByMotoId(motoId)
                .orElseThrow();
    }

    public void DescontarStock(Long motoId, Integer stock) {

        Inventory inventory = repository.findByMotoId(motoId)
                .orElseThrow();

        inventory.setStock(
                inventory.getStock() - stock
        );

        repository.save(inventory);
    }
}
