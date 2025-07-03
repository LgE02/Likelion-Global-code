package com.hansung.likelion.global.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hansung.likelion.global.response.code.BaseResponseCode;
import com.hansung.likelion.global.response.code.SuccessResponseCode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
//해당 클래스가 JSON으로 변환될때 필드가 나열된 순서대로 강제 출력
@JsonPropertyOrder({"isSuccess", "timestamp", "code", "httpStatus","message","data"})
public class SuccessResponse<T> extends BaseResponse{
    private final int httpStatus;
    private final T data;

    @Builder
    public SuccessResponse(T data, BaseResponseCode baseResponseCode) {
        super(true, baseResponseCode.getCode(), baseResponseCode.getMessage());
        this.httpStatus = baseResponseCode.getHttpStatus();
        this.data = data;
    }

    public static <T> SuccessResponse<T> from(T data){
        return new SuccessResponse<T>(data, SuccessResponseCode.SUCCESS_OK);
    }

    public static <T> SuccessResponse<T> empty(){
        return new  SuccessResponse<T>(null, SuccessResponseCode.SUCCESS_OK);
    }

    public static <T> SuccessResponse<T> of(T data, BaseResponseCode baseResponseCode){
        return new SuccessResponse<T>(data, baseResponseCode);
    }

    public static SuccessResponse<?> from(BaseResponseCode baseResponseCode){
        return new SuccessResponse<>(null, baseResponseCode);
    }
}
