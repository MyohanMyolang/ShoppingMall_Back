package com.myolang.shoppingmall_back.common.Member.repository;

import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.entity.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface MemberJpaRepository extends JpaRepository<Member, Long> {
  List<Member> findByMemberRole(MemberRole memberRole);

  Optional<Member> findByUserId(String userId);

  Optional<Member> findByNickName(String nickName);

  @Override
  void deleteById(Long id);
}
