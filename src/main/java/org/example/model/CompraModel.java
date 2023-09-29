package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "compra")
public class CompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_compra")
    private Long item;


    @Column(name = "rebelde_compra")
    private Long rebeldeModels;

    public CompraModel(Long item, Long rebeldeModels) {
        this.item = item;
        this.rebeldeModels = rebeldeModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public Long getRebeldeModels() {
        return rebeldeModels;
    }

    public void setRebeldeModels(Long rebeldeModels) {
        this.rebeldeModels = rebeldeModels;
    }
}
