package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductUrl = "https://fakestoreapi.com/products/{id}";
    private String getAllProductUrl = "https://fakestoreapi.com/products/";

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto getProductById(long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(getProductUrl, FakeStoreProductDto.class, id);

        return convertFaketoGenericDto(responseEntity.getBody());
    }

    private static GenericProductDto convertFaketoGenericDto(FakeStoreProductDto fdto) {

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fdto.getId());
        genericProductDto.setTitle(fdto.getTitle());
        genericProductDto.setDescription(fdto.getDescription());
        genericProductDto.setPrice(fdto.getPrice());
        genericProductDto.setCategory(fdto.getCategory());
        genericProductDto.setImage(fdto.getImage());
        return genericProductDto;

    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(getAllProductUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> result = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            result.add(convertFaketoGenericDto(fakeStoreProductDto));
        }
        return result;
    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(getAllProductUrl, genericProductDto, FakeStoreProductDto.class);
        return convertFaketoGenericDto(responseEntity.getBody());

    }

    @Override
    public void updateProductById() {

    }
}
