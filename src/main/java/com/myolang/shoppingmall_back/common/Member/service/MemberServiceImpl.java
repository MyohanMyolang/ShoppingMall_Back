package com.myolang.shoppingmall_back.common.Member.service;

import com.myolang.shoppingmall_back.common.Member.entity.Member;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"dev", "prod"})
@Service
public class MemberServiceImpl implements MemberService{

}
