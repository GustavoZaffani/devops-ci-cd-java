package br.edu.utfpr.javaci.controller;

import br.edu.utfpr.javaci.dto.CurrencyConverterRequestDTO;
import br.edu.utfpr.javaci.service.CurrencyConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calculator")
public class MultiCalculatorController {

    private final CurrencyConverterService currencyConverterService;

    @PostMapping("/currency")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> currencyConverter(@RequestBody CurrencyConverterRequestDTO request) {
        return currencyConverterService.convert(request);
    }

    @PostMapping("/currency/v2")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> currencyConverterV2(@RequestBody CurrencyConverterRequestDTO request) {
        return currencyConverterService.convert(request);
    }

    @PostMapping("/currency/v3")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> currencyConverterV3(@RequestBody CurrencyConverterRequestDTO request) {
        return currencyConverterService.convert(request);
    }

    @PostMapping("/currency/v4")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> currencyConverterV4(@RequestBody CurrencyConverterRequestDTO request) {
        return currencyConverterService.convert(request);
    }
}

