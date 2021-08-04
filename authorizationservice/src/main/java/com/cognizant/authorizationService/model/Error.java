package com.cognizant.authorizationService.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Error {
	    private HttpStatus status;
	    private LocalDateTime timestamp;
	    private String message;
		
}
