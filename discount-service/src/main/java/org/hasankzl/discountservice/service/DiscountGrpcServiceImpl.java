package org.hasankzl.discountservice.service;

import com.hasankzl.grpc.DiscountRequest;
import com.hasankzl.grpc.DiscountResponse;
import com.hasankzl.grpc.DiscountServiceGrpc;
import com.hasankzl.grpc.Response;
import org.hasankzl.discountservice.entity.Category;
import org.hasankzl.discountservice.entity.Discount;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.hasankzl.discountservice.repository.CategoryRepository;
import org.hasankzl.discountservice.repository.DiscountRepository;

import java.math.BigDecimal;
import java.util.Optional;

@GrpcService
@RequiredArgsConstructor
public class DiscountGrpcServiceImpl extends DiscountServiceGrpc.DiscountServiceImplBase {

    private final DiscountRepository discountRepository;

    private final CategoryRepository categoryRepository;
    @Override
    public void getDiscount(DiscountRequest request, StreamObserver<DiscountResponse> responseObserver) {


        Category category = categoryRepository.findByExternalId(request.getExternalCategoryId())
                .orElseThrow(() -> new RuntimeException("category not found"));

      Optional<Discount> discount= discountRepository.findByCodeAndCategoryId(request.getCode(),category.getId());

      if(discount.isPresent()){

          BigDecimal newPrice =  BigDecimal.valueOf(request.getPrice()).subtract(discount.get().getDiscountPrice());
          responseObserver.onNext(
                  DiscountResponse.newBuilder()
                          .setCode(discount.get().getCode())
                          .setOldPrice(request.getPrice())
                          .setNewPrice(newPrice.floatValue())
                          .setResponse(Response.newBuilder()
                                  .setMessage("discount has been applied successfully!")
                                  .setStatusCode(true).build())
                          .build());


      }else {
          responseObserver.onNext(
                  DiscountResponse.newBuilder().setResponse(Response.newBuilder()
                          .setMessage("discount noy found")
                          .setStatusCode(false).build()).setOldPrice(request.getPrice())
                          .build());

      }

        responseObserver.onCompleted();
    }
}
