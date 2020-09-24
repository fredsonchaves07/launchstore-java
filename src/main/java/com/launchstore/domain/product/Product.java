package com.launchstore.domain.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Product implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Necessário preencher o nome")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Necessário preencher a descrição")
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double oldPrice;

    @NotBlank(message = "O preço não pode ficar vazio")
    @Column(nullable = false)
    private Double price;

    @NotBlank(message = "Necessário informar a quantidade")
    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer status;
}
