package com.example.uas_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //* To check if the API_KEY in the local.properties is correctly accessed or not
//        try {
//            ApplicationInfo appInfo = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
//            String apiKey = appInfo.metaData.getString("com.google.android.geo.API_KEY");
//            Log.d("API_KEY", "API Key: " + apiKey);
//        } catch (PackageManager.NameNotFoundException e) {
//            Log.e("API_KEY", "Failed to load meta-data, NameNotFound: " + e.getMessage());
//        } catch (NullPointerException e) {
//            Log.e("API_KEY", "Failed to load meta-data, NullPointer: " + e.getMessage());
//        }
    }
}