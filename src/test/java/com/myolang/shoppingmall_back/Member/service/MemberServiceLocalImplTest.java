package com.myolang.shoppingmall_back.Member.service;

import com.myolang.shoppingmall_back.global.config.P6SpyFormatter;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;


@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportAutoConfiguration(P6SpyFormatter.class)
class MemberServiceLocalImplTest {


//  @Test
//  @DisplayName("Member Null Test")
//  void memberNull(){
//      //given
//    Member member = Member.builder()
//      .userId("test")
//      .pw("test")
//      .refreshToken("jwt")
//      .memberRole(MemberRole.Admin)
//      .build();
//    MemberInfo info1 = MemberInfo.builder()
//      .phoneNumber("010-0000-0000")
//      .name("testName1")
//      .build();
//    //em.persist(info1);
//    MemberAddress addr = new MemberAddress("city", "detail");
//    addr.setMemberInfo(info1);
//
//    member.setInfo(info1);
//    info1.addAddress(addr);
//    MemberAddress addr1 = new MemberAddress("city", "detail");
//    addr1.setMemberInfo(info1);
//    info1.addAddress(addr1);
//
//
//
//    //when
//    DeveloperException exception = assertThrows(DeveloperException.class, () -> memberService.regist((Member) null));
//
//      //then
//    assertThat(exception.getMessage()).isEqualTo("Should Check Code");
//  }
}