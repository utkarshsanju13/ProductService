package com.scaler.ProductService.service;

import com.scaler.ProductService.dtos.FakeStoreProductDto;
import com.scaler.ProductService.exception.ProductNotFoundException;
import com.scaler.ProductService.model.Category;
import com.scaler.ProductService.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("FakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService {
    //This service implement all the API using faceStore

    private RestTemplate restTemplate ;
    @Value("${fakestore.api.base-url}")
    private String baseUrl;

    public FakeStoreProductServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {

//        throw new RuntimeException();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntityResp =
                restTemplate.getForEntity(baseUrl + "/products/" + id,
                        FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductService = fakeStoreProductDtoResponseEntityResp.getBody();

        if(fakeStoreProductService == null){
            throw new ProductNotFoundException(id,"Product with id" + id + " is not found ");
        }
        return convertFakeSToreDtoToProduct(fakeStoreProductDtoResponseEntityResp.getBody());
    }

    @Override
    public List<Product> getAllProduct() {
//        APPROACH 1:
//        This is approach one where we are using FakeStoreProductDto[]>
//        beacuse if we use List<FakeStoreProductDto>.class to get the response it will show error
//                as this API will trigger at runtime
//                but java runtime me sare collection ka type erase krke Object kr deta hia toh
//                its a bad practice to store any object (i.e. FakeStoreProductDto) in Listobject>

//            That why we use FakeStoreProductDto[] to avoid type erase problem at runtime.

        /*ResponseEntity<FakeStoreProductDto[]> listResponseEntity =
                restTemplate.getForEntity(baseUrl +"/products",
                        FakeStoreProductDto[].class);

        FakeStoreProductDto [] fakeStoreProductDtos =
                listResponseEntity.getBody();
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
            products.add(convertFakeSToreDtoToProduct(fakeStoreProductDto));

        }
        return products;*/

//        APPROACH 2:
        /*Use ParameterizedTypeReference : it preserve the type at runtime
        Java mein type erasure ki wajah se generics (jaise List<T>) ka
        type runtime pe lost ho jata hai,
        aur sirf raw type (List) rehta hai. ParameterizedTypeReference is problem ko solve karta hai by explicitly type information provide karke*/

        ParameterizedTypeReference<List<FakeStoreProductDto>> parameterizedTypeReference =
                new ParameterizedTypeReference<List<FakeStoreProductDto>>() {};

        //use restTemplate.exchange()
        ResponseEntity<List<FakeStoreProductDto>> responseEntity =
                restTemplate.exchange(baseUrl +"/products", HttpMethod.GET,null,parameterizedTypeReference);

        List<FakeStoreProductDto> fakeStoreProductDtos = responseEntity.getBody();

        return fakeStoreProductDtos.stream()
                .map(FakeStoreProductServiceImpl::convertFakeSToreDtoToProduct)
                .collect(Collectors.toList());
    }


    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }

    public static Product convertFakeSToreDtoToProduct(FakeStoreProductDto fakeStoreProductDto){

        if(fakeStoreProductDto == null){
            return null;
        }

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
