package com.mk.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

import static org.apache.camel.language.juel.JuelExpression.el;

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 2/9/13
 * Time: 1:29 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class TradeRoute extends SpringRouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:com.mk.camel.proto.queue?acknowledgementModeName=CLIENT_ACKNOWLEDGE")
                .transacted()
                .unmarshal()
                .protobuf("com.mk.camel.proto.Camelexample$Trade")
                .processRef("tradeProcessor")
                //.to("mock:result")
                //.to("jpa:com.mk.camel.entity.Trade?flushOnSend=true")
        ;
    }
}
