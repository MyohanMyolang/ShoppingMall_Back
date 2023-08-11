package com.myolang.shoppingmall_back.Member.exceptions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberExceptionHandlerTest {
  @Test
  @DisplayName("regex Test")
  void regex() {
    //given
    String str = "(it)=(test)";
    Pattern pattern = Pattern.compile("\\((.*?)\\)=\\((.*?)\\)");
    Matcher matcher = pattern.matcher(str);

    String[] groups = new String[2];
    if (matcher.matches()) {
      groups[0] = matcher.group(1);
      groups[1] = matcher.group(2);
    }

    assertThat(groups[0]).isEqualTo("it");
    assertThat(groups[1]).isEqualTo("test");
      //when

      //then
  }
}