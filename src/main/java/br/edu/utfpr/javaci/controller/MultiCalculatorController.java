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
}

