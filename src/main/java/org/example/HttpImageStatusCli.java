package org.example;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter HTTP status code\t");

        while (!scanner.hasNextInt()) {
            System.out.println("Please enter valid number");
            scanner.next();
        }

        int code = scanner.nextInt();
        try {
            URI uri = new URI("https", "http.cat", "/" + code, null);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == 200) {
                HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
                downloader.downloadStatusImage(code);
            } else {
                System.out.println("There is not image for HTTP status" + code);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     }

}
