package inventory.inventory.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inventory.inventory.Model.inventory.Inventory;
import inventory.inventory.Service.ServiceInventory;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor

public class Controllerinventary {
    private final ServiceInventory service;

    @GetMapping("/{motoId}")
    public ResponseEntity<Inventory> getInventory(
            @PathVariable Long motoId) {

        return ResponseEntity.ok(
                service.getByMoto(motoId)
        );
    }

    @PostMapping
    public ResponseEntity<Inventory>guardar(

        @RequestBody
        Inventory inventario){

        return ResponseEntity.ok(
                service.guardar(
                        inventario
                )
        );
    }
    @GetMapping
    public ResponseEntity<List<Inventory>>listar(){

        return ResponseEntity.ok(
                service.listar()
        );
    }
}
