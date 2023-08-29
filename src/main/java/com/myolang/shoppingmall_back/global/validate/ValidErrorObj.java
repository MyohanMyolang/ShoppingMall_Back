package com.myolang.shoppingmall_back.global.validate;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Component
public class ValidErrorObj {
  @Getter
  private String message;
  @Getter
  private boolean isShowUser;

  private HashMap<String, ValidErrorObj> map = new HashMap<>();

  void setCheckList(){
    checkList = new LinkedList<>();

    checkList.add("role");
    checkList.add("datas");
  }
  private ValidErrorObj(){
    setCheckList();
  };
  private ValidErrorObj(String message, boolean isShowUser) {
    this.message = message;
    this.isShowUser = isShowUser;
  }

  List<String> checkList;

  public boolean checkShowUser(String filed){
    return checkList.contains(filed);
  }

  public ValidErrorObj createValidError(String filed, String message, boolean isShowUser){
    ValidErrorObj obj = map.get(filed+message);
    if(obj != null)
      return obj;

    ValidErrorObj validErrorObj = new ValidErrorObj(message, isShowUser);
    map.put(filed+message, validErrorObj);
    return validErrorObj;
  }
}
