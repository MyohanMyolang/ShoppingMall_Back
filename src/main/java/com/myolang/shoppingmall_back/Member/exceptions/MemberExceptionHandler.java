package com.myolang.shoppingmall_back.Member.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice(basePackages = {"com.myolang.shoppingmall_back.Member"})
public class MemberExceptionHandler {


  /*
  NOTE : 현재 Member Table 에는 Jwt와, User_Id만이 unique
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
}
