package org.example.controller;

import org.example.model.RebeldeModel;
import org.example.service.BaseCompraService;
import org.example.service.RebeldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rebeldes")
public class RebeldeController {
    private final RebeldeService rebeldeService;
    private final BaseCompraService baseCompraService;
    @Autowired
    public RebeldeController(RebeldeService rebeldeService, BaseCompraService baseCompraService) {
        this.rebeldeService = rebeldeService;
        this.baseCompraService = baseCompraService;
    }
    @PostMapping
    public RebeldeModel adicionarRebeldes(@RequestBody RebeldeRequest rebeldeRequest) {
        return rebeldeService.adicionarRebeldes(rebeldeRequest);
    }

    @PutMapping("/{id}")
    public RebeldeModel atualizarRebeldes(@PathVariable Long id, @RequestBody RebeldeModel rebeldeModel) {
        return rebeldeService.atualizarLocalizacaoRebeldes(id, rebeldeModel);
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
    @PostMapping("/{id}/comprar")
    public ResponseEntity<String> comprarItem(@PathVariable Long id){
        RebeldeModel rebeldeModel = rebeldeService.obterRebeldePorId(id);
//        boolean compraSucesso = baseCompraService.comprarItem(rebeldeModel);
//        if (compraSucesso ){
//            return ResponseEntity.ok("Compra efetuada com sucesso");
//        }else {
//            return ResponseEntity.badRequest().body("Compra falhou");
//        }
        return null;
    }
}
