package com.finances.expenses.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Expense {

    @Id
    private String id;
    private String description;
    private LocalDateTime date;
    private Integer installment;
    private BigDecimal total;
    private Account account;

}
