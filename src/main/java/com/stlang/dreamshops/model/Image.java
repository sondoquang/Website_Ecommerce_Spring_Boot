package com.stlang.dreamshops.model;

import jakarta.persistence.*;
import java.sql.Blob;


@Entity
@Table (name ="Images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name="fullName", columnDefinition = "varchar(255)")
    private String fileName;
    @Column (name="fullType", columnDefinition = "varchar(255)")
    private String fileType;
    @Lob
    @Column (name = "image")
    private Blob image;
    @Column (name="downloadUrl", columnDefinition = "varchar(255)")
    private String downloadUrl;
    @ManyToOne
    @JoinColumn (name ="productId")
    private Product product;

    public Image(String fileName, String fileType, Blob image, String downloadUrl, Product product) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.image = image;
        this.downloadUrl = downloadUrl;
        this.product = product;
    }
    public Image() {};

    public Image(Long id, String fileName, String fileType, Blob image, String downloadUrl, Product product) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.image = image;
        this.downloadUrl = downloadUrl;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
