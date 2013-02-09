package com.mk.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import javax.jms.ObjectMessage;

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 2/9/13
 * Time: 1:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class TradeProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Message message = exchange.getIn();
        Object body = message.getBody();
        System.out.println("BODY:" + body);
    }
}
