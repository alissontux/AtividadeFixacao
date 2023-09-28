package org.example.service;

import org.example.model.ItemModel;
import org.example.model.RebeldeModel;
import org.example.repository.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseCompraService {
    @Autowired
    private final RebeldeRepository rebeldeRepository;
    private List<ItemModel> itens;

    public BaseCompraService(RebeldeRepository rebeldeRepository) {
        this.rebeldeRepository = rebeldeRepository;
        this.itens = new ArrayList<>();
        itens.add(new ItemModel("Arma", 100.0));
        itens.add(new ItemModel("Munição", 30.0));
        itens.add(new ItemModel("Água", 5.0));
        itens.add(new ItemModel("Comida", 15.0));
    }

    public List<ItemModel> getItens() {
        return itens;
    }

    public boolean comprarItem(RebeldeModel rebelde, String nomeItem) {
        ItemModel itemSelecionado = null;
        for (ItemModel item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itemSelecionado = item;
                break;
            }
        }

        if (itemSelecionado != null) {
            if (rebelde.getMoedas() >= itemSelecionado.getValor()) {
                rebelde.setMoedas(rebelde.getMoedas() - itemSelecionado.getValor());
                rebelde.adicionarItemAoInventario(itemSelecionado);
                return true;
            }
        }
        return false;
    }
}


