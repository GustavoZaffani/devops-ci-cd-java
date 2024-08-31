package br.edu.utfpr.javaci.controller;

import br.edu.utfpr.javaci.dto.CurrencyConverterRequestDTO;
import br.edu.utfpr.javaci.enumerations.Currency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
class MultiCalculatorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest(
            name = "[{index}] when call currencyConverter with request {0}, the result must be equal {1}")
    @MethodSource("provideValuesConverter")
    void testCurrencyConverter(CurrencyConverterRequestDTO request, BigDecimal result) throws Exception {
        mockMvc.perform(post("/api/calculator/currency/v2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(request)))
                .andExpect(status().isOk())
                .andExpect(content().string(notNullValue()))
                .andExpect(jsonPath("$.convertedValue").value(result));
    }

    private static Stream<Arguments> provideValuesConverter() {
        return Stream.of(
                Arguments.of(CurrencyConverterRequestDTO.builder()
                                .source(Currency.REAL)
                                .target(Currency.DOLLAR)
                                .value(new BigDecimal("5.0"))
                                .build(),
                        BigDecimal.valueOf(1.0)),
                Arguments.of(CurrencyConverterRequestDTO.builder()
                                .source(Currency.DOLLAR)
                                .target(Currency.REAL)
                                .value(new BigDecimal("5.0"))
                                .build(),
                        BigDecimal.valueOf(25.0)),
                Arguments.of(CurrencyConverterRequestDTO.builder()
                                .source(Currency.EURO)
                                .target(Currency.REAL)
                                .value(new BigDecimal("1500.0"))
                                .build(),
                        BigDecimal.valueOf(9000.0)),
                Arguments.of(CurrencyConverterRequestDTO.builder()
                                .source(Currency.REAL)
                                .target(Currency.EURO)
                                .value(new BigDecimal("17.0"))
                                .build(),
                        BigDecimal.valueOf(2.83)),
                Arguments.of(CurrencyConverterRequestDTO.builder()
                                .source(Currency.DOLLAR)
                                .target(Currency.EURO)
                                .value(new BigDecimal("15.0"))
                                .build(),
                        BigDecimal.valueOf(12.5))
        );
    }

    public String toJson(final Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
