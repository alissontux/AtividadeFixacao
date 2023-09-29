package org.example.controller;

import org.example.controller.request.ItemRequest;
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
        double todos = rebeldeService.contarTodosRebeldesETraidores();
        long traidores = rebeldeService.contarTraidores();
        double porcentagemTraidores = ((double) traidores / todos) * 100;

        return ResponseEntity.ok(porcentagemTraidores);
    }

    @GetMapping("/porcenagemRebeldes")
    public ResponseEntity<Double> calcularPocentagemRebeldes() {
        double todos = rebeldeService.contarTodosRebeldesETraidores();

        double totalRebeldes = rebeldeService.contarRebeldes();

        double porcentagemRebeldes = (  totalRebeldes) / todos * 100;

        return ResponseEntity.ok(porcentagemRebeldes);
    }
    @GetMapping("/{id}/moedas")
    public ResponseEntity<Double> obterQuantidadeMoedas(@PathVariable Long id) {
        RebeldeModel rebelde = rebeldeService.obterRebeldePorId(id);
        return ResponseEntity.ok(rebelde.getMoedas());
    }

    @PostMapping("/{id}/comprar")
    public ResponseEntity<String> comprarItem(@PathVariable Long id, @RequestBody ItemRequest itemRequest) {
        RebeldeModel rebelde = rebeldeService.obterRebeldePorId(id);
        if(rebelde == null) return ResponseEntity.badRequest().body("Rebelde nao encontrado");
        if(!rebelde.isRebeldeAtivo()) return ResponseEntity.badRequest().body("Rebelde nao ativo");

       try{
           boolean b = baseCompraService.comprarItem(rebelde, itemRequest.getNome());
           if(!b) return ResponseEntity.ok("Compra nao efetuada. Sem saldo.");//todo colocar exception handler
           return ResponseEntity.ok("Compra efetuada com sucesso");
       }catch (Exception exception){
           return ResponseEntity.badRequest().body("Compra falhou");
       }
    }
}
