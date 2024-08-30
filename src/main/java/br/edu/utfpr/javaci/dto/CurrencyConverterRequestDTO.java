package br.edu.utfpr.javaci.dto;

import br.edu.utfpr.javaci.enumerations.Currency;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CurrencyConverterRequestDTO(BigDecimal value, Currency source, Currency target) {}
