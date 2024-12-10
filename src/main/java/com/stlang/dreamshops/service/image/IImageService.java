package com.stlang.dreamshops.service.image;

import com.stlang.dreamshops.model.Image;
import com.stlang.dreamshops.model.Product;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    Image saveImage(MultipartFile file, Long productId);
    void updateImage(MultipartFile file, Long imageId);
}
