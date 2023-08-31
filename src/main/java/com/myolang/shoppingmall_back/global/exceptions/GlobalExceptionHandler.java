package com.myolang.shoppingmall_back.global.exceptions;

import com.myolang.shoppingmall_back.global.validate.ValidErrorObj;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
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
import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
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

  private final ValidErrorObj validErrorObj;

  @ExceptionHandler(MethodArgumentNotValidException.class)
  ResponseEntity<Map<String, ValidErrorObj>> validateError(MethodArgumentNotValidException e){
    Map<String, ValidErrorObj> resultMap = new HashMap<>();

    for(FieldError error : e.getBindingResult().getFieldErrors()){
      String field = error.getField();
      if(validErrorObj.checkShowUser(field)) {
        resultMap.put(field, validErrorObj.createValidError(field, error.getDefaultMessage(), false));
        continue;
      }
      resultMap.put(error.getField(), validErrorObj.createValidError(field, error.getDefaultMessage(), true));
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultMap);
  }

  @ExceptionHandler(NoSuchElementException.class)
  ResponseEntity noSuchElement(NoSuchElementException e){
    return ResponseEntity.internalServerError().body("지속 된다면 고객센터에 문의 바랍니다.");
  }

  @ExceptionHandler(ConstraintViolationException.class)
  ResponseEntity methodValidateError(ConstraintViolationException e){
    String errMessage = e.getConstraintViolations().stream()
      .map(constraintViolation -> constraintViolation.getMessage())
      .findFirst()
      .orElse("서버 에러");
    return ResponseEntity.badRequest().body(errMessage);
  }
}
