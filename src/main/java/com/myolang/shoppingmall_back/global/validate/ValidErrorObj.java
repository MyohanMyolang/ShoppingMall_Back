package com.myolang.shoppingmall_back.global.validate;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class ValidErrorObj {
  private String message;
  private boolean isShowUser;

  private HashMap<String, ValidErrorObj> map = new HashMap<>();

  private ValidErrorObj(){};
  private ValidErrorObj(String message, boolean isShowUser) {
    this.message = message;
    this.isShowUser = isShowUser;
  }

  public ValidErrorObj createValidError(String filed, String message, boolean isShowUser){
    ValidErrorObj obj = map.get(filed);
    if(obj != null)
      return obj;

    ValidErrorObj validErrorObj = new ValidErrorObj(message, isShowUser);
    map.put(filed, validErrorObj);
    return validErrorObj;
  }

//  public String getTlqkf(){
//    return "씨발";
//  }
}
