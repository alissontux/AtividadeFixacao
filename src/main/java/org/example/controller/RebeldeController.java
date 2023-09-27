package org.example.controller;

import org.example.model.RebeldeModel;
import org.example.service.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rebeldes")
public class RebeldeController {
    private final RebeldeService rebeldeService;

    @Autowired
    public RebeldeController(RebeldeService rebeldeService) {
        this.rebeldeService = rebeldeService;
    }

    @PostMapping
    public RebeldeModel adicionarRebeldes(@RequestBody RebeldeRequest rebeldeRequest){
        return rebeldeService.adicionarRebeldes(rebeldeRequest);
    }

    @PutMapping("/{id}")
    public RebeldeModel atualizarRebeldes(@PathVariable Long id){
        return rebeldeService.atualizarLocalizacaoRebeldes(id);
    }
}
