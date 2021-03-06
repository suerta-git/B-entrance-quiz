package com.thoughtworks.capability.gtb.entrancequiz.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<CustomError> typeMismatchExceptionHandler(MethodArgumentTypeMismatchException exception) {
        if (Objects.requireNonNull(exception.getParameter().getMethod()).getName().equals("getGroups")) {
            // TODO GTB-工程实践: - 方法链式调用层级太多，可以通过定义局部变量减少链式调用
            return ResponseEntity.badRequest().body(new CustomError(400, "Total group number should be an integer"));
        }
        return ResponseEntity.badRequest().body(new CustomError(400, "Convert type failed"));
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<CustomError> illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(new CustomError(400, exception.getMessage()));
    }
}
