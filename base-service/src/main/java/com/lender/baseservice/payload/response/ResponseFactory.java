package com.lender.baseservice.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ResponseFactory {

    public <T> ResponseEntity<BaseResponse<T>> success(String message, T data) {
        BaseResponse response = BaseResponse.<T>builder()
                .status(HttpStatus.OK)
                .message(message)
                .data(data)
                .dateTime(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }

    public <T> ResponseEntity<BaseResponse<T>> fail(HttpStatus status, String message, T data) {
        BaseResponse response = BaseResponse.<T>builder()
                .status(status)
                .message(message)
                .data(data)
                .dateTime(LocalDateTime.now())
                .build();

        return ResponseEntity.status(status).body(response);
    }
}
