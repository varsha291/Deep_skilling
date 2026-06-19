SET SERVEROUTPUT ON;

-- Scenario 1: Update LastModified whenever a customer row is updated.
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

-- Scenario 2: Write an audit row whenever a transaction is inserted.
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        TransactionID,
        AccountID,
        ActionName,
        ActionDate,
        Details
    ) VALUES (
        :NEW.TransactionID,
        :NEW.AccountID,
        'INSERT_TRANSACTION',
        SYSDATE,
        'Type=' || :NEW.TransactionType || ', Amount=' || :NEW.Amount
    );
END;
/

-- Scenario 3: Enforce deposit and withdrawal rules before transaction insert.
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance Accounts.Balance%TYPE;
BEGIN
    IF UPPER(:NEW.TransactionType) = 'DEPOSIT' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20030, 'Deposit amount must be positive.');
        END IF;
    ELSIF UPPER(:NEW.TransactionType) = 'WITHDRAWAL' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20031, 'Withdrawal amount must be positive.');
        END IF;

        SELECT Balance
        INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID;

        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20032, 'Withdrawal exceeds account balance.');
        END IF;
    ELSE
        RAISE_APPLICATION_ERROR(-20033, 'Transaction type must be Deposit or Withdrawal.');
    END IF;
END;
/
