package mx.com.grupoasesores.challenge.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import mx.com.grupoasesores.challenge.model.product.CreateProductRequest;
import mx.com.grupoasesores.challenge.model.product.CreateProductResponse;
import mx.com.grupoasesores.challenge.model.product.UpdateProductRequest;
import mx.com.grupoasesores.challenge.repository.entities.ProductEntity;
import mx.com.grupoasesores.challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create a product", description = "This endpoint creates a new product or article")
    @ApiResponse(responseCode = "200", description = "Create a new Product",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseEntity.class)))
    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest product) {
        CreateProductResponse newProduct = productService.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @Operation(summary = "get product by identifier", description = "retrieves the information of a product by the identifier")
    @ApiResponse(responseCode = "200", description = "product information retrieved successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseEntity.class)))
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable String id) {
        Optional<ProductEntity> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Get all products", description = "List all the products on the database")
    @ApiResponse(responseCode = "200", description = "list all ",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseEntity.class)))
    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Operation(summary = "Update a product", description = "Update  a product by id")
    @ApiResponse(responseCode = "200", description = "product was  updated successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseEntity.class)))
    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable String id,
                                                       @RequestBody UpdateProductRequest updateRequest) {
        try {
            ProductEntity updatedProduct = productService.updateProduct(id, updateRequest.getDescription(), updateRequest.getModel());
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete product", description = "Delete a product by id")
    @ApiResponse(responseCode = "200", description = "the product was deleted",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseEntity.class)))
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}