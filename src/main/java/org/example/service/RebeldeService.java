package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.controller.RebeldeRequest;
import org.example.model.RebeldeModel;
import org.example.repository.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RebeldeService {
    private final RebeldeRepository repository;

    @Autowired
    public RebeldeService(RebeldeRepository repository) {
        this.repository = repository;
    }

    public RebeldeModel adicionarRebeldes(RebeldeRequest rebeldeRequest){

        if (rebeldeRequest.getNome() == null ||
                rebeldeRequest.getIdade() <= 0 ||
                rebeldeRequest.getGenero() == null ||
                rebeldeRequest.getLocalizacao() == null ||
                rebeldeRequest.getInventario() == null) {
            throw new IllegalArgumentException("Todos os campos obrigatórios devem ser fornecidos.");
        }

        RebeldeModel rebeldeModel = new RebeldeModel();

        rebeldeModel.setNome(rebeldeRequest.getNome());
        rebeldeModel.setIdade(rebeldeRequest.getIdade());
        rebeldeModel.setGenero(rebeldeRequest.getGenero());
        rebeldeModel.setLocalizacao(rebeldeRequest.getLocalizacao());
        rebeldeRequest.setInventario(rebeldeRequest.getInventario());

        return repository.save(rebeldeModel);
    }

    public RebeldeModel atualizarLocalizacaoRebeldes(Long id){
        RebeldeModel rebeldeModel = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado por esse id: " + id));

        rebeldeModel.setLocalizacao(rebeldeModel.getLocalizacao());

        return repository.save(rebeldeModel);
    }
    public RebeldeModel reportartraicao(Long id){
        RebeldeModel rebeldeModel = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
        if (rebeldeModel.isTraidor()){
           throw new EntityNotFoundException("Este rebelde já é um traidor");
        }
        rebeldeModel.incrementarreportestraicao();
        if (rebeldeModel.getReportesTraicao()>=3){
            rebeldeModel.setTraidor(true);
            rebeldeModel.setRebeldeAtivo(false);
        }
        return repository.save(rebeldeModel);
    }
}
