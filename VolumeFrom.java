package sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import static sample.BTC.readFromAPI;
import static sample.BTC.readFromAPIDay;
import static sample.BTC.readFromAPIHour;

public class VolumeFrom {

    double vfrom;


    public void getVfrom(){
        try {
            String from_api = readFromAPI();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.vfrom = item_as_hashmap.get("volumefrom").getAsDouble();
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }

    public void getVfromHour(){
        try {
            String from_api = readFromAPIHour();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.vfrom = item_as_hashmap.get("volumefrom").getAsDouble();
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }


    public void getVfromDay(){
        try {
            String from_api = readFromAPIDay();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.vfrom = item_as_hashmap.get("volumefrom").getAsDouble();
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }

}

