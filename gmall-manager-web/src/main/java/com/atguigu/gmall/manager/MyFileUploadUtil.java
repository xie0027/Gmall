package com.atguigu.gmall.manager;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;


public class MyFileUploadUtil {

    private MyFileUploadUtil() {
    }

    public static String uploadImg(MultipartFile file) {

        String path = GmallManagerWebApplication.class.getClassLoader().getResource("tracker.conf").getPath();

        try {
            ClientGlobal.init(path);
            TrackerServer trackerServer = new TrackerClient().getConnection();
            StorageClient storageClient = new StorageClient(trackerServer, null);
            String originalFilename = file.getOriginalFilename();
            int index = originalFilename.lastIndexOf('.');
            String extName = originalFilename.substring(index + 1).toLowerCase();
            String[] upload_file = storageClient.upload_file(file.getBytes(), extName, null);

            StringBuilder url = new StringBuilder("http://192.168.10.128");

            for (String filename : upload_file) {

                url.append("/");
                url.append(filename);
            }

            return url.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
