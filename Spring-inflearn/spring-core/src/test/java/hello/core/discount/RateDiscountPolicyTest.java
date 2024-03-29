package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인 적용")
    void vip_o() throws Exception {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인X")
    void vip_x() throws Exception {
        //given
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);

    }
}