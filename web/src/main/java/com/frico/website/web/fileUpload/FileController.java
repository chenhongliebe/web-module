package com.frico.website.web.fileUpload;

import com.frico.website.common.Result;
import com.frico.website.common.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("bc/fileUpload")
public class FileController {

    /**
     * 上传资料文件
     * @param request
     * @param response
     */
    @RequestMapping("saveFile")
    public Result saveFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = multipartRequest.getFiles("file");
        if (files == null || files.isEmpty()) {
            log.error("上传文件数为空------");
            throw new MyException("上传文件数为空");
        }
        String fileName = null;
        List list = new LinkedList();
        for (MultipartFile m : files) {
            fileName = m.getOriginalFilename();
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            //限制文件类型
            String fileType ="doc,docx,pdf,xls,xlsx,png,jpeg,jpg,gif,zip,rar";
            if(!Arrays.asList(fileType.split(",")).contains(fileExt)){
                throw new MyException("文件类型上传错误!");
            }
            //限制文件大小最大50M
            int maxSize = 1024*1024*50;
            if(m.getSize()>maxSize){
                throw new MyException("文件大小超过限制，应小于"+maxSize/1024/1024+"M!");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String url = sdf.format(new Date());
//            String url = OrderIdGenerateUtil.getOrderId(NoEnum.FILENO.getIntNo());
            String urls = url + "." + fileExt;
            InputStream inStream = new ByteArrayInputStream(m.getBytes());
            Long length = (long) m.getBytes().length;
            urls ="files/"+urls;
            File uploadFile = new File(urls);
            FileCopyUtils.copy(m.getBytes(), uploadFile);
            list.add(urls);
            list.add(fileName);
        }
        return Result.success(list);
    }
}
