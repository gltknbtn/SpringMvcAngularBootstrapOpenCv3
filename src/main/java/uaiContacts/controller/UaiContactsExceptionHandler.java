package uaiContacts.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UaiContactsExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
		String response = "Bu bir hata mesajidir.";
		ex.printStackTrace();
		return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
}