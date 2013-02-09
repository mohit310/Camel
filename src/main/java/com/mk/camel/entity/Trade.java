package com.mk.camel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 2/8/13
 * Time: 11:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "Trade")
@XmlType
@XmlRootElement(name = "Trade")
@XmlAccessorType(XmlAccessType.FIELD)
public class Trade implements Serializable {

    private Long id;
    private Date tradeDate;
    private Date settlementDate;
    private Double quantity;
    private Double price;

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", tradeDate=" + tradeDate +
                ", settlementDate=" + settlementDate +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trade)) return false;

        Trade trade = (Trade) o;

        if (!id.equals(trade.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
