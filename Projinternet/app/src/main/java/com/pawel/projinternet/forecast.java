package com.pawel.projinternet;

/**
 * Created by uczen on 2017-10-07.
 */

public class forecast {
    private String city;
    private String date;
    private String desc;
    private Double temp;
    private String icon;

    public forecast(String city, String date, String desc, Double temp, String icon){
        this.setCity(city);
        this.setDate(date);
        this.setDesc(desc);
        this.setTemp(temp);
        this.setIcon(icon);
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
