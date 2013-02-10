package com.mk.camel.processor;

import com.mk.camel.entity.Trade;
import com.mk.camel.proto.Camelexample;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import javax.jms.ObjectMessage;
import java.util.Date;

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
        Camelexample.Trade trade = (Camelexample.Trade)message.getBody();
        Trade t = new Trade();
        t.setId(trade.getId());
        t.setPrice(trade.getPrice());
        t.setQuantity(trade.getQuantity());
        t.setTradeDate(new Date(trade.getTradedate()));
        t.setSettlementDate(new Date(trade.getSettlementdate()));
        Message out = exchange.getOut();
        out.setBody(t);

    }
}
