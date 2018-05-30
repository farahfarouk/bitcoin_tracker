package sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class BTC {

    double price;

    double time;

    private static String urlMinute = "https://min-api.cryptocompare.com/data/histominute?aggregate=0&e=CCCAGG&extraParams=CryptoCompare&fsym=BTC&limit=100&tryConversion=false&tsym=USD";

    private static String urlDay ="https://min-api.cryptocompare.com/data/histoday?aggregate=0&e=CCCAGG&extraParams=CryptoCompare&fsym=BTC&limit=100&tryConversion=false&tsym=USD";

    private static String urlHour ="https://min-api.cryptocompare.com/data/histohour?aggregate=0&e=CCCAGG&extraParams=CryptoCompare&fsym=BTC&limit=100&tryConversion=false&tsym=USD";

    public static String readFromAPI(){
        String contents = "";
        try {
            URL address = new URL(urlMinute);
            InputStreamReader reader = new InputStreamReader(address.openStream());
            BufferedReader buffer = new BufferedReader(reader);

            String line = "";
            while ((line = buffer.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                contents += line;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return contents;
    }

    public static String readFromAPIDay(){
        String contents = "";
        try {
            URL address = new URL(urlDay);
            InputStreamReader reader = new InputStreamReader(address.openStream());
            BufferedReader buffer = new BufferedReader(reader);

            String line = "";
            while ((line = buffer.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                contents += line;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return contents;
    }

    public static String readFromAPIHour(){
        String contents = "";
        try {
            URL address = new URL(urlHour);
            InputStreamReader reader = new InputStreamReader(address.openStream());
            BufferedReader buffer = new BufferedReader(reader);

            String line = "";
            while ((line = buffer.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                contents += line;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return contents;
    }

    public void getCurrencyDay(){
        try {
            String from_api = readFromAPIDay();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.price = item_as_hashmap.get("close").getAsDouble();
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }

    public void getCurrencyHour(){
        try {
            String from_api = readFromAPIHour();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.price = item_as_hashmap.get("close").getAsDouble();
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }

    public void getCurrency(){
        try {
            String from_api = readFromAPI();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.price = item_as_hashmap.get("close").getAsDouble();
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
    public void getTimeMin(){
        try {
            String from_api = readFromAPI();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.time=(item_as_hashmap.get("time").getAsDouble());
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }

    }

    public void getTimeHour(){
        try {
            String from_api = readFromAPIHour();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.time=(item_as_hashmap.get("time").getAsDouble());
            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }

    public void getTimeDay(){
        try {
            String from_api = readFromAPIDay();
            Gson gson = new Gson();

            JsonObject response = gson.fromJson(from_api, JsonObject.class);
            JsonArray data = response.getAsJsonArray("Data");

            for(JsonElement item : data ){
                JsonObject item_as_hashmap = item.getAsJsonObject();
                this.time=(item_as_hashmap.get("time").getAsDouble());

            }

        }catch(Exception exc){
            exc.printStackTrace();
        }
    }


}

