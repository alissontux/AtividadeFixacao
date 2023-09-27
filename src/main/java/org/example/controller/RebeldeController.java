package org.example.controller;

import org.example.model.RebeldeModel;
import org.example.service.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public RebeldeModel adicionarRebeldes(@RequestBody RebeldeRequest rebeldeRequest) {
        return rebeldeService.adicionarRebeldes(rebeldeRequest);
    }

    @PutMapping("/{id}")
    public RebeldeModel atualizarRebeldes(@PathVariable Long id) {
        return rebeldeService.atualizarLocalizacaoRebeldes(id);
    }

    @PostMapping("/{id}/traicao")
    public RebeldeModel reportartraicao(@PathVariable Long id) {
        return rebeldeService.reportartraicao(id);

    }

    @GetMapping("/porcentagemTraidores")
    public ResponseEntity<Double> calcularPorcentagemTraidores() {
        double totalRebeldes = rebeldeService.contarRebeldes();
        long traidores = rebeldeService.contarTraidores();
        double porcentagemTraidores = ((double) traidores / totalRebeldes) * 100;

        return ResponseEntity.ok(porcentagemTraidores);
    }

    @GetMapping("/porcenagemRebeldes")
    public ResponseEntity<Double> calcularPocentagemRebeldes() {
        double totalRebeldes = rebeldeService.contarRebeldes();
        long traidores = rebeldeService.contarTraidores();
        double porcentagemRebeldes = ((double) traidores - totalRebeldes) / totalRebeldes * 100;

        return ResponseEntity.ok(porcentagemRebeldes);
    }
}
