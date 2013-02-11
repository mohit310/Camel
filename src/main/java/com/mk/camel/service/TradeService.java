package com.mk.camel.service;

import com.mk.camel.entity.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 2/10/13
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Service
public class TradeService {

    private static final Logger logger = LoggerFactory.getLogger(TradeService.class);
    @Autowired
    private DataSource dataSource;

    public int insertTrade(Trade t) throws Exception {
        Connection con = dataSource.getConnection();
        PreparedStatement stat = con.prepareStatement("INSERT INTO TRADE Values(?,?,?,?,?)");
        stat.setLong(1, t.getId());
        stat.setDouble(2, t.getQuantity());
        stat.setDouble(3, t.getPrice());
        stat.setDate(4, new java.sql.Date(t.getTradeDate().getTime()));
        stat.setDate(5, new java.sql.Date(t.getSettlementDate().getTime()));
        int count = stat.executeUpdate();
        logger.debug("INSERTED RECORD:" + t.getId());
        stat.close();
        con.close();
        return count;

    }

    public void displayTrade() throws Exception {
        Connection con = dataSource.getConnection();
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery("select * from TRADE");
        int count = 0;
        while (rs.next()) {
            count++;
            logger.debug("TRADE:" + rs.getLong("ID"));
        }
        logger.debug("TOTAL COUNT:" + count);
        rs.close();
        stat.close();
        con.close();

    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
