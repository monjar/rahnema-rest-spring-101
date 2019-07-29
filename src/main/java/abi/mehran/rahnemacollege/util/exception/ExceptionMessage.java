package abi.mehran.rahnemacollege.util.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionMessage {
    private String message;
    private int code;
}
