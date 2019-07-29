package ind.amirali.Controllers;
import com.google.gson.Gson;
import ind.amirali.Controllers.apilevelexception.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    static class ExceptionMessage {

        String message;

        int code;


        public ExceptionMessage(String message, int code) {

            this.message = message;

            this.code = code;

        }

    }


    private Gson gson;

    public RestResponseEntityExceptionHandler() {

        gson = new Gson();

    }


    @ExceptionHandler(value = {NullPointerException.class})

    protected ResponseEntity<Object> handleConflict(RuntimeException ex,


                                                    WebRequest request) {

        String bodyOfResponse = gson.toJson(


                new ExceptionMessage(ex.getMessage(), 456));

        return handleExceptionInternal(ex, bodyOfResponse,

                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,

                request);

    }

    @ExceptionHandler(value = {EntityNotFoundException.class})

    protected ResponseEntity<Object> handleEntityNotFound(RuntimeException ex,

                                                          WebRequest request) {

        String bodyOfResponse = gson.toJson(

                new ExceptionMessage(ex.getMessage(), 456));

        return handleExceptionInternal(ex, bodyOfResponse,

                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,

                request);

    }


}