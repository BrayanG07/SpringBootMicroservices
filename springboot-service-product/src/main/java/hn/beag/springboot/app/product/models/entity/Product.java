package hn.beag.springboot.app.product.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tbl_products")
@Data
@NoArgsConstructor
public class Product implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column
    private Double price;

    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Transient
    private Integer serverPort;
}
