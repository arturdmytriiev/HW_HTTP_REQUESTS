package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

public class Launcher {
    public static void main(String[] args)  {
        HttpStatusCheker httpStatusCheker = new HttpStatusCheker();
        /*System.out.println(httpStatusCheker.getStatusImage(404));*/
        /*HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        httpStatusImageDownloader.downloadStatusImage(200);*/
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();
    }
}
