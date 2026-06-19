SET SERVEROUTPUT ON;

-- Scenario 1: Calculate customer age in years.
CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER AS
BEGIN
    RETURN TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
END;
/

-- Scenario 2: Calculate monthly loan installment.
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_annual_interest_rate IN NUMBER,
    p_duration_years IN NUMBER
) RETURN NUMBER AS
    v_monthly_rate NUMBER;
    v_months NUMBER;
BEGIN
    v_monthly_rate := p_annual_interest_rate / 100 / 12;
    v_months := p_duration_years * 12;

    IF v_months <= 0 THEN
        RAISE_APPLICATION_ERROR(-20020, 'Duration must be greater than zero.');
    END IF;

    IF v_monthly_rate = 0 THEN
        RETURN p_loan_amount / v_months;
    END IF;

    RETURN p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months)
           / (POWER(1 + v_monthly_rate, v_months) - 1);
END;
/

-- Scenario 3: Check whether an account has enough balance.
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN Accounts.AccountID%TYPE,
    p_amount IN NUMBER
) RETURN BOOLEAN AS
    v_balance Accounts.Balance%TYPE;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/

DECLARE
    v_has_balance BOOLEAN;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Age for 15-MAY-1985: ' || CalculateAge(TO_DATE('1985-05-15', 'YYYY-MM-DD')));
    DBMS_OUTPUT.PUT_LINE('Monthly installment: ' || ROUND(CalculateMonthlyInstallment(5000, 5, 5), 2));

    v_has_balance := HasSufficientBalance(1, 500);
    IF v_has_balance THEN
        DBMS_OUTPUT.PUT_LINE('Account 1 has sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Account 1 does not have sufficient balance.');
    END IF;
END;
/
