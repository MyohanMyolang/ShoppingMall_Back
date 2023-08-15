package com.myolang.shoppingmall_back.Member.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(nullable = false)
  @Setter
  @Getter
  private String phoneNumber;

  @Column(nullable = false)
  @Setter
  @Getter
  private String name;

  @Setter
  @OneToMany(mappedBy = "memberInfo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<MemberAddress> address = new ArrayList<>();

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member", referencedColumnName = "id")
  private Member member;

  @Builder
  public MemberInfo(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public boolean addAddress(MemberAddress addr){
    try {
      address.add(addr);
      return true;
    } catch (Exception e){
      System.out.println(e.getMessage());
      return false;
    }
  }


}

