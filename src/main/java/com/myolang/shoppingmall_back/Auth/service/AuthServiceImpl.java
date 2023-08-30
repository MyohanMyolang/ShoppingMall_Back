package com.myolang.shoppingmall_back.Auth.service;

import com.myolang.shoppingmall_back.Auth.exceptions.NotFoundUser;
import com.myolang.shoppingmall_back.Auth.repository.AuthRepository;
import com.myolang.shoppingmall_back.common.Member.dto.MemberResDto;
import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.exceptions.DeveloperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Service
public class AuthServiceImpl implements AuthService{
  private final AuthRepository authRepository;
  private final Map<String, BiConsumer<Member,Object>> changeMethods;

  void initConsumerMap(){
    changeMethods.put("pw", (user, pw) -> {
      authRepository.changePw(user, (String)pw);
    });
    changeMethods.put("nickname", (user, nickname) -> {
      authRepository.changeNickname(user, (String)nickname);
    });
  }

  @Autowired
  AuthServiceImpl(AuthRepository authRepository){
    this.authRepository = authRepository;
    changeMethods = new HashMap<>();
    initConsumerMap();
  }


  @Override
  public boolean regist(Member member){
    return authRepository.regist(member);
  }


  @Override
  public MemberResDto login(String id, String pw){
    Member user = authRepository.getByUserId(id);
    /* NOTE:
        Repository에서 NULL을 반환 시킨 이유 - pw가 틀려도, id를 찾지 못하여도 NotFoundUser Exception을 던지고 try/catch문 없이 사용하기 위하여
    */
    if(user == null || !user.getPw().equals(pw))
      throw new NotFoundUser();

    return user.toMemberResDto();
  }

  @Transactional
  public void changeData(String nickname, Map<String, Object> data){
    Member member = authRepository.getByNickname(nickname);
    data.keySet().forEach((key) -> {
      BiConsumer<Member, Object> consumer = changeMethods.get(key);
      if (consumer == null)
        throw new NullPointerException("test"); // Temp
      
    });
  }
}
