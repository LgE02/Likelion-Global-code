package com.hansung.likelion.global.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hansung.likelion.global.response.code.BaseResponseCode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
//해당 클래스가 JSON으로 변환될때 필드가 나열된 순서대로 강제 출력
@JsonPropertyOrder({"isSuccess", "timestamp", "code", "httpStatus","message","data"})
public class ErrorResponse<T> extends BaseResponse {
    private final int httpStatus;
    private final T data;

    @Builder
    public ErrorResponse(T data, BaseResponseCode baseResponseCode) {
        super(false, baseResponseCode.getCode(), baseResponseCode.getMessage());
        this.httpStatus = baseResponseCode.getHttpStatus();
        this.data = data;
    }


    @Builder
    public ErrorResponse(T data, BaseResponseCode baseResponseCode, String message) {
        super(false, baseResponseCode.getCode(), message);
        this.httpStatus = baseResponseCode.getHttpStatus();
        this.data = data;
    }

    //정적 팩토리 메소드
    //에러 응답 커스텀

    //data X
    public static ErrorResponse<?> from(BaseResponseCode baseResponseCode) {
        return new ErrorResponse<>(null, baseResponseCode);
    }

    //data X, 메시지 커스텀
    public static ErrorResponse<?> of(BaseResponseCode baseResponseCode, String message) {
        return new ErrorResponse<>(null, baseResponseCode, message);
    }

    //data o
    public static <T> ErrorResponse<T> of(BaseResponseCode baseResponseCode, T data) {
        return new ErrorResponse<>(data, baseResponseCode);
    }

    //data o, 메시지 커스텀
    public static <T> ErrorResponse<T> of(BaseResponseCode baseResponseCode, T data, String message) {
        return new ErrorResponse<>(data, baseResponseCode, message);
    }

}
