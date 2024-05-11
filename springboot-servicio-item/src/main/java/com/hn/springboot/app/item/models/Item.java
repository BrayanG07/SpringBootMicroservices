package com.hn.springboot.app.item.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	private Product product;
	private Integer quantity;

	public Double getTotal() {
		return this.product.getPrice() * this.getQuantity().doubleValue();
	}
}
