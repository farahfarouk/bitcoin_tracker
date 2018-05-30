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

public class Low {

    double lowprice;

    public void getLow(){
        try {
            String from_api = readFromAPI();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.lowprice = item_as_hashmap.get("low").getAsDouble();
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }

    public void getLowHour(){
        try {
            String from_api = readFromAPIHour();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.lowprice = item_as_hashmap.get("low").getAsDouble();
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }

    public void getLowDay(){
        try {
            String from_api = readFromAPIDay();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.lowprice = item_as_hashmap.get("low").getAsDouble();
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
}

