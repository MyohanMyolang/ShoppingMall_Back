package com.myolang.shoppingmall_back.Auth.exceptions;


import com.myolang.shoppingmall_back.global.exceptions.AlreadyHasDataException;
import com.myolang.shoppingmall_back.global.validate.ValidErrorObj;
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

@RequiredArgsConstructor
@RestControllerAdvice(basePackages = {"com.myolang.shoppingmall_back.Auth"})
public class AuthExceptionHandler {

  private final ValidErrorObj validErrorObj;

  @ExceptionHandler(MethodArgumentNotValidException.class)
  ResponseEntity<Map<String, ValidErrorObj>> validateError(MethodArgumentNotValidException e){
    Map<String, ValidErrorObj> resultMap = new HashMap<>();

    for(FieldError error : e.getBindingResult().getFieldErrors()){
      String field = error.getField();
      if(field.equals("role")) { // 다른 것도 처리하고 싶다면 || 을 사용하기
        resultMap.put(field, validErrorObj.createValidError(field, error.toString(), false));
        continue;
      }
      resultMap.put(error.getField(), validErrorObj.createValidError(field, error.getDefaultMessage(), true));
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultMap);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  ResponseEntity dataIntegrity(DataIntegrityViolationException e){
    return ResponseEntity.badRequest().body("잘못된 Query 또는 Data 입니다.");
  }

  @ExceptionHandler(AlreadyHasDataException.class)
  ResponseEntity alreadyHasData(AlreadyHasDataException e){
    return ResponseEntity.badRequest().body(e.getMessage());
  }
}
