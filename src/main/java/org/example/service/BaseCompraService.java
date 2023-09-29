package org.example.service;

import org.example.model.CompraModel;
import org.example.model.ItemModel;
import org.example.model.RebeldeModel;
import org.example.repository.CompraRepository;
import org.example.repository.ItemRepository;
import org.example.repository.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseCompraService {

    private final RebeldeRepository rebeldeRepository;
    private final ItemRepository itemRepository;

    private final CompraRepository compraRepository;

    @Autowired
    public BaseCompraService(RebeldeRepository rebeldeRepository, ItemRepository itemRepository, CompraRepository compraRepository) {
        this.rebeldeRepository = rebeldeRepository;
        this.itemRepository = itemRepository;
        this.compraRepository = compraRepository;
    }

    private List<ItemModel> itens;



    public List<ItemModel> getItens() {
        return itens;
    }

    public boolean comprarItem(RebeldeModel rebelde, String nomeItem) {
        ItemModel itemSelecionado = itemRepository.findByNome(nomeItem);

        if (itemSelecionado != null) {
            if (rebelde.getMoedas() >= itemSelecionado.getValor()) {
                rebelde.setMoedas(rebelde.getMoedas() - itemSelecionado.getValor());
                rebeldeRepository.save(rebelde);
                compraRepository.save(new CompraModel(itemSelecionado.getId(), rebelde.getId()));
                return true;
            }
        }
        return false;
    }
}


