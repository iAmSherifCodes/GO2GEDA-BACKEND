package com.go2geda.user.service.cloud;

import org.springframework.web.multipart.MultipartFile;

public interface CloudService {
    String upload(MultipartFile file, String cloudinaryFolder);
}
