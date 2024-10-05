package org.example;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class HttpStatusCheker {
    public String getStatusImage(int code)
    {
        try {
            URI uri = new URI("https", "http.cat", "/" + code + ".jpg", null);
            URL url = uri.toURL();
            if(checkImageExist(url)== true) {
                return url.toString();
            }
            else {
                throw new RuntimeException("Image not found");
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    @SneakyThrows
    private boolean checkImageExist(URL url)
    {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK)
        {
            connection.disconnect();
            return true;
        }
        else
        {
            connection.disconnect();
            return false;
        }
    }

}
