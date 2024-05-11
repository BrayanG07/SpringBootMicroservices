package com.hn.springboot.app.item.models;

import java.util.Date;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Long id;
	private String name;
	private Double price;
	private Date createdAt;
	private Integer serverPort;
}
