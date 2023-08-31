package com.myolang.shoppingmall_back.common.Member.service;

import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.exceptions.InvalidRequestException;
import com.myolang.shoppingmall_back.common.Member.exceptions.SameBeforePwException;
import com.myolang.shoppingmall_back.common.Member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Service
public class MemberServiceImpl implements MemberService{

  private final Map<String, BiConsumer<Member, Object>> changeMethods;
  private final PasswordEncoder passwordEncoder;
  private final MemberRepository memberRepository;
  void initConsumerMap(){
    changeMethods.put("pw", (member, pw) -> {
      if(passwordEncoder.matches((String)pw, member.getPw()))
        throw new SameBeforePwException(member.getUserId() + ": Same PassWord Input");
      memberRepository.changePw(member, (String)pw);
    });
  }

  @Autowired
    MemberServiceImpl(MemberRepository memberRepository, PasswordEncoder passwordEncoder){
    this.memberRepository = memberRepository;
    this.passwordEncoder = passwordEncoder;
    changeMethods = new HashMap<>();
    initConsumerMap();
  }

  @Transactional
  public void changeData(String nickname, Map<String, Object> data) {
    Member member = memberRepository.findByNickName(nickname);
    data.keySet().forEach((key) -> {
      BiConsumer<Member, Object> consumer = changeMethods.get(key);
      if (consumer == null)
        throw new InvalidRequestException("Change 요청이 잘못 되었습니다.\nJson형태를 다시 확인하여 주십시오.");
      consumer.accept(member, data.get(key));
    });
  }
}
