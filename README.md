# Java EXAM - TAP

You can use the resources available in [TAP repository](TAP-master.zip)

---

## 1. Use TAP2/solutions code (accounts)

### 1.a
Load a list of accounts from the accounts.txt file.

### 1.b
Make a select function which allows us to execute the following query:  
SELECT NAME FROM ACCOUNTS WHERE *some_condition*

### 1.c
Make the select function Generic so that we can recover any/all of the fields from the Accounts. For example:  
SELECT * FROM ACCOUNTS WHERE *some_condition*  
SELECT NAME, BALANCE FROM ACCOUNTS WHERE *some_condition*  
SELECT TYPE FROM ACCOUNTS WHERE *some_condition*

### 1.d
Allow for ordering of the results including a Comparator<T>. For example:  
SELECT BALANCE FROM ACCOUNTS ORDER BY BALANCE

Demonstrate in the code the use of closures.

**Topics:** PREDICATE, FUNCTION, CLOSURE, STREAMS, GENERICS

---

## 2. Use TAP3/state full directory

Create a Decorator of Package that allows us to register Observers and notify of any state changes.  
Do not make changes to the original classes/interfaces in TAP3/state.

The observers should print the object reference and the new state.  
Demonstrate state changes and notifications in the main client code.

**Topics:** STATE, DECORATOR, OBSERVER

---

## 3. Use TAP4/dynamicproxy2

Use a Dynamic Proxy to make the observers implemented in the previous exercise print the updates in a file instead of the console, adding also the date and time of the update.

**Topics:** OBSERVER, REFLECTION → DYNAMIC PROXY
