package com.is.phonestore.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public interface ImageService {

    String addImage(MultipartFile file) throws IOException;

}
