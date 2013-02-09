package com.mk.camel.converter;

import com.mk.camel.entity.Trade;
import org.apache.camel.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 2/8/13
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Converter
public class TradeConverter {

    @Converter
    public static Trade convertToTrade(Trade t){
        return t;
    }
}
