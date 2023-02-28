package com.wf.microservice.currencyconversionservice.controller;

import com.wf.microservice.currencyconversionservice.bean.CurrencyConversion;
import com.wf.microservice.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    private CurrencyExchangeProxy proxy ;
    private RestTemplate restTemplate;

    public CurrencyConversionController(CurrencyExchangeProxy proxy, RestTemplate restTemplate) {
        this.proxy = proxy;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-echange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

       CurrencyConversion currencyConversion =  responseEntity.getBody();

        return new CurrencyConversion(currencyConversion.getId(), currencyConversion.getFrom(), currencyConversion.getTo(), currencyConversion.getConversionMultiple(),quantity, quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvrironment() +"-rest-template");

    }


    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){



        CurrencyConversion currencyConversion =  proxy.retrieveExchangeValue(from,to);

        return new CurrencyConversion(currencyConversion.getId(), currencyConversion.getFrom(), currencyConversion.getTo(), currencyConversion.getConversionMultiple(),quantity, quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvrironment() + "-feign" );

    }
}
