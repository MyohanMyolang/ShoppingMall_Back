package com.myolang.shoppingmall_back.Auth.exceptions;


import com.myolang.shoppingmall_back.global.exceptions.AlreadyHasDataException;
import com.myolang.shoppingmall_back.global.validate.ValidErrorObj;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestControllerAdvice(basePackages = {"com.myolang.shoppingmall_back.Auth"})
public class AuthExceptionHandler {


  @ExceptionHandler(DataIntegrityViolationException.class)
  ResponseEntity dataIntegrity(DataIntegrityViolationException e){
    return ResponseEntity.badRequest().body("잘못된 Query 또는 Data 입니다.");
  }

  @ExceptionHandler(AlreadyHasDataException.class)
  ResponseEntity alreadyHasData(AlreadyHasDataException e){
    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
  }

  @ExceptionHandler(NotFoundUser.class)
  ResponseEntity notFoundUser(NotFoundUser e){ return ResponseEntity.badRequest().body(e.getMessage());}
}
