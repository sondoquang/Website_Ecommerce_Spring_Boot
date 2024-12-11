package com.stlang.dreamshops.service.image;

import com.stlang.dreamshops.dto.ImageDto;
import com.stlang.dreamshops.model.Image;
import com.stlang.dreamshops.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImage(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file, Long imageId);
}
