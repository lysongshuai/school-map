package com.school.controller;


import com.alibaba.fastjson.JSON;
import com.school.util.ApiCode;
import com.school.util.ApiResult;
import com.school.util.SnowflakeIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Value("${save_file_path}")
    private String FILE_PATH;
    @Value("${search_img_path}")
    private String SEARCH_IMG_PATH;

    private static final String DOT = ".";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ApiResult uploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
        //转换报错
        //MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);

        Iterator<String> iterator = multipartRequest.getFileNames();

        MultipartFile multipartFile = multipartRequest.getFile(iterator.next());
        String fileName=multipartFile.getOriginalFilename();

        String suffix = null;
        if(!StringUtils.isEmpty(fileName)){
            //解决中文乱码
             suffix =  fileName.lastIndexOf(DOT) != -1 ? fileName.substring(fileName.lastIndexOf(DOT)) : ".jpg";
        }
        long size = multipartFile.getSize() ;
        if( size > MAX_LENGTH ){
            return ApiResult.error(ApiCode.FILE_TO_BIG) ;
        }

        String ossName = upload(multipartFile,suffix, size);
        if (ossName == null) {// 上传失败
            return ApiResult.error(ApiCode.FILE_UPLOAD_ERROR) ;
        }
        
        return ApiResult.ok("/"+ossName);
    }

    private static final int MAX_LENGTH = 10 * 1024 * 1024 ;

    private String upload(MultipartFile multipartFile,String suffix, long size){
        log.info("UUID= {}  filename={}  size= {}",UUID.randomUUID(),size);
        String pathName = null;
        try {
            pathName = save2Oss(multipartFile,suffix);
        } catch (Exception e) {
            log.error("upload  filename={}  size={}", size, e);
        }
        if (pathName == null) {// 上传失败
            return null;
        }

        log.info("UUID= {}  filename={}  size= {} 上传 result= {} ",UUID.randomUUID(),size,pathName);
        return pathName;
    }


    private String save2Oss(MultipartFile file,String suffix) throws IOException {

        String code = SnowflakeIdUtil.getSnowflakeIdUtil().nextCode();
        //String savePath = FILE_PATH + "/"+ code + suffix;
        String searchPath = SEARCH_IMG_PATH + code + suffix;
        String savePath = FILE_PATH + code + suffix;
        InputStream is = file.getInputStream();
        Long fileSize = file.getSize();
        //创建一个文件输出流
         FileOutputStream out = new FileOutputStream(savePath);
        //创建一个缓冲区
        byte buffer[] = new byte[1024];
       //判断输入流中的数据是否已经读完的标识
        int len = 0;
        //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
        while((len=is.read(buffer))>0){
           //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录当中
           out.write(buffer, 0, len);
        }
        //关闭输入流
        is.close();
        //关闭输出流
        out.close();
        return searchPath;
    }
}
