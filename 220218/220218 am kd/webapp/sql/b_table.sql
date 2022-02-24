-- table drop
DROP TABLE member CASCADE constraints;
DROP TABLE nonmember CASCADE constraints;
DROP TABLE bookproduct CASCADE constraints;
DROP TABLE review CASCADE constraints;
DROP TABLE worker CASCADE constraints;
DROP TABLE cart CASCADE constraints;
DROP TABLE m_orders CASCADE CONSTRAINTS;
DROP TABLE nm_orders CASCADE CONSTRAINTS;
DROP TABLE m_order_detail CASCADE CONSTRAINTS;
DROP TABLE nm_order_detail CASCADE CONSTRAINTS;
DROP TABLE qna CASCADE CONSTRAINTS;

-- select
SELECT * FROM member;
SELECT * FROM nonmember;
SELECT * FROM bookproduct;
SELECT * FROM review;
SELECT * FROM worker;
SELECT * FROM cart;
SELECT * FROM m_orders;
SELECT * FROM nm_orders;
SELECT * FROM m_orders;
SELECT * FROM nm_orders;
SELECT * FROM qna;



DROP TABLE member CASCADE constraints;
CREATE TABLE member(
	id VARCHAR2(20) NOT NULL PRIMARY KEY ,
	pwd VARCHAR2(20) NOT NULL,
	name VARCHAR2(20),
	email VARCHAR2(40),
	zip_num VARCHAR2(10),
	address VARCHAR2(100),
	phone VARCHAR2(20),
	useyn CHAR(1) DEFAULT 'y',    -- 휴면 계정 여부
	indate DATE DEFAULT sysdate,
	gender CHAR(1),
	point NUMBER(10) DEFAULT 1000
);
SELECT * FROM member;

DROP TABLE nonmember CASCADE constraints;
CREATE TABLE nonmember(
	phone VARCHAR2(20) NOT NULL PRIMARY KEY,
	od_pass VARCHAR2(20) NOT NULL,		-- 비회원 주문번호
	name VARCHAR2(20),
	email VARCHAR2(20),
	zip_num VARCHAR2(10),	-- 비회원 우편번호
	address VARCHAR2(100)
);
SELECT * FROM nonmember;

/*
DROP TABLE bookproduct CASCADE constraints;
CREATE TABLE bookproduct(
	bseq NUMBER(5) NOT NULL PRIMARY KEY,	-- 책번호
	bname VARCHAR2(100) NOT NULL,		-- 책이름
	writer VARCHAR2(50), -- 작가
	byear NUMBER(10),	-- 출판년도
	kind CHAR(1),	-- local or global l g
	price NUMBER(7),		-- 가격
	publisher VARCHAR2(60), -- 출판사
	genre VARCHAR2(60), -- 장르
	content VARCHAR2(1000),	-- 책 내용설명
	image VARCHAR2(50),	-- 책 이미지
	useyn CHAR(1) DEFAULT 'y',     -- 상품 판매 유효 여부
	bestyn CHAR(1) DEFAULT 'n',   -- 베스트상품 진열 여부
	indate DATE DEFAULT sysdate    -- 등록일
);
SELECT * FROM bookproduct;
*/
-- 220217
DROP TABLE bookproduct CASCADE constraints;
CREATE TABLE bookproduct(
	bseq NUMBER(5) NOT NULL PRIMARY KEY,
	bname VARCHAR2(100) NOT NULL,	
	writer VARCHAR2(100), 
	publisher VARCHAR2(100), 
	byear VARCHAR2(40),
	price NUMBER(10),
	content VARCHAR2(4000),	
	kind CHAR(1),	
	genre VARCHAR2(60), 
	image VARCHAR2(50),	
	useyn CHAR(1) DEFAULT 'y',  
	bestyn CHAR(1) DEFAULT 'n',
	indate DATE DEFAULT sysdate 
);
SELECT * FROM bookproduct;

DROP SEQUENCE bookproduct_seq;
CREATE SEQUENCE bookproduct_seq INCREMENT BY 1 START WITH 1 NOCACHE;
SELECT bookproduct_seq.currVal, bookproduct_seq.nextVal FROM dual;

-- 220218 review indate 추가
DROP TABLE review CASCADE constraints;
CREATE TABLE review (
	rseq NUMBER(5) NOT NULL PRIMARY KEY,
	bseq NUMBER(5) NOT NULL REFERENCES bookproduct(bseq),
	id VARCHAR2(20) NOT NULL REFERENCES member(id),
	content VARCHAR2(1000),
	score  CHAR(1) DEFAULT '3',
	indate DATE DEFAULT sysdate 
);
SELECT * FROM review;

DROP SEQUENCE review_seq;
CREATE SEQUENCE review_seq INCREMENT BY 1 START WITH 1 NOCACHE;
SELECT review_seq.currVal, review_seq.nextVal FROM dual;


DROP TABLE worker CASCADE constraints;
CREATE TABLE worker (
	id VARCHAR2(20) NOT NULL PRIMARY KEY,
	pwd VARCHAR2(20) NOT NULL,
	name VARCHAR2(20) NOT NULL,
	phone VARCHAR2(20) NOT NULL
);
SELECT * FROM worker;


DROP TABLE cart CASCADE CONSTRAINTS;
CREATE TABLE cart(
	cseq NUMBER(10) PRIMARY KEY,
	id VARCHAR2(20) REFERENCES member(id),
	bseq NUMBER(10) REFERENCES bookproduct(bseq),
	quantity NUMBER(5) DEFAULT 1,
	result CHAR(1) DEFAULT '1',
	indate DATE DEFAULT sysdate
);
SELECT * FROM cart;

DROP SEQUENCE cart_seq;
CREATE SEQUENCE cart_seq INCREMENT BY 1 START WITH 1 NOCACHE;
SELECT cart_seq.currVal, cart_seq.nextVal FROM dual;

-- member orders
DROP TABLE m_orders CASCADE CONSTRAINTS;
CREATE TABLE m_orders(
	oseq NUMBER(10) PRIMARY KEY,
	id VARCHAR2(20) REFERENCES member(id),
	indate DATE DEFAULT sysdate
);
SELECT * FROM m_orders;

DROP SEQUENCE m_orders_seq;
CREATE SEQUENCE m_orders_seq INCREMENT BY 1 START WITH 1 NOCACHE;
SELECT m_orders_seq.currVal, m_orders_seq.nextVal FROM dual;

-- nonmember orders
DROP TABLE nm_orders CASCADE CONSTRAINTS;
CREATE TABLE nm_orders(
	oseq NUMBER(10) PRIMARY KEY,
	phone VARCHAR2(20) REFERENCES nonmember(phone),
	indate DATE DEFAULT sysdate
);
SELECT * FROM nm_orders;

DROP SEQUENCE nm_orders_seq;
CREATE SEQUENCE nm_orders_seq INCREMENT BY 1 START WITH 1 NOCACHE;
SELECT nm_orders_seq.currVal, nm_orders_seq.nextVal FROM dual;

-- 회원 주문 상세
DROP TABLE m_order_detail CASCADE CONSTRAINTS;
CREATE TABLE m_order_detail(
	odseq NUMBER(10) PRIMARY KEY,		-- 주문 상세번호
	oseq NUMBER(10) REFERENCES m_orders(oseq),	-- 주문번호
	bseq NUMBER(5) REFERENCES bookproduct(bseq),	-- 상품번호
	result CHAR(1) DEFAULT '1',	-- 주문 처리 상황 1:미처리 2:처리 
	quantity NUMBER(5) DEFAULT 1		-- 주문 수량
);
SELECT * FROM m_order_detail;

DROP SEQUENCE m_order_detail_seq;
CREATE SEQUENCE m_order_detail_seq INCREMENT BY 1 START WITH 1 NOCACHE;
SELECT m_order_detail_seq.currVal, m_order_detail_seq.nextVal FROM dual;

-- 비회원 주문 상세
DROP TABLE nm_order_detail CASCADE CONSTRAINTS;
CREATE TABLE nm_order_detail(
	odseq NUMBER(10) PRIMARY KEY,		-- 주문 상세번호
	oseq NUMBER(10) REFERENCES nm_orders(oseq),	-- 주문번호
	bseq NUMBER(5) REFERENCES bookproduct(bseq),	-- 상품번호
	result CHAR(1) DEFAULT '1',	-- 주문 처리 상황 1:미처리 2:처리 
	quantity NUMBER(5) DEFAULT 1		-- 주문 수량
);
SELECT * FROM nm_order_detail;

DROP SEQUENCE nm_order_detail_seq;
CREATE SEQUENCE nm_order_detail_seq INCREMENT BY 1 START WITH 1 NOCACHE;
SELECT nm_order_detail_seq.currVal, nm_order_detail_seq.nextVal FROM dual;


DROP TABLE qna CASCADE CONSTRAINTS;
CREATE TABLE qna(
	qseq NUMBER(10) PRIMARY KEY,
	subject VARCHAR2(50),
	content VARCHAR2(1000),
	reply VARCHAR2(1000),
	id VARCHAR2(20) REFERENCES member(id),
	rep CHAR(1) DEFAULT '1', -- 답변 여부
	indate DATE DEFAULT sysdate
);
SELECT * FROM qna;

DROP SEQUENCE qna_seq;
CREATE SEQUENCE qna_seq INCREMENT BY 1 START WITH 1 NOCACHE;
SELECT qna_seq.currVal, qna_seq.nextVal FROM dual;


-- select
SELECT * FROM member;
SELECT * FROM nonmember;
SELECT * FROM bookproduct;
SELECT * FROM review;
SELECT * FROM worker;
SELECT * FROM cart;
SELECT * FROM m_orders;
SELECT * FROM nm_orders;
SELECT * FROM m_orders;
SELECT * FROM nm_orders;
SELECT * FROM qna;


-- seq
SELECT bookproduct_seq.currVal, bookproduct_seq.nextVal FROM dual;
SELECT review_seq.currVal, review_seq.nextVal FROM dual;
SELECT cart_seq.currVal, cart_seq.nextVal FROM dual;
SELECT m_orders_seq.currVal, m_orders_seq.nextVal FROM dual;
SELECT nm_orders_seq.currVal, nm_orders_seq.nextVal FROM dual;
SELECT qna_seq.currVal, qna_seq.nextVal FROM dual

-- drop
DROP SEQUENCE bookproduct_seq;
DROP SEQUENCE review_seq;
DROP SEQUENCE cart_seq;
DROP SEQUENCE m_orders_seq;
DROP SEQUENCE nm_orders_seq;
DROP SEQUENCE qna_seq;