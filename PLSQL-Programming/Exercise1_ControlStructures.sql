SET SERVEROUTPUT ON;

-- Scenario 1: Apply a 1 percent discount to loan rates for customers above 60.
BEGIN
    FOR customer_loan IN (
        SELECT l.LoanID, c.CustomerID, c.Name, c.DOB, l.InterestRate
        FROM Customers c
        JOIN Loans l ON l.CustomerID = c.CustomerID
    ) LOOP
        IF TRUNC(MONTHS_BETWEEN(SYSDATE, customer_loan.DOB) / 12) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = customer_loan.LoanID;

            DBMS_OUTPUT.PUT_LINE(
                'Discount applied for ' || customer_loan.Name ||
                '. Old rate: ' || customer_loan.InterestRate ||
                ', New rate: ' || (customer_loan.InterestRate - 1)
            );
        END IF;
    END LOOP;

    COMMIT;
END;
/

-- Scenario 2: Mark customers with balance over 10000 as VIP.
BEGIN
    FOR customer_record IN (
        SELECT CustomerID, Name, Balance
        FROM Customers
    ) LOOP
        IF customer_record.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y',
                LastModified = SYSDATE
            WHERE CustomerID = customer_record.CustomerID;

            DBMS_OUTPUT.PUT_LINE(customer_record.Name || ' promoted to VIP.');
        END IF;
    END LOOP;

    COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due in the next 30 days.
BEGIN
    FOR due_loan IN (
        SELECT c.Name, l.LoanID, l.EndDate
        FROM Customers c
        JOIN Loans l ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ' || due_loan.LoanID ||
            ' for ' || due_loan.Name ||
            ' is due on ' || TO_CHAR(due_loan.EndDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/
