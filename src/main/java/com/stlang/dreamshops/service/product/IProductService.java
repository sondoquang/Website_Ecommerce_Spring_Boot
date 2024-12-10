package com.stlang.dreamshops.service.product;

import com.stlang.dreamshops.model.Product;
import com.stlang.dreamshops.request.AddProductRequest;
import com.stlang.dreamshops.request.UpdateProductRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(UpdateProductRequest product, Long  productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategoryId(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);

}
