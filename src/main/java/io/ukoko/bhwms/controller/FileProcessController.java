package io.ukoko.bhwms.controller;

import io.swagger.annotations.Api;
import io.ukoko.bhwms.dto.Result;
import io.ukoko.bhwms.enums.BhWmsStatus;
import io.ukoko.bhwms.exceptions.BhWmsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件处理控制器
 */
@Api(tags = "文件处理模块")
@CrossOrigin
@RestController
public class FileProcessController {
    /**
     * 文件上传
     */
    @PostMapping(value = "/uploadFile")
    public Object uploadFile(@RequestPart("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //获取文件名称
        String filename = file.getOriginalFilename();
        //判断文件是否存在
        if(filename==null || filename.length()==0){
            throw new BhWmsException(BhWmsStatus.FILE_ERROR);
        }else {
            //获取项目的跟路径
            String realPath = request.getServletContext().getRealPath("/");
            System.out.println("真是路径:"+realPath);

            //处理文件格式
            String type = filename.substring(filename.lastIndexOf("."),filename.length());

            //生成新的文件名称
            filename = UUID.randomUUID()+type;

            //图片地址
            String picUrl="/pics";
            //文件地址
            String fileUrl="files";
            //创建文件保存位置(根据文件类型创建不同的文件夹保存文件)
            if(type.contains(".png") || type.contains(".jpeg") || type.contains(".jpg")|| type.contains(".gif")){
                String picUrl$=realPath+picUrl;
                //判断地址是否存在,如果不存在就创建
                File picF = new File(picUrl$);
                if(!picF.exists()){
                    picF.mkdirs();
                }
                //文件保存
                file.transferTo(new File(picF+"/"+filename));
                return new Result(picUrl+"/"+filename);
            }else if(type.contains(".pdf") || type.contains(".xlsx") || type.contains(".docx") || type.contains(".doc")){
                String fileUrl$=realPath+fileUrl;
                //判断地址是否存在,如果不存在就创建
                File fileF = new File(fileUrl$);
                if(!fileF.exists()){
                    fileF.mkdirs();
                }
                //文件保存
                file.transferTo(new File(fileF+"/"+filename));
                return new Result(fileUrl+"/"+filename);
            }else {
                throw new BhWmsException(BhWmsStatus.FILE_STYLE_ERROR);
            }
        }
    }

    /**
     * 文件删除
     */

}
