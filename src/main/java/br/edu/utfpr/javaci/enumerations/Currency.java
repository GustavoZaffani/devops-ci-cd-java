package br.edu.utfpr.javaci.enumerations;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public enum Currency {
    REAL("Real", BigDecimal.valueOf(1.0)),
    DOLLAR("Dollar", BigDecimal.valueOf(5.0)),
    EURO("Euro", BigDecimal.valueOf(6.0)),
    YEN("Yen", BigDecimal.valueOf(0.05));

    private final String name;
    private final BigDecimal value;

}
