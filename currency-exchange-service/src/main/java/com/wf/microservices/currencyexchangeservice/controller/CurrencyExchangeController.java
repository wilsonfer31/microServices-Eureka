package com.wf.microservices.currencyexchangeservice.controller;

import com.wf.microservices.currencyexchangeservice.beans.CurrencyExchange;
import com.wf.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Environment environment;
    private CurrencyExchangeRepository repo;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository repo) {
        this.environment = environment;
        this.repo = repo;
    }

    @GetMapping("/currency-echange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
       // CurrencyExchange currencyExhchange =  new CurrencyExchange(1000L, from , to, BigDecimal.valueOf(50));
       CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);

       if(currencyExchange == null){
           throw new RuntimeException("Unable to find data for" + from + "to" + to);
       }
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvrironment(port);

        return currencyExchange;
    }
}
