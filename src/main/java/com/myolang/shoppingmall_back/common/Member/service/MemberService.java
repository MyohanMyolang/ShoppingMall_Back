package com.myolang.shoppingmall_back.common.Member.service;

import org.springframework.stereotype.Service;

import java.util.Map;

public interface MemberService {
  void changeData(String nickname, Map<String, Object> datas);
}
