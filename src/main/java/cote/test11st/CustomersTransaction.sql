/*
-- Suggested testing environment:
-- http://sqlite.online/

-- Example case create statement:
CREATE TABLE customers (
  id INTEGER NOT NULL PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

CREATE TABLE transactions (
  id INTEGER NOT NULL PRIMARY KEY,
  customerId INTEGER REFERENCES customers(id),
  amount DECIMAL(15,2) NOT NULL
);

INSERT INTO customers(id, name) VALUES(1, 'Steve');
INSERT INTO customers(id, name) VALUES(2, 'Jeff');
INSERT INTO transactions(id, customerId, amount) VALUES(1, 1, 100);

-- Expected output (in any order):
-- name     transactions
-- -------------------------------
-- Steve    1
-- Jeff     0

-- Explanation:
-- In this example.
-- There are two customers, Steve and Jeff.
-- Steve has made one transaction. Jeff has made zero transactions.
 */

-- 다음 데이터 정의가 주어지면 모든 고객 이름과 고객이 만든 트랜잭션 수를 선택하는 쿼리를 작성하십시오.
-- 거래가없는 고객은 거래가없는 고객으로 포함되어야합니다.

select c.name, count(t.id)
from customers c left outer join transaction t
    on c.id = t.customerId
group by c.id, c.name