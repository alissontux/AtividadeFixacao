package org.example.controller;

import jakarta.persistence.EntityNotFoundException;
import org.example.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itens")
public class ItemController {
    private final ItemService itemService;
    @Autowired

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    @PostMapping("/{id}/comprar")
    public ResponseEntity<?> comprarItem(@PathVariable Long id, @RequestBody String nome){
        try{
            itemService.comprarItem(id, nome);
            return new ResponseEntity<>("Item comprado com sucesso", HttpStatus.OK);
        }catch (EntityNotFoundException e ){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
