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

  /*
  NOTE : 현재 Member Table 에는 Jwt와, User_Id만이 unique Key를 가지고 있기에
  @ExceptionHandler(DataIntegrityViolationException.class)
  ResponseEntity integrityException(DataIntegrityViolationException e){
    String message = e.getMessage();
    Pattern pattern = Pattern.compile("\\((.*?)\\)=\\((.*?)\\)");
    Matcher matcher = pattern.matcher(message);

    String[] groups = new String[2];
    if (matcher.matches()) {
      groups[0] = matcher.group(1);
      groups[1] = matcher.group(2);
    }

    return ResponseEntity.badRequest().build();
  }
   */

  @ExceptionHandler(DataIntegrityViolationException.class)
  ResponseEntity dataIntegrity(DataIntegrityViolationException e){
    // Log
    log.error("무결성 에러");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("버그 리포트를 남겨주시기 바랍니다.");
  }


  @ExceptionHandler(HttpMessageNotReadableException.class)
  ResponseEntity requiredRequestBodyError(HttpMessageNotReadableException e){
    log.warn("형식 에러");
    return ResponseEntity.badRequest().body("값이 형식에 맞게 전달되지 않았습니다.");
  }

  @ExceptionHandler(DeveloperException.class)
  ResponseEntity developerError(DeveloperException e){
    log.error(e.errorCode.getMessage());
    return e.createResEntity();
  }


}
