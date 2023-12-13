package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.thirdpartyclients.fakestoreclient.FakeStoreClientAdapter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("FakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{

    private FakeStoreClientAdapter fakeStoreClientAdapter;

    public FakeStoreProductServiceImpl(FakeStoreClientAdapter fakeStoreClientAdapter) {
        this.fakeStoreClientAdapter = fakeStoreClientAdapter;
    }

    private static GenericProductDto convertToGenericDTO(FakeStoreProductDto fdto) {

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
    public GenericProductDto getProductById(long id) {
        return convertToGenericDTO(fakeStoreClientAdapter.getProductById(id));
    }



    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClientAdapter.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            genericProductDtos.add(convertToGenericDTO(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductById(long id) {

        return convertToGenericDTO(fakeStoreClientAdapter.deleteProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {

        return convertToGenericDTO(fakeStoreClientAdapter.createProduct(genericProductDto));

    }

    @Override
    public void updateProductById() {

    }

}
