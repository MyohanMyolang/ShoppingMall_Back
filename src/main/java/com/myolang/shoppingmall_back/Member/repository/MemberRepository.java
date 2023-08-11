package com.myolang.shoppingmall_back.Member.repository;

import com.myolang.shoppingmall_back.Member.entity.Member;
import com.myolang.shoppingmall_back.Member.entity.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
  List<Member> findByRole(MemberRole memberRole);

  Optional<Member> findByUserId(String userId);


}
