package com.ukg.payrollservice.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "request_response")
@Data
public class Report {
    @Id
    @GeneratedValue
    @Column(name = "report_id")
    private long id;

    @Column(name = "generationDate")
    private LocalDate generationDate;

    @Column(name = "filePath")
    private String filePath;
}
