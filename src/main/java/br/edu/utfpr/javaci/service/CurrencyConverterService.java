package br.edu.utfpr.javaci.service;

import br.edu.utfpr.javaci.dto.CurrencyConverterRequestDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class CurrencyConverterService {

    private static final String FIELD = "convertedValue";

    public Map<String, Object> convert(CurrencyConverterRequestDTO request) {
        BigDecimal conversionRate = request.source().getValue()
                .divide(request.target().getValue(), 4, RoundingMode.HALF_UP);

        BigDecimal convertedValue = request.value()
                .multiply(conversionRate)
                .setScale(2, RoundingMode.HALF_UP);

        return Map.of(FIELD, convertedValue);
    }
}
