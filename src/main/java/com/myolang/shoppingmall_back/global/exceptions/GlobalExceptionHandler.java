package com.myolang.shoppingmall_back.global.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(HttpMessageNotReadableException.class)
  ResponseEntity convertError(HttpMessageNotReadableException e){
    log.error(e.getMessage());
    return ResponseEntity.badRequest().body("올바르지 않은 데이터 형식");
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  ResponseEntity notRequestMethodSupport(HttpRequestMethodNotSupportedException e){
    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("잘못된 Http Method 요청");
  }
}
