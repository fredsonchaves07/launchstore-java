package com.launchstore.domain.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Product implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Necessário preencher o nome")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Necessário preencher a descrição")
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double oldPrice;

    @NotNull(message = "O preço não pode ficar vazio")
    @Column(nullable = false)
    private Double price;

    @NotNull(message = "Necessário informar a quantidade")
    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer status;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date modifiedAt;
}
