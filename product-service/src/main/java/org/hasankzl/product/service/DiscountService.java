package org.hasankzl.product.service;

import com.hasankzl.grpc.DiscountRequest;
import com.hasankzl.grpc.DiscountResponse;
import lombok.RequiredArgsConstructor;
import org.hasankzl.product.model.Product;
import org.hasankzl.product.service.grpc.DiscountGrpcService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountService {

    private final DiscountGrpcService discountGrpcService;
    private final ProductService productService;

    public DiscountResponse getDiscount(int productId,String code){
        Product product = productService.getById(productId);
        DiscountRequest discountRequest = DiscountRequest.newBuilder()
                .setCode(code)
                .setPrice(product.getPrice().floatValue())
                .setExternalCategoryId(String.valueOf(product.getCategory().getId()))
                .build();
        return discountGrpcService.getDiscount(discountRequest);
    }
}
