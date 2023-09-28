//package org.example.controller;
//
//import jakarta.persistence.EntityNotFoundException;
//import org.example.model.ItemModel;
//import org.example.service.ItemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/itens")
//public class ItemController {
//    private final ItemService itemService;
//
//    @Autowired
//
//    public ItemController(ItemService itemService) {
//        this.itemService = itemService;
//    }
//
//    @PostMapping("/{id}/comprar")
//    public ResponseEntity<String> comprarItem(@PathVariable Long id, @RequestBody String nome) {
//        try {
//            itemService.comprarItem(id, nome);
//            return ResponseEntity.ok("Item comprado com sucesso");
//        } catch (EntityNotFoundException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping
//    public List<ItemModel> listarItens() {
//        return itemService.listarItens();
//    }
//}
