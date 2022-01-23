package com.lrtbl.helloworld.restMongo.controllers;


import com.lrtbl.helloworld.restMongo.dto.ClientDto;
import com.lrtbl.helloworld.restMongo.dto.ProductDto;
import com.lrtbl.helloworld.restMongo.models.ClientModel;
import com.lrtbl.helloworld.restMongo.models.ProductModel;
import com.lrtbl.helloworld.restMongo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ProductModel> createProduct (@RequestBody ProductDto productDto){
        ProductModel productModel = convertToEntity(productDto);
        return new ResponseEntity<>(productService.createProduct(productModel, productDto.getClientId()), HttpStatus.OK);
    }

    private ProductModel convertToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, ProductModel.class);
    }
}
