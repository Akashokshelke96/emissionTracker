package com.example.springbootcrud.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "cityHallId")
    @NotNull
    private Integer cityHallId;

    @JsonProperty(value = "fromDate")
    @NotNull
    private LocalDate fromDate;

    @JsonProperty(value = "toDate")
    private LocalDate toDate;



}
