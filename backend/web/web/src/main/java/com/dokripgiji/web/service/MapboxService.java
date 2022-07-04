package com.dokripgiji.web.service;

import com.dokripgiji.web.controller.dto.AddressRequestDto;
import com.dokripgiji.web.domain.user.User;
import com.google.gson.JsonArray;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MapboxService {

    public JSONArray MapboxFilter(AddressRequestDto requestDto) {

        String MapboxURL = "https://api.mapbox.com/isochrone/v1";
        String profile = "/mapbox/walking";
        String coordinate = "/" + requestDto.getLongitude() + "," + requestDto.getLatitude();
        String contours_minutes = "?contours_minutes=" + requestDto.getN();
        String token = "pk.eyJ1IjoicWtycWh0amQwODA2IiwiYSI6ImNsNHIyb256ajBkbGszam56bHVvNXAweDUifQ.suija2RERsOY9SwDGjdk8A";

        String apiURL = MapboxURL + profile + coordinate + contours_minutes + "&access_token=" + token;

        System.out.println(apiURL);

        JSONArray coordinates = null;
        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            JSONObject jObject = new JSONObject(response.toString());

            JSONObject features = (JSONObject) jObject.getJSONArray("features").get(0);
            JSONObject geometry = features.getJSONObject("geometry");
//            System.out.println("geometry = " + geometry);
            coordinates = geometry.getJSONArray("coordinates");

        } catch (Exception e) {
            System.out.println(e);
        }
        return coordinates;
    }

}
