package com.local.i_sit_bbs.common;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description:
 * @author: chenzhongchao
 * @create: 2019-09-04
 **/
@Configuration
@SuppressWarnings("all")
public class FilesPublicUtils {

    static protected org.slf4j.Logger log=LoggerFactory.getLogger(FilesPublicUtils.class);

    /**
     * 生成目录
     *
     * @param outFilePathAndName
     * @return
     */
    public static String createPath(String outFilePathAndName) {
        File file = new File(outFilePathAndName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return outFilePathAndName;
    }

    /**
     * 上传文件
     *
     * @param file
     */
    public static String uploadFile(MultipartFile file, String filePath,String fileName) {
        if (file != null) {
            Path path = Paths.get(FilesPublicUtils.createPath(filePath + "/" + fileName));
            try {
                Files.write(path, file.getBytes());
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
            return path.toString();
        }
        return null;
    }

    public static void getPhoto(String filePath,String fileName,HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File(filePath + fileName);
        InputStream is = new FileInputStream(file);
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        is.close();

        OutputStream os = response.getOutputStream();

        response.setContentType("image/*");
        os.write(bytes);
        os.close();
    }



    /**
     * 文件下载
     *
     * @param filePath
     * @param rootFilepath
     * @param response
     */
    public void downloadFile(File rootPath, String filePath, HttpServletResponse response) {
        if (!rootPath.exists()) {
            log.error("filePath:{} not found", rootPath.getPath());
            throw new RuntimeException("文件目录未找到");
        }

        File target = new File(rootPath, filePath);
        if (!target.exists()) {
            log.error("filePath:{} not found", target.getPath());
            throw new RuntimeException("文件未找到");
        }

        BufferedInputStream inputStream;
        OutputStream outputStream = null;
        try {
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            String filename = filePath;
            if (filePath.contains("-")) {
                filename = filePath.substring(filePath.indexOf("-") + 1 < filePath.length() ? filePath.indexOf("-") + 1 : 0);
            }
            filename = URLEncoder.encode(filename, "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            byte[] b = new byte[1024];
            outputStream = response.getOutputStream();
            inputStream = new BufferedInputStream(new FileInputStream(target));
            int i = inputStream.read(b);
            while (i != -1) {
                outputStream.write(b, 0, i);
                outputStream.flush();
                i = inputStream.read(b);
            }
        } catch (IOException e) {
            log.error("download file error", e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("OutputStream close error", e);
                }
            }
        }
    }
}
