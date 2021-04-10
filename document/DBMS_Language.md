# DBMS 데이터 언어 - DDL, DML, DCL, TCL 정의

## SQL(Structured Query Language)
SQL은 DBMS에서 사용하는 표준언어이다. SQL은 데이터를 다루는 집합적 언어이다. SQL은 크게 DDL, DML, DCL로 나눠진다.

### 1. DDL(Data Definition Language) : 데이터 정의어
데이터 정의라고 하면 데이터베이스 객체들을 정의하는 것이다. 데이터베이스 객체는 테이블, 뷰, 인덱스, 시노님, 시퀀스, 파티션 테이블이 포함된다. DDL 명령어 실행 시 즉시 커밋된다.<br/>
- CREATE<br/>
- ALTER<br/>
- DROP<br/>
- RENAME<br/>
- COMMENT<br/>
- TRUNCATE<br/>


### 2. DML(Data Manipulation Language) : 데이터 조작어
데이터베이스 내의 데이터를 조작(추출, 생성, 수정, 삭제)할 수 있다.<br/>
- SELECT<br/>
- INSERT<br/>
- UPDATE<br/>
- DELETE<br/>
- MERGE<br/>
- CALL<br/>
- EXPLAIN PLAN<br/>
- LOCK TABLE<br/>


### 3. DCL(Data Control Language) : 데이터 제어 언어
사용자에게 권한을 주거나 회수할 수 있다. DCL 명령어 실행 시 즉시 커밋된다.<br/>
- GRANT<br/>
- REVOKE<br/>


### 4. TCL(Transaction Control Language) : 제어 언어<br/>
- COMMIT<br/>
- ROLLBACK<br/>
- SAVEPOINT<br/>
- TRANSACTION<br/>
   
