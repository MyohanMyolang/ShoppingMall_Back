package com.myolang.shoppingmall_back.common.Member.repository;

import com.myolang.shoppingmall_back.common.Member.entity.Member;
import com.myolang.shoppingmall_back.common.Member.entity.MemberRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends CrudRepository<Member, Long> {
  List<Member> findByMemberRole(MemberRole memberRole);

  Optional<Member> findByUserId(String userId);

  @Override
  void deleteById(Long id);
}
