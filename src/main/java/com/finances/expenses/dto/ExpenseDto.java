package com.finances.expenses.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
public class ExpenseDto {

    private String id;
    private String description;
    private LocalDateTime date;
    private Integer installment;
    private BigDecimal total;
    private AccountDto account;

}
