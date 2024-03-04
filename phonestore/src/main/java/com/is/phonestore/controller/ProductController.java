package com.is.phonestore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.is.phonestore.dto.ProductDTO;
import com.is.phonestore.mapper.ProductMapper;
import com.is.phonestore.model.Product;
import com.is.phonestore.repository.ProductRepository;
import com.is.phonestore.request.AddProductDTO;
import com.is.phonestore.request.UpdateProductDTO;
import com.is.phonestore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
public class ProductController implements ProductControllerResource {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<ProductDTO> getProductById(Long id) {
        System.out.println("LOG:\n" + productService.getProductById(id));
        ProductDTO productDTO = productMapper.withProduct(productService.getProductById(id)).mapToDTO();

        return ResponseEntity.accepted().body(productDTO);
    }

    @Override
    public ResponseEntity<String> addProduct(String addProductDTOString, MultipartFile imageUrl) throws Exception {
        try {

            var mapper = new ObjectMapper();
            var addProductDTO = mapper.readValue(addProductDTOString, AddProductDTO.class);

            productService.addProduct(addProductDTO, imageUrl);

        } catch (Exception exception) {
            throw new Exception(exception.getMessage());

        }

        return ResponseEntity.accepted().body("Created Successfully");
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByUserId(Long userId) {
        return ResponseEntity.status(200).body(productService.getProductsByUserId(userId));
    }

    @Override
    public ResponseEntity<String> deleteProductById(Long productId) {
        try {
            productService.deleteProduct(productId);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.toString());
        }

        return ResponseEntity.status(200).body("Product has been deleted...");
    }

    @Override
    public ResponseEntity<String> updateProduct(UpdateProductDTO updateProductDTO, Long id) throws Exception {
        try {
            productService.updateProduct(updateProductDTO, id);
        } catch (Exception exception) {
            return ResponseEntity.status(400).body("Product does not exist");
        }
        return ResponseEntity.status(200).body("Updated successfully");
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {

        var products = productRepository.getProductsBySoldIsFalse();

        return ResponseEntity.status(200).body(products);
    }

}
