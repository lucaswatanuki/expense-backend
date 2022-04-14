package com.finances.expenses.integration;

import com.finances.expenses.client.ExpenseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles(profiles = "test")
public abstract class IntegrationTestSupport {

    @Autowired
    ExpenseClient expenseClient;
}
