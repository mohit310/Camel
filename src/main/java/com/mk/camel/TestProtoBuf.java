package com.mk.camel;


import com.mk.camel.proto.Camelexample.Trade;

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 2/10/13
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestProtoBuf {
    public static void main(String[] args) {
        Trade t = Trade.newBuilder().setId(1)
                            .setPrice(100)
                            .setQuantity(100).build();
        System.out.println(t);
    }
}
