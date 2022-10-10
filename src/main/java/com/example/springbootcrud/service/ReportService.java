package com.example.springbootcrud.service;

import com.example.springbootcrud.requests.ReportRequest;
import com.example.springbootcrud.response.ReportResponse;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {


    public ReportResponse getReportByCityHallId(ReportRequest reportRequest);
}
