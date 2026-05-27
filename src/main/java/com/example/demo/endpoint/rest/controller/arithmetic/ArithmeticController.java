package com.example.demo.endpoint.rest.controller.arithmetic;

import com.example.demo.endpoint.service.arithmetic.ArithmeticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArithmeticController {

  private final ArithmeticService arithmeticService;

  public ArithmeticController(ArithmeticService arithmeticService) {
    this.arithmeticService = arithmeticService;
  }

  @GetMapping("/add")
  public int add(@RequestParam int a, @RequestParam int b) {
    return arithmeticService.add(a, b);
  }

  @GetMapping("/subtract")
  public int subtract(@RequestParam int a, @RequestParam int b) {
    return arithmeticService.subtract(a, b);
  }

  @GetMapping("/multiply")
  public int multiply(@RequestParam int a, @RequestParam int b) {
    return arithmeticService.multiply(a, b);
  }

  @GetMapping("/divide")
  public double divide(@RequestParam int a, @RequestParam int b) {
    return arithmeticService.divide(a, b);
  }
}
