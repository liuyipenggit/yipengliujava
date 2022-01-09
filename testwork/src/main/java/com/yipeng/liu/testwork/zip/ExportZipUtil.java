package com.yipeng.liu.testwork.zip;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩文件位zip工具类
 *
 * @author lyp
 * @version V1.0
 * @Package com.yundasys.promotioncenter.common.util
 * @date 2021/9/5 12:48
 * @Copyright 韵达快递
 */
public class ExportZipUtil {

    /**
     * 压缩列表文件为zip
     *
     * @param fileNameList 文件列表
     * @param fileUrl      文件路径
     * @return: void
     * @authror: yipeng
     * @date 2021/9/5 14:01
     * @version 1.0
     */
    public static void zipList(List<String> fileNameList, String fileUrl) throws IOException {

        FileOutputStream fos = null;
        ZipOutputStream zipOut = null;
        try {
            fos = new FileOutputStream(fileUrl);
            zipOut = new ZipOutputStream(fos);

            for (String fileName : fileNameList) {

                File fileToZip = new File(fileName);
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(fileToZip);

                    ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                    zipOut.putNextEntry(zipEntry);

                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = fis.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }
                } catch (FileNotFoundException e) {

                } finally {
                    if (fis != null) {
                        fis.close();
                    }
                }
                fileToZip.delete();
            }
        } catch (FileNotFoundException e) {

        } finally {
            if (zipOut != null) {
                zipOut.close();
            }
            if (fos != null) {
                fos.close();
            }
        }

    }

}
