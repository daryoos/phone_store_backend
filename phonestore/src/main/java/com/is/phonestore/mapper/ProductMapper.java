package com.is.phonestore.mapper;

import com.is.phonestore.dto.ProductDTO;
import com.is.phonestore.model.Product;
import com.is.phonestore.request.AddProductDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Component;

@With
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProductMapper {
    // TODO: trebuie legat si de User?
    private Product product;
    private AddProductDTO addProductDTO;

    public ProductDTO mapToDTO() {
        return mapProductToDTO(product);
    }

    public Product mapToEntity() {
        return mapAddProductDTOToEntity(addProductDTO);
    }

    private ProductDTO mapProductToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId(product.getProductId());
        productDTO.setBrand(product.getBrand());
        productDTO.setCondition(product.getProductCondition());
        productDTO.setModel(product.getModel());
        productDTO.setLocation(product.getLocation());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getProductDescription());
        productDTO.setSold(product.getSold());
        productDTO.setUserId(product.getUserId());

        return productDTO;
    }

    private Product mapAddProductDTOToEntity(AddProductDTO addProductDTO) {
        Product product = new Product();

        // TODO: Trebuie si functia product.setUser?
        product.setModel(addProductDTO.getModel());
        product.setLocation(addProductDTO.getLocation());
        product.setProductDescription(addProductDTO.getDescription());
        product.setProductCondition(addProductDTO.getCondition());
        product.setBrand(addProductDTO.getBrand());
        product.setPrice(addProductDTO.getPrice());
        product.setSold(addProductDTO.getSold());
        product.setUserId(addProductDTO.getUserId());

        return product;
    }
}
