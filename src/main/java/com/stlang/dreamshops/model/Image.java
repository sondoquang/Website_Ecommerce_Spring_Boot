package com.stlang.dreamshops.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="Images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name ="fileName")
    private String fileName;
    @Column (name ="fileType")
    private String fileType;
    @Lob
    @Column (name ="image")
    private Blob image;
    @Column (name ="downloadUrl")
    private String downloadUrl;
    @ManyToOne
    @JoinColumn (name ="productId")
    private Product product;
}
