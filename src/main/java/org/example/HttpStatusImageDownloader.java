package org.example;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    @SneakyThrows
    public void downloadStatusImage(int code) {
        HttpStatusCheker httpStatusCheker = new HttpStatusCheker();
        if(httpStatusCheker.getStatusImage(code) != null)
        {
            URL url = new URL(httpStatusCheker.getStatusImage(code));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("cat"+code+".jpg");
            byte[] buffer = new byte[4096];
            int bytesRead ;
            while( (bytesRead = inputStream.read(buffer)) != -1)
            {
                fileOutputStream.write(buffer,0 , bytesRead);
            }
            inputStream.close();
            fileOutputStream.close();
        }
        else
        {
            throw new RuntimeException("Image not found");
        }
    }
}
