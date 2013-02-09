package com.mk.camel.processor;

import com.mk.camel.entity.Trade;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.file.FileComponent;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 2/9/13
 * Time: 1:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class TradesProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Trade trade = exchange.getIn().getBody(Trade.class);
        System.out.println(trade);


    }

}
