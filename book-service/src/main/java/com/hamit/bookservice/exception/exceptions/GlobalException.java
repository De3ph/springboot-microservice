package com.hamit.bookservice.exception.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GlobalException {
    private String message;
    private HttpStatusCode statusCode;

    private Timestamp raisedAt;

}
