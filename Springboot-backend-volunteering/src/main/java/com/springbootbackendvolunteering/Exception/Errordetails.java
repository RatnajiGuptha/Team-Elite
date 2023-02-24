package com.springbootbackendvolunteering.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Errordetails {

	private LocalDateTime timesatmp;
	private String message;
	private String details;

}