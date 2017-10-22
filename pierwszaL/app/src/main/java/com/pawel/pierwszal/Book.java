package com.pawel.pierwszal;

/**
 * Created by uczen on 2017-10-01.
 */

public class Book  {


    private String title;
    private String desc;

    public Book(String title, String desc){
        this.setTitle(title);
        this.setDesc(desc);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
