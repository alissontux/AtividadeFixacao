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
    public ItemService(RebeldeRepository rebeldeRepository) {
        this.rebeldeRepository = rebeldeRepository;
    }

    public RebeldeModel comprarItem(Long id, String nomeItem) {
        RebeldeModel rebeldeModel = rebeldeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rebelde não encontrado"));

        if (!rebeldeModel.isRebeldeAtivo()) {
            throw new EntityNotFoundException("Rebelde não pode comprar o item");
        }

        ItemModel itemSelecionado;

        switch (nomeItem) {
            case "arma":
                itemSelecionado = new ItemModel("Arma", 100.0);
                break;

            case "municao":
                itemSelecionado = new ItemModel("Munição", 30.0);
                break;

            case "agua":
                itemSelecionado = new ItemModel("Água", 5.0);
                break;

            case "comida":
                itemSelecionado = new ItemModel("Comida", 15.0);
                break;

            default:
                throw new EntityNotFoundException("Item não existe");
        }

        rebeldeModel.adicionarItemAoInventario(itemSelecionado);

        return rebeldeRepository.save(rebeldeModel);
    }
}
