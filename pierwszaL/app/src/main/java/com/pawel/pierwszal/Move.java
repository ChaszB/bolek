package com.pawel.pierwszal;

/**
 * Created by uczen on 2017-09-24.
 */

public class Move {

    private String tit;
    private int leng;

    public Move(String tit, int leng){
        this.setTit(tit);
        this.setLeng(leng);
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public int getLeng() {
        return leng;
    }

    public void setLeng(int leng) {
        this.leng = leng;
    }
}
