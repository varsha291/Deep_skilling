SET SERVEROUTPUT ON;

-- Scenario 1: Generate monthly statements using an explicit cursor.
DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID,
               c.Name,
               t.TransactionID,
               t.TransactionDate,
               t.Amount,
               t.TransactionType
        FROM Customers c
        JOIN Accounts a ON a.CustomerID = c.CustomerID
        JOIN Transactions t ON t.AccountID = a.AccountID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
        ORDER BY c.CustomerID, t.TransactionDate;
BEGIN
    FOR statement_row IN GenerateMonthlyStatements LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Customer ' || statement_row.CustomerID || ' - ' || statement_row.Name ||
            ': Transaction ' || statement_row.TransactionID ||
            ', ' || statement_row.TransactionType ||
            ', Amount ' || statement_row.Amount ||
            ', Date ' || TO_CHAR(statement_row.TransactionDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/

-- Scenario 2: Apply annual maintenance fee to all active accounts.
DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE Status = 'ACTIVE'
        FOR UPDATE;

    v_annual_fee CONSTANT NUMBER := 100;
BEGIN
    FOR account_row IN ApplyAnnualFee LOOP
        UPDATE Accounts
        SET Balance = Balance - v_annual_fee,
            LastModified = SYSDATE
        WHERE CURRENT OF ApplyAnnualFee;

        DBMS_OUTPUT.PUT_LINE('Annual fee applied to account ' || account_row.AccountID);
    END LOOP;

    COMMIT;
END;
/

-- Scenario 3: Update loan interest rates based on a policy.
DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans
        FOR UPDATE;

    v_new_rate Loans.InterestRate%TYPE;
BEGIN
    FOR loan_row IN UpdateLoanInterestRates LOOP
        IF loan_row.LoanAmount >= 10000 THEN
            v_new_rate := loan_row.InterestRate + 0.50;
        ELSE
            v_new_rate := loan_row.InterestRate + 0.25;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE CURRENT OF UpdateLoanInterestRates;

        DBMS_OUTPUT.PUT_LINE(
            'Loan ' || loan_row.LoanID ||
            ' rate changed from ' || loan_row.InterestRate ||
            ' to ' || v_new_rate
        );
    END LOOP;

    COMMIT;
END;
/
