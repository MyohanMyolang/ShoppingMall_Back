package com.myolang.shoppingmall_back.User.controller;

import com.myolang.shoppingmall_back.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
}
