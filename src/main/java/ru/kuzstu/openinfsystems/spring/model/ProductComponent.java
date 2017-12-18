package ru.kuzstu.openinfsystems.spring.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "product_component")
public class ProductComponent {

    @Id
    @Column(name = "product_component_id")
    @GeneratedValue
    private int productComponentId;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "name", nullable = false)
    private String name;

    public int getProductComponentId() {
        return productComponentId;
    }

    public void setProductComponentId(int productComponentId) {
        this.productComponentId = productComponentId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
