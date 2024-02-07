package org.hasankzl.product.model.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DiscountResponseDto {

private float newPrice;

private float oldPrice;

private String categoryId;
private String code;

}
