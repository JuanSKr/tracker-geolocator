package com.geospotter.functionality;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeoIp {

    public void ipAdress(String ip, TextArea txtArea) {
        try {
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

            txtArea.setText(
                    "---------------------------" + "\n" +
                            "IP: " + ip + "\n" +
                            "Country: " + countryName + "\n" +
                            "City: " + cityName + "\n" +
                            "Latitude: " + latitude + "\n" +
                            "Longitude: " + longitude + "\n" +
                            "---------------------------");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeoIp2Exception geoip) {
            txtArea.setText("IP Adress not found.");
        } catch (RuntimeException re) {
            txtArea.setText("An error has been ocurred. Try again later.");
        }
    }

    public boolean checkIp(String ip) {
        String ipv4Pattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        Pattern pattern = Pattern.compile(ipv4Pattern);

        Matcher matcher = pattern.matcher(ip);

        return matcher.matches();

    }

    public void getIp(String domain, TextArea txtArea) {
        try {
            URL url = new URL("http://" + domain);
            String ip = InetAddress.getByName(url.getHost()).getHostAddress();
            txtArea.setText(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


