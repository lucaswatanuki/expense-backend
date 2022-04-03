package com.finances.expenses.ExpenseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ExpenseDto {

    private String id;
    private String description;
    private LocalDateTime date;
    private Integer installment;
    private BigDecimal total;
    private AccountDto account;

    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class AccountDto {
        private String id;
        private String name;
        private String category;
    }
}
