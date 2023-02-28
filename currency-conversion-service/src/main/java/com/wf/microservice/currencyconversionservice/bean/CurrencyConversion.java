package com.wf.microservice.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversion {
    private Long id;
    private String from;
    private String to;
    private BigDecimal ConversionMultiple;
    private BigDecimal totalCalculatedAmount;
    private BigDecimal quantity;
    private String envrironment;

    public CurrencyConversion() {
        super();
    }

    public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity, BigDecimal totalCalculatedAmount,String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        ConversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount =totalCalculatedAmount;
        this.envrironment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return ConversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        ConversionMultiple = conversionMultiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public String getEnvrironment() {
        return envrironment;
    }

    public void setEnvrironment(String envrironment) {
        this.envrironment = envrironment;
    }
}
