package com.myolang.shoppingmall_back.common.Member.exceptions;

import com.myolang.shoppingmall_back.global.validate.ValidErrorObj;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice(basePackages = {"com.myolang.shoppingmall_back.common.Member"})
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

  @ExceptionHandler(NoSuchElementException.class)
  ResponseEntity noSuchElement(NoSuchElementException e){
    return ResponseEntity.internalServerError().body("지속 된다면 고객센터에 문의 바랍니다.");
  }

  @ExceptionHandler(SameBeforePwException.class)
  ResponseEntity sameBeforePw(SameBeforePwException e){
    return ResponseEntity.badRequest().body("이전 비밀번호와 일치 합니다. 다른 비밀 번호를 입력하여 주십시오.");
  }

  @ExceptionHandler(InvalidRequestException.class)
  ResponseEntity invalidReqException(InvalidRequestException e){
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(e.getMessage());
  }
}
