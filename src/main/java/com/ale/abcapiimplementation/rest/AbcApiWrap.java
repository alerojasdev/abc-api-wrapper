package com.ale.abcapiimplementation.rest;

import com.ale.abcapiimplementation.entity.AbcInformationContent;
import com.ale.abcapiimplementation.entity.NewsMetaData;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class AbcApiWrap {
    public List<NewsMetaData> getAbcNewsData(String requestText) throws URISyntaxException, IOException, InterruptedException {
        String urlHttp = "https://api.queryly.com/v4/search.aspx?queryly_key=33530b56c6aa4c20&initialized=1&&query="+requestText +"&endindex=0&batchsize=10&callback=&extendeddatafields=creator,imageresizer,promo_image&timezoneoffset=240";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest httpClient = HttpRequest.newBuilder()
                    .uri(new URI(urlHttp))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(httpClient, HttpResponse.BodyHandlers.ofString());

            String body = response.body();

            if (body.contains("items")){
                int indexStart = body.indexOf("items");
                int indexEnd = body.indexOf("relatedtags")-3;
                String json = body.substring(indexStart+7, indexEnd);

                ObjectMapper obm = new ObjectMapper();
                obm.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
                obm.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);

                AbcInformationContent[] infoContent = obm.readValue(json, AbcInformationContent[].class);

                List<NewsMetaData> newsMetaData = new ArrayList<>();

                for (AbcInformationContent abcInformationContent : infoContent){
                    newsMetaData.add(new NewsMetaData(abcInformationContent.getPubdate(), abcInformationContent.getLink(), abcInformationContent.getPromo_image(), abcInformationContent.getTitle(), abcInformationContent.getDescription()) );
                }

                return newsMetaData;

            } else {
                return null;
            }
    }
}
