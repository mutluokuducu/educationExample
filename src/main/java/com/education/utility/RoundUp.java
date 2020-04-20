package com.education.utility;

public class RoundUp {
    static public Double roundUpTwo(Double value) {

        Double scale = Math.pow(10, 2);

        return Math.round(value * scale) / scale;


        //return (double) (Math.round(value) * 100.0 / 100.0);

    }

}
