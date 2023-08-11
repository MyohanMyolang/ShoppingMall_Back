package com.myolang.shoppingmall_back.Member.repository;

import com.myolang.shoppingmall_back.Member.entity.Member;
import com.myolang.shoppingmall_back.Member.entity.MemberAddress;
import com.myolang.shoppingmall_back.Member.entity.MemberInfo;
import com.myolang.shoppingmall_back.Member.entity.MemberRole;
import com.myolang.shoppingmall_back.global.config.P6SpyFormatter;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportAutoConfiguration(P6SpyFormatter.class)
class MemberRepositoryTest {
  @Autowired
  MemberRepository memberRepository;

  @Autowired
  EntityManager em;

  @BeforeEach
  void beforeEach(){
    Member member = Member.builder()
      .userId("test")
      .pw("test")
      .jwt("jwt")
      .role(MemberRole.Admin)
      .build();
    MemberInfo info1 = MemberInfo.builder()
      .phoneNumber("010-0000-0000")
      .build();
    //em.persist(info1);
    MemberAddress addr = new MemberAddress();
    addr.setCity("city");
    addr.setMemberInfo(info1);

    member.setInfo(info1);
    info1.addAddress(addr);
    memberRepository.save(member);



    Member member2 = Member.builder()
      .userId("test1")
      .pw("test")
      .jwt("jwt1")
      .role(MemberRole.Admin)
      .build();
    MemberInfo info2 = MemberInfo.builder()
      .phoneNumber("010-0000-0000")
      .build();
    //em.persist(info2);
    member2.setInfo(info2);
    MemberAddress addr1 = new MemberAddress();
    addr1.setCity("city1");
    addr1.setMemberInfo(info2);
    info2.addAddress(addr1);
    memberRepository.save(member2);
  }

  @Test
  @DisplayName("Jpa Save Test And FindByRole")
  @Transactional
  void jpaSaveTest(){
    //given

      //when
    List<Member> result = memberRepository.findByRole(MemberRole.Admin);

    //then
    assertThat(result.size()).isEqualTo(2);

  }

  @Test
  @DisplayName("Same Jwt Insert Test")
  @Transactional
  void sameJwtTest(){
      //given
    Member member = Member.builder()
      .userId("test")
      .pw("test")
      .jwt("jwt")
      .role(MemberRole.Admin)
      .build();
      //when

      //then
    DataIntegrityViolationException excep = assertThrows(DataIntegrityViolationException.class, () -> {
      memberRepository.save(member);
    });
    /*
    NOTE: DataIntegrityViolationException
      무결성 위반에 대한 에러이다.
      이 테스트 코드에서는 Unique Key인 jwt가 중복되어 발생 한다.
     */
  }

  @Test
  @DisplayName("Change Values Test")
  @Transactional
  void changeValue(){
    Optional<Member> result1 = memberRepository.findByUserId("test");
    assertThat(result1.isPresent()).isTrue();
//    assertThat(result.getJwt()).isEqualTo("jwt");
    Member result = result1.get();
    result.changeJwt("jwt2");
    Member changedResult = memberRepository.findByUserId("test").get();

    assertThat(changedResult.getJwt()).isEqualTo("jwt2");

    List<Member> byRole = memberRepository.findByRole(MemberRole.Admin);
    assertThat(byRole.size()).isEqualTo(2);

    result.changeRole(MemberRole.LoginUser);
    List<Member> byRole1 = memberRepository.findByRole(MemberRole.Admin);
    assertThat(byRole1.size()).isEqualTo(1);
  }


  @Test
  @DisplayName("check what throw or value when can't find data in DB")
  void checkFindValue(){
      //given
    Optional<Member> test1 = memberRepository.findByUserId("test5");
    assertThat(test1.isPresent()).isFalse();
    //when

      //then
  }

  @Test
  @DisplayName("get Address Test")
  void addressTest(){
      //given
    Member result = memberRepository.findByUserId("test").get();
    MemberAddress memberAddress = result.getInfo().getAddress().get(0);
    MemberAddress memberAddress1 = result.getInfo().getAddress().get(1);
    assertThat(result.getInfo().getAddress().size()).isEqualTo(2);
    System.out.println("memberAddress.getCity() = " + memberAddress.getCity());
    System.out.println("memberAddress1.getCity() = " + memberAddress1.getCity());

    assertThat(memberAddress.getCity()).isEqualTo("city");
    assertThat(memberAddress1.getCity()).isEqualTo("city1");
    //then
  }
}