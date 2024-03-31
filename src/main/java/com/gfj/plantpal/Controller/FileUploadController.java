package com.gfj.plantpal.Controller;

import com.gfj.plantpal.Pojo.Result;
import com.gfj.plantpal.Util.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        //存储文件内容到本地磁盘
        String originalFilename = file.getOriginalFilename();
        //为了保证文件名唯一，防止同名文件覆盖，使用UUID
        String fileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //file.transferTo(new File("/Users/gefangjie/Desktop/Pic/"+fileName));
        String url = AliOssUtil.uploadFile(fileName, file.getInputStream());
        return Result.success(url);
    }
}
