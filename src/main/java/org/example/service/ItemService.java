package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.model.ItemModel;
import org.example.model.RebeldeModel;
import org.example.repository.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {


    private final RebeldeRepository rebeldeRepository;
    @Autowired
    public ItemService(RebeldeRepository rebeldeRepository){
        this.rebeldeRepository = rebeldeRepository;
    }

    public RebeldeModel comprarItem(Long id, String nomeItem){
        RebeldeModel rebeldeModel = rebeldeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));
        if (!rebeldeModel.isRebeldeAtivo()){
            throw new EntityNotFoundException("Rebelde não pode comprar o item");
        }
        ItemModel arma = new ItemModel("Arma", 100.0);
        ItemModel municao = new ItemModel("Munição", 30.0);
        ItemModel agua = new ItemModel("Água", 5.0);
        ItemModel comida = new ItemModel("Comida", 15.0);
        ItemModel itemSelecionado = null;
        switch (nomeItem){
            case "Arma":
                itemSelecionado = arma;
                break;

            case "Munição":
                itemSelecionado = municao;
                break;

            case "Água":
                itemSelecionado = agua;
                break;

            case "Comida":
                itemSelecionado = comida;
                break;

            default:
                throw new EntityNotFoundException("Item não existe");
        }
        return rebeldeRepository.save(rebeldeModel);
    }
}
