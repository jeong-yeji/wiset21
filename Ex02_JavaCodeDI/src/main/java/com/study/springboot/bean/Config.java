package com.study.springboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 클래스를 스프링 설정으로 사용함을 의미
@Configuration
public class Config {

    // 메서드의 리턴 값을 빈 객체로 사용함을 의미
    @Bean
    public Member member1() {
        // Setter Injection (Setter 메소드를 이용한 의존성 투입)
        Member member1 = new Member();
        member1.setName("홍길동");
        member1.setNickname("도사");
        member1.setPrinter(new PrinterA());

        return member1;
    }

    @Bean(name="hello") // 별칭으로 Bean 등록
    public Member member2() {
        // Constructor Injection (생성자를 이용한 의존성 투입)
        return new Member("전우치", "도사", new PrinterA());
    }

    @Bean
    public PrinterA printerA() {
        return new PrinterA();
    }

    @Bean
    public PrinterB printerB() {
        return new PrinterB();
    }
}

// 빈(Bean) : Spring이 IoC 방식으로 관리하는 객체
// 빈 팩토리(BeanFactory) : Spring의 IoC를 담당하는 핵심 컨테이너
// 어플리케이션 컨텍스트(ApplicationContext) : 빈 팩토리를 확장한 IoC 컨테이너