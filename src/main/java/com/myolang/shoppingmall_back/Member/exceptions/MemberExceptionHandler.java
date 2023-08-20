package com.myolang.shoppingmall_back.Member.exceptions;

import com.myolang.shoppingmall_back.global.validate.ValidErrorObj;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice(basePackages = {"com.myolang.shoppingmall_back.Member"})
@RequiredArgsConstructor
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
  ResponseEntity test(DataIntegrityViolationException e){
    // Log
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("버그 리포트를 남겨주시기 바랍니다.");
  }


  @ExceptionHandler(HttpMessageNotReadableException.class)
  ResponseEntity requiredRequestBodyError(HttpMessageNotReadableException e){

    return ResponseEntity.badRequest().body("값이 형식에 맞게 전달되지 않았습니다.");
  }

  @ExceptionHandler(DeveloperException.class)
  ResponseEntity developerError(DeveloperException e){
    return e.createResEntity();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  ResponseEntity<Map<String, ValidErrorObj>> validateError(MethodArgumentNotValidException e){
    Map<String, ValidErrorObj> resultMap = new HashMap<>();

    for(FieldError error : e.getBindingResult().getFieldErrors()){
      String field = error.getField();
      if(field.equals("role")) { // 다른 것도 처리하고 싶다면 || 을 사용하기
        resultMap.put(field, validErrorObj.createValidError(field, error.getDefaultMessage(), false));
        continue;
      }
      resultMap.put(error.getField(), validErrorObj.createValidError(field, error.getDefaultMessage(), true));
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultMap);
  }
}
