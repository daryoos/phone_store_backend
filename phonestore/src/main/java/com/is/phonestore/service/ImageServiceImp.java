package com.is.phonestore.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ImageServiceImp implements ImageService {
    @Override
    public String addImage(MultipartFile file) throws IOException {
        var container = new BlobContainerClientBuilder().connectionString("DefaultEndpointsProtocol=https;AccountName=phonestorageurl;AccountKey=tCVaXDafKCnq+i54n5a1dUbZT1oDx0+auLB36v7gQmRkV2yL87lpAo3VWwcEz7X2A2TMjVke/riX+AStHheIow==;EndpointSuffix=core.windows.net")
                .containerName("photosproducts")
                .buildClient();

        var fileUuuid = UUID.randomUUID();
        BlobClient blobClient = container.getBlobClient(fileUuuid.toString());
       blobClient.upload(file.getInputStream(),file.getSize(),true);
       return  blobClient.getBlobUrl();



    }
}
