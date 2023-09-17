package com.go2geda.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@AllArgsConstructor
@Document
public class DriverLicence {
 @Id
 private String id;
 private MultipartFile frontPicture;
 private MultipartFile backPicture;
}
