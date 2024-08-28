package br.edu.utfpr.javaci.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class ApiTestController {

    @GetMapping
    public String test() {
        return "Teste de API. Porque nao atualiza???????";
    }
}