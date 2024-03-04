package com.is.phonestore.controller;

import com.is.phonestore.dto.ProductDTO;
import com.is.phonestore.model.Product;
import com.is.phonestore.request.UpdateProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping(value = "/v1/products")
public interface ProductControllerResource {

    @GetMapping(value = "/getProductById/{id}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable Long id);

    @PostMapping(value = "/addProduct")
    ResponseEntity<String> addProduct(@RequestParam("addProductDto") String addProductDTO, @RequestParam("file") MultipartFile image) throws Exception;

   @GetMapping(value = "")
   ResponseEntity<List<Product>> getAllProducts();

    @GetMapping(value = "/getProductsByUserId/{userId}")
    ResponseEntity<List<Product>> getProductsByUserId(@PathVariable Long userId);

    @DeleteMapping(value = "/deleteProductById/{productId}")
    ResponseEntity<String> deleteProductById(@PathVariable Long productId);

    @PutMapping(value = "/updateProduct/{id}")
    ResponseEntity<String> updateProduct(@RequestBody UpdateProductDTO updateProductDTO, @PathVariable Long id) throws Exception;
}
