package com.ecommerce.productservice.thirdpartyclients.fakestoreclient;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@Configuration
public class FakeStoreClientAdapter {
    private RestTemplateBuilder restTemplateBuilder;
    private String baseURL;
    private String productsURL;
    private String categoriesURL;
    private String getProductUrl;
    private String getAllProductUrl;

    public FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String baseURL,
                                  @Value("${fakestore.api.paths.products}") String productsURL, @Value("${fakestore.api.paths.categories}") String categoriesURL) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.baseURL = baseURL;
        this.productsURL = productsURL;
        this.categoriesURL = categoriesURL;
        this.getProductUrl = baseURL + productsURL + "/{id}";
        this.getAllProductUrl = baseURL + productsURL;
    }

    public FakeStoreProductDto getProductById(long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(getProductUrl, FakeStoreProductDto.class, id);

        return (responseEntity.getBody());
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(getAllProductUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> result = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());

        return fakeStoreProductDtos;
    }

    public FakeStoreProductDto deleteProductById(long id) {

        RestTemplate restTemplate = new RestTemplateBuilder().build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(getProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return (responseEntity.getBody());
    }

    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(getAllProductUrl, genericProductDto, FakeStoreProductDto.class);
        return (responseEntity.getBody());

    }

    public void updateProductById() {

    }
}
