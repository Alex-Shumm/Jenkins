@regression
Feature: Testing Clients End Points

  Scenario: Happy Path Create Clients(Client-Client EndPoint) --> POST
    Then User validates 'OLEG_LLC', 'IT', 'Mika' and 'Olezha1@gmail.com' from end-point


  Scenario: Happy Path Check Client (Client-Check Endpoint) --> GET
    Then User validates 'OLEG_LLC', 'IT', 'Mika' and 'Olezha1@gmail.com' from end-point Get

  Scenario: Happy Path Update Client (Client-Update Endpoint) --> PUT
    Then User validates 'NewName', 'kivi', 'My Test Company' and 'Alex@gmail.com' from end-point Put

  Scenario: Happy Path Delete Client (Client-Delete Endpoint) -->Delete
    Then User validates 'Apple', 'codewise', 'dssfv' and 'Shumak@gmail.com' from end-point Delete

  Scenario: Happy Path Check deleted Client (Client-Check EndPoint) -->Get
    Then User validates 'Internal server error' and 'Client not found'