package com.mk.camel;

import com.mk.camel.proto.Camelexample.Trade;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 2/9/13
 * Time: 1:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class SendProtoMessage {

    private static final Logger log = LoggerFactory.getLogger(SendProtoMessage.class);
    // URL of the JMS server. DEFAULT_BROKER_URL will just mean
    // that JMS server is on localhost
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    // Name of the queue we will be sending messages to
    private static String queuename = "com.mk.camel.proto.queue";

    public static void main(String[] args) {
        SendProtoMessage message = new SendProtoMessage();
        message.send();
    }

    private void send() {
        // Getting JMS connection from the server and starting it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // JMS messages are sent and received using a Session. We will
            // create here a non-transactional session object. If you want
            // to use transactions you should set the first parameter to 'true'
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);


            Destination destination = session.createQueue(queuename);

            // MessageProducer is used for sending messages (as opposed
            // to MessageConsumer which is used for receiving them)
            MessageProducer producer = session.createProducer(destination);

            for (int i = 0; i < 10000; i++) {
                Trade trade = Trade.newBuilder().setId(getRandomId())
                        .setPrice(100d)
                        .setQuantity(100d)
                        .setTradedate(System.currentTimeMillis())
                        .setSettlementdate(System.currentTimeMillis())
                        .build();

                byte[] messageBytes = trade.toByteArray();

                BytesMessage message = session.createBytesMessage();
                message.writeBytes(messageBytes);

                // Here we are sending the message!
                producer.send(message);
                System.out.println("Sent message '" + trade + "'");
            }
            connection.close();
        } catch (JMSException e) {
            log.error("Error in sending message", e);
        }
    }

    private Long getRandomId() {
        Random generator = new Random();
        return Math.abs(generator.nextLong());
    }
}
