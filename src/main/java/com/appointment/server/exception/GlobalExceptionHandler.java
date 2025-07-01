package com.appointment.server.exception;

import com.appointment.server.dto.ErrorResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {
        // map to response
        ErrorResponse response = new ErrorResponse("Fields are not valid", Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage());
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<?> handleDuplicateKey(DuplicateKeyException ex) {
        // map to response
        String error = ex.getMessage();
        Pattern pattern = Pattern.compile("\\{[^{}]*\\}");
        Matcher matcher = pattern.matcher(error);

        List<String> errorMsg = new ArrayList<>();

        while (matcher.find()) {
            if(matcher.group().contains(":"))
                errorMsg.add(matcher.group().toString());// keep updating to get the last match
        }

        ErrorResponse response = new ErrorResponse("Given field are already exist", !errorMsg.isEmpty() ? errorMsg:"Please try with unique field.");
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        // map to response
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
