package com.mk.camel;

import com.mk.camel.service.TradeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 2/8/13
 * Time: 10:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrintData {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("db-context.xml");
        TradeService service = (TradeService)applicationContext.getBean("tradeService");
        try {
            service.displayTrade();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
