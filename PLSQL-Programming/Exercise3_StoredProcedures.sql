SET SERVEROUTPUT ON;

-- Scenario 1: Apply 1 percent monthly interest to savings accounts.
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE UPPER(AccountType) = 'SAVINGS'
      AND Status = 'ACTIVE';

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' savings account(s) updated.');
    COMMIT;
END;
/

-- Scenario 2: Add a bonus percentage to employees in a department.
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN Employees.Department%TYPE,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE UPPER(Department) = UPPER(p_department);

    DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || ' employee(s) received bonus.');
    COMMIT;
END;
/

-- Scenario 3: Transfer funds after checking sufficient balance.
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN Accounts.AccountID%TYPE,
    p_to_account_id IN Accounts.AccountID%TYPE,
    p_amount IN NUMBER
) AS
    v_balance Accounts.Balance%TYPE;
BEGIN
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20010, 'Transfer amount must be positive.');
    END IF;

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id
      AND Status = 'ACTIVE'
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20011, 'Insufficient balance.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account_id
      AND Status = 'ACTIVE';

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20012, 'Destination account not found or closed.');
    END IF;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/
