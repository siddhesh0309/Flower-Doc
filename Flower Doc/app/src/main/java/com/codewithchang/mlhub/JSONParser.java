package com.codewithchang.mlhub;

import android.os.Handler;
import android.os.Looper;

import com.codewithchang.mlhub.bottomActivities.DetectActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONParser {

    private static String code;
    private static String desc;
    private static String temp;
    private static DetectActivity activity;



    public static void Parser(JSONObject jo) {


       if (jo == null) {
            throw new NullPointerException("Null JSONObject");
        }

        try {

            JSONObject jobj = new JSONObject(jo.toString());


            JSONObject main = jobj.getJSONObject("main");
            temp = main.getString("temp");

            temp = getTempFahr(temp);

            final JSONArray weather = jobj.getJSONArray("weather");

            for (int i = 0; i < weather.length(); i++) {
                JSONObject obj = weather.getJSONObject(i);
                code = obj.getString("id");
                desc = obj.getString("description");
            }


            Handler mainHandler = new Handler(Looper.getMainLooper());

            Runnable myRunnable = new Runnable() {
                @Override
                public void run() {


                    if (code == null || temp == null|| desc == null ) {
                        temp = "N/A";
                        desc = "Unable to fetch weather data at this time";
                        code = "00";

                    }


                }
            };
            mainHandler.post(myRunnable);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public static String getTempFahr(String kelvin) {
       double kelvinNum = Double.parseDouble(kelvin);
       double fahr = (kelvinNum - 273.15) * (9/5) + 32;

       //convert back to string
        Double resultFahr = Double.parseDouble(String.format("%.1f", fahr));
        return resultFahr.toString();

    }

    public static void setActivity(DetectActivity act) {
        activity = new DetectActivity();
        activity = act;
    }


}
