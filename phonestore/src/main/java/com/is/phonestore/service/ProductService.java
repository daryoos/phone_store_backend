package com.is.phonestore.service;

import com.is.phonestore.model.Product;
import com.is.phonestore.request.AddProductDTO;
import com.is.phonestore.request.UpdateProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public interface ProductService {
    Product getProductById(Long id);

    List<Product> getProductsByUserId(Long userId);

    void addProduct(AddProductDTO product, MultipartFile imageUrl) throws Exception;

    void deleteProduct(Long productId) throws Exception;

    void updateProduct(UpdateProductDTO updateProductDTO, Long id) throws Exception;
}
