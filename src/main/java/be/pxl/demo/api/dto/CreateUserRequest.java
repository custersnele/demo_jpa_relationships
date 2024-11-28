package be.pxl.demo.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record CreateUserRequest(String firstname, String lastname, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dob) {

}
