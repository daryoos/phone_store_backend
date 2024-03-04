package com.is.phonestore.service;

import com.is.phonestore.model.Product;
import com.is.phonestore.repository.ProductRepository;
import com.is.phonestore.request.AddProductDTO;
import com.is.phonestore.request.UpdateProductDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;
    private final ImageService imageService;

    @Override
    public Product getProductById(Long id) {
        System.out.println("LOG:\n" + productRepository.findProductByProductId(id) + "\n");
        return productRepository.findProductByProductId(id);
    }

    @Override
    public void addProduct(AddProductDTO productDTO, MultipartFile file) throws Exception {
        var product = new Product();
        try {
            var imageUrl = imageService.addImage(file);
            var userData = userService.getUserById(productDTO.getUserId());

            if (userData != null) {

                product.setBrand(productDTO.getBrand());
                product.setModel(productDTO.getModel());
                product.setPrice(productDTO.getPrice());
                product.setProductCondition(productDTO.getCondition());
                product.setProductDescription(productDTO.getDescription());
                product.setLocation(productDTO.getLocation());
                product.setSold(productDTO.getSold());
                product.setUserId(userData.getUserId());
                product.setImageUrl(imageUrl);

                productRepository.save(product);
            } else {
                throw new Exception("User does not exist");
            }
        } catch (Exception exception) {
            throw new Exception(exception.toString());
        }
    }

    @Override
    public void deleteProduct(Long productId) throws Exception {
        var productData = productRepository.findProductByProductId(productId);

        if (productData != null) {
            productRepository.delete(productData);
        } else {
            throw new Exception("Product does not exist...");
        }
    }

    @Override
    public void updateProduct(UpdateProductDTO updateProductDTO, Long id) throws Exception {
        var productData = productRepository.findProductByProductId(id);

        if (productData != null) {
            productData.setProductCondition(updateProductDTO.getCondition());
            productData.setSold(updateProductDTO.getSold());
            productData.setPrice(updateProductDTO.getPrice());
            productData.setLocation(updateProductDTO.getLocation());
            productData.setProductDescription(updateProductDTO.getDescription());

            productRepository.save(productData);
        } else {
            throw new Exception("Product does not exist");
        }
    }

    @Override
    public List<Product> getProductsByUserId(Long userId) {
        System.out.println("LOG:\n" + productRepository.findProductsByUserId(userId) + "\n");
        return productRepository.findProductsByUserId(userId);
    }
}
