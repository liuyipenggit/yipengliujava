package com.yipeng.liu.testwork.minio;

import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.Item;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yipeng
 * @version V1.0
 * @Package com.yipeng.liu.testwork.minio
 * @date 2022/5/18 21:18
 * @Copyright 韵达快递
 */
public class MinioClientUpload {

    public static void main(String[] args) throws Exception {
        MinioClient build = MinioClient.builder()
                .endpoint("http://u-oss.yundasys.com:19888/")
                .credentials("promotioncenter", "promotioncenter123").build();

        List<Bucket> buckets = build.listBuckets();
        buckets.stream().forEach(b -> {
            System.out.println(b.name());
        });

        System.out.println("==============================");

        Iterable<Result<Item>> objects = build.listObjects(
                ListObjectsArgs.builder().bucket("promotion-center").build());
        objects.forEach(o -> {
            try {
                System.out.println(o.get().objectName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("==============================");

//        build.uploadObject(
//                UploadObjectArgs.builder()
//                        .object("picture/")
//                        .bucket("promotion-center")
//                        .filename("C:/Users/LYP/Desktop/1.png")
//                        .build());
        String url = build.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket("promotion-center")
                        .object("picture/202205/20220504153755616.jpg")
                        .expiry(2, TimeUnit.HOURS)
                        .build()
        );
        System.out.println(url);

    }

}
