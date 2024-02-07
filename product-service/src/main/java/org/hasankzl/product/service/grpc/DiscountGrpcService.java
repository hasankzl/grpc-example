package org.hasankzl.product.service.grpc;

import com.hasankzl.grpc.DiscountRequest;
import com.hasankzl.grpc.DiscountResponse;

public interface DiscountGrpcService {

    DiscountResponse getDiscount(DiscountRequest discountRequest);
}
