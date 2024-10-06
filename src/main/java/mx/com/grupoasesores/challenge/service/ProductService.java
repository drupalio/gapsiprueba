package mx.com.grupoasesores.challenge.service;

import mx.com.grupoasesores.challenge.model.product.CreateProductRequest;
import mx.com.grupoasesores.challenge.model.product.CreateProductResponse;
import mx.com.grupoasesores.challenge.repository.ProductRepository;
import mx.com.grupoasesores.challenge.repository.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public CreateProductResponse createProduct(CreateProductRequest product) {
        return getCreateProductResponse(product);
    }



    public Optional<ProductEntity> getProductById(String id) {
        return productRepository.findById(id);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity updateProduct(String id, String description, String model) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            ProductEntity existingProduct = optionalProduct.get();
            existingProduct.setDescription(description);
            existingProduct.setModel(model);
            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product with ID " + id + " not found");
        }
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }


    private CreateProductResponse getCreateProductResponse(CreateProductRequest product) {
        ProductEntity entity = new ProductEntity();
        CreateProductResponse response = new CreateProductResponse();
        entity.setDescription(product.getDescription());
        entity.setModel(product.getModel());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());


        ProductEntity entityResponse= productRepository.save(entity);
        response.setDescription(entityResponse.getDescription());
        response.setId(entityResponse.getId());
        response.setName(entityResponse.getName());
        response.setModel(entityResponse.getModel());
        response.setPrice(entityResponse.getPrice());
        return response;
    }
}