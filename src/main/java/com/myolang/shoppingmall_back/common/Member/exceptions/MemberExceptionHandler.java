package com.myolang.shoppingmall_back.common.Member.exceptions;

import com.myolang.shoppingmall_back.global.validate.ValidErrorObj;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = {"com.myolang.shoppingmall_back.Member"})
@RequiredArgsConstructor
@Slf4j
public class MemberExceptionHandler {

  private final ValidErrorObj validErrorObj;

  @ExceptionHandler(DataIntegrityViolationException.class)
  ResponseEntity dataIntegrity(DataIntegrityViolationException e){
    // Log
    log.error(e.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("버그 리포트를 남겨주시기 바랍니다.");
  }


  @ExceptionHandler(HttpMessageNotReadableException.class)
  ResponseEntity requiredRequestBodyError(HttpMessageNotReadableException e){
    log.warn(e.getMessage());
    return ResponseEntity.badRequest().body("값이 형식에 맞게 전달되지 않았습니다.");
  }

  @ExceptionHandler(DeveloperException.class)
  ResponseEntity developerError(DeveloperException e){
    log.error(e.errorCode.getMessage());
    return e.createResEntity();
  }


}
