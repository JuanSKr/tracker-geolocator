package com.geospotter.functionality;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GeoIp {

    public void ipAdress(TextField txtField) {
        try {
            String ip = txtField.getText();
            File db = new File("db/GeoLite2-City.mmdb");
            DatabaseReader dbReader = new DatabaseReader.Builder(db).build();

            InetAddress ipAdress = InetAddress.getByName(ip);

            CityResponse response = dbReader.city(InetAddress.getByName(ip));

            Country country = response.getCountry();
            City city = response.getCity();
            String cityName = city.getName();
            String countryName = country.getName();
            double latitude = response.getLocation().getLatitude();
            double longitude = response.getLocation().getLongitude();

            System.out.println("IP: "+ip);
            System.out.println("Country: "+countryName);
            System.out.println("City: "+cityName);
            System.out.println("Latitude: "+latitude);
            System.out.println("Longitude: "+longitude);

        } catch (IOException | GeoIp2Exception e) {
            e.printStackTrace();
        }
    }


}
