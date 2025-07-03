package com.hansung.likelion.global.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@RequiredArgsConstructor
@ToString
public class BaseResponse {
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    private final String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    //생성자를 통해 기존 응답 생성

    //정적 팩토리 메서드
    //생산자를 직접 호출하지 않고, 명확한 이름을 가진 정적 메서드로 객체 생성
    //다향한 조합으로 다형적 객체 생성 가능

    //기존 응답에 성공 여부만 바꿔서 새로 만듦
    public static BaseResponse of(Boolean isSuccess, BaseResponse baseResponse) {
        return new  BaseResponse(isSuccess, baseResponse.getCode(), baseResponse.getMessage());
    }

    //기존 응답에 성공 여부와 메시지를 바꿔서 새로 만듦
    public static BaseResponse of(Boolean isSuccess, BaseResponse baseResponse, String message) {
        return new  BaseResponse(isSuccess, baseResponse.getCode(), message);
    }

    //직접 모든 값 지정
    public static BaseResponse of(Boolean isSuccess, String code, String message) {
        return new BaseResponse(isSuccess, code, message);
    }
}
