package com.stlang.dreamshops.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name ="categoryId")
    private Category category;
    @OneToMany (mappedBy = "product", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Image> image;
}
