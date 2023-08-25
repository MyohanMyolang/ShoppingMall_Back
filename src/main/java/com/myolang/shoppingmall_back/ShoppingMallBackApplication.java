package com.myolang.shoppingmall_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class ShoppingMallBackApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShoppingMallBackApplication.class, args);
  }

}
