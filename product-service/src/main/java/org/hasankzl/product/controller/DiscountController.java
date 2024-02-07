package org.hasankzl.product.controller;

import com.hasankzl.grpc.DiscountResponse;
import lombok.RequiredArgsConstructor;
import org.hasankzl.product.model.dto.DiscountResponseDto;
import org.hasankzl.product.service.DiscountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/discounts")
public class DiscountController {

    private final DiscountService discountService;


    @GetMapping()
    public ResponseEntity<DiscountResponseDto> getDiscount(@RequestParam String code,
                                                           @RequestParam int productId){

        DiscountResponse discountResponse = discountService.getDiscount(productId,code);
        return ResponseEntity.ok(DiscountResponseDto.builder()
                .code(discountResponse.getCode())
                .newPrice(discountResponse.getNewPrice())
                .oldPrice(discountResponse.getOldPrice())
                .code(discountResponse.getCode()).build());
    }
}
