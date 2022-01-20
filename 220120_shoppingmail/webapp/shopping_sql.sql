SELECT * FROM member;
SELECT * FROM mem;
SELECT * FROM product;
SELECT * FROM worker;

--DROP TABLE member CASCADE CONSTARINTS;
DROP TABLE product CASCADE CONSTARINTS;
DROP TABLE worker CASCADE CONSTARINTS;
DROP TABLE worker CASCADE CONSTARINTS;
DROP TABLE product;

-- member 테이블 : 상품을 구매하기 위해서 회원으로 가입한 구매자들.
CREATE TABLE shopmem(
	id VARCHAR2(20) NOT NULL,
	pwd VARCHAR2(20) NOT NULL,
	name VARCHAR2(20) NOT NULL,
	email VARCHAR2(40) NOT NULL,
	zip_num VARCHAR2(10) NOT NULL,
	address VARCHAR2(100) NOT NULL,
	phone VARCHAR2(20) NOT NULL,
	useyn CHAR(1) DEFAULT 'y',  -- 휴면 계정 여부
	indate DATE DEFAULT sysdate,
	PRIMARY KEY(id)
);

SELECT * FROM shopmem;
--  상품
CREATE TABLE shopproduct(
	pseq NUMBER(5) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	kind CHAR(1) NOT NULL,
	price1 NUMBER(7), -- 원가
	price2 NUMBER(7), -- 판매가
	price3 NUMBER(7), -- 마진
	content VARCHAR2(1000),
	image VARCHAR2(50),
	useyn CHAR(1) DEFAULT 'y', -- 상품 판매 유효 여부
	bestyn CHAR(1) DEFAULT 'n', -- 베스트상품 진열 여부
	indate DATE DEFAULT sysdate, -- 등록일
	PRIMARY KEY(pseq)
);

DROP sequence product_seq;

CREATE sequence product_seq START WITH 1;

SELECT * FROM shopproduct;

-- 쇼핑몰 관리자 테이블
CREATE TABLE worker(
	id VARCHAR2(20) NOT NULL,
	pwd VARCHAR2(20) NOT NULL,
	name VARCHAR2(20) NOT NULL,
	phone VARCHAR2(20) NOT NULL,
	PRIMARY KEY(id)
);

SELECT * FROM worker;



-- 장바구니
ALTER TABLE cart DROP PRIMARY KEY CASCADE;
-- 기본키를 삭제하되, 다른 테이블에서 참조하고 있다면 그레코드도 같이 삭제합니다
DROP TABLE cart purge;

CREATE TABLE cart(
	cseq NUMBER(10) PRIMARY KEY, -- 장바구니 일련번호
	id VARCHAR2(16) REFERENCES shopmem(id), -- 주문자 아이디 (FK : shopmem.id) 
	pseq NUMBER(5) REFERENCES shopproduct(pseq), -- 주문 상품번호(FK : shopproduct.pseq)
	quantity NUMBER(5) DEFAULT 1, --  주문 수량
	result CHAR(1) DEFAULT '1', -- 1 : 미처리(카트에 담긴 상태, 주문전), 2: 처리(주문완료)
	indate DATE DEFAULT sysdate -- 장바구니에 담은 날짜
);

DROP sequence cart_seq;
CREATE SEQUENCE cart_seq START WITH 1;

SELECT * FROM cart;




-- 주문 테이블 
-- orders 테이블과  order_detail 테이블로 나뉩니다

-- orders 테이블에는 한번에 주문에 필요한 주문자 아이디와 시퀀스에서 부여받은 주문번호 그리고 주문 일자만 저장됩니다
-- 한번의 주문에 두개이상의 상품을 같이 주문할 수 있기 때문입니다
-- 자세한 상품 주문 내역은 order_detail 에 저장됩니다. 이 때 orders 에 있는 주문번호 (oseq) 가 각 주문 상품에 같이 저장됩니다.
ALTER TABLE orders DROP PRIMARY KEY CASCADE;
DROP TABLE orders purge;

CREATE TABLE orders(
	oseq NUMBER(10) PRIMARY KEY, -- 주문번호
	id VARCHAR2(16) REFERENCES shopmem(id), -- 주문자 아이디
	indate DATE DEFAULT sysdate -- 주문일
);

DROP sequence orders_seq;
CREATE sequence orders_seq START WITH 1;

SELECT * FROM orders;


-- order_detail 테이블
ALTER TABLE order_detail DROP PRIMARY KEY CASCADE;
DROP TABLE order_detail purge;
 
CREATE TABLE order_detail(
	odseq NUMBER(10) PRIMARY KEY, -- 주문 상세번호
	oseq NUMBER(10) REFERENCES orders(oseq), -- orders 테이블에 추가된 주문번호
	pseq NUMBER(5) REFERENCES shopproduct(pseq), -- 상품번호
	quantity NUMBER(5) DEFAULT 1, -- 주문수량
	result CHAR(1) DEFAULT '1' -- 1: 미처리 2: 처리
);

DROP SEQUENCE order_detail_seq;
CREATE SEQUENCE order_detail_seq START WITH 1;

SELECT * FROM order_detail;


ALTER TABLE address DROP PRIMARY KEY CASCADE;
DROP TABLE address purge;
CREATE TABLE address(
	zip_num VARCHAR2(7) NOT NULL,
	sido VARCHAR2(30) NOT NULL,
	gugun VARCHAR2(30) NOT NULL,
	dong VARCHAR2(100) NOT NULL,
	zip_code  VARCHAR2(30),
	bunji VARCHAR2(30)
);

SELECT * FROM address;


ALTER TABLE qna DROP PRIMARY KEY CASCADE;
DROP TABLE qna purge;

CREATE TABLE qna(
	qseq NUMBER(5) PRIMARY KEY, -- 글번호
	subject VARCHAR2(300), -- 제목
	content VARCHAR2(1000), -- 문의내용
	reply VARCHAR2(1000), -- 답변내용
	id VARCHAR2(20), -- 작성자(FK : shopmem.id)
	rep CHAR(1) DEFAULT '1', -- 1:답변 무 2: 답변 유
	indate DATE DEFAULT sysdate -- 작성일
);

DROP sequence qna_seq;
CREATE sequence qna_seq START WITH 1;

SELECT * FROM qna;


SELECT * FROM shopmem;
SELECT * FROM shopproduct;
SELECT * FROM worker;
SELECT * FROM cart;
SELECT * FROM orders;
SELECT * FROM order_datail;
SELECT * FROM address;
SELECT * FROM qna;


--------------------- 샘플 데이터 입력 --------------------- 

-- 관리자 입력
INSERT INTO worker VALUES('admin', 'admin', '관리자', '010-8888-8888');
INSERT INTO worker VALUES('scott', 'tiger', '가나다', '010-3333-3333');

-- 회원 입력
INSERT INTO shopmem(id, pwd, name, zip_num, address, phone, email)
	VALUES('one', '1111', '노지선', '133-110', '서울시 성동구 성수동1가 1번지21호', '010-2333-2333', 'noline@naver.com');
INSERT INTO shopmem(id, pwd, name, zip_num, address, phone, email)
	VALUES('two', '2222', '이서연', '133-120', '서울시 송파구 잠실2동 리센츠 아파트 111동 222호', '010-4444-3333', 'leesy@naver.com');


-- 상품 입력
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image)
	VALUES(product_seq.nextVal, '저소음 벽시계', '1', 14000, 20000, 6000, '아트라운딩 저소음 벽시계', 'c1.jpg');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image, bestyn)
	VALUES(product_seq.nextVal, '미니 벽시계', '2', 24000, 30000, 6000, '무아스 퓨어 미니 벽시계', 'c2.jpg', 'y');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image, bestyn)
	VALUES(product_seq.nextVal, '플랫우드 벽시계', '1', 13000, 20000, 7000, '무아스 플랫우드 벽시계', 'c3.jpg', 'y');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image, bestyn)
	VALUES(product_seq.nextVal, '팝 미러클락', '4', 30000, 40000, 10000, '무아스 LED 팝 미러클락 탁상 시계', 'c4.jpg', 'y');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image, bestyn)
	VALUES(product_seq.nextVal, '탁상 겸용 시계', '5', 3000, 4000, 1000, 'OWC 무소음 벽 탁상 겸용 시계', 'c5.jpg', 'n');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image, bestyn)
	VALUES(product_seq.nextVal, '대형 벽시계', '6', 50000, 60000, 10000, '아트캄보 무소음 대형 벽시계', 'c6.jpg', 'n');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image, bestyn)
	VALUES(product_seq.nextVal, '모던샤인 벽시계', '1', 17000, 20000, 3000, '모던샤인 무소음 벽시계', 'c7.jpg', 'n');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image, bestyn)
	VALUES(product_seq.nextVal, '황금나무 벽시계', '1', 19000, 20000, 1000, '황금나무 벽시계 골드', 'c8.jpg', 'n');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image)
	VALUES(product_seq.nextVal, '직사각형 탁상시계', '3', 11000, 13000, 2000, '무아스 LED 미러클락 직사각형 탁상시계', 'c9.jpg');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image)
	VALUES(product_seq.nextVal, '사슴 저소음 추시계', '5', 20000, 25000, 5000, '아트프린스 노르딕 사슴 저소음 추시계', 'c10.jpg');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image)
	VALUES(product_seq.nextVal, '우든패턴 대형 벽시계', '5', 16000, 20000, 4000, '휴트리 우든패턴 무소음 대형 벽시계', 'c11.jpg');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image)
	VALUES(product_seq.nextVal, '플립 탁상시계', '3', 24000, 30000, 6000, '무아스 플립 탁상시계', 'c12.jpg');
INSERT INTO shopproduct(pseq, name, kind, price1, price2, price3, content, image)
	VALUES(product_seq.nextVal, '럭셔리 벽시계', '5', 44000, 48000, 4000, '파인블루 무소음 럭셔리 벽시계', 'c13.jpg');

	
	
	
-- 카트 추가
INSERT INTO cart(cseq, id, pseq, quantity) VALUES(cart_seq.nextVal, 'one', 1, 1); -- id : one 사용자가 1번 상품 1개를 카트에 추가
INSERT INTO cart(cseq, id, pseq, quantity) VALUES(cart_seq.nextVal, 'two', 2, 1); 

-- orders 와 order_detail 추가
INSERT INTO orders(oseq, id) VALUES(orders_seq.nextVal, 'one');
SELECT * FROM	orders;
SELECT MAX(oseq) FROM orders;

INSERT INTO order_detail(odseq, oseq, pseq, quantity) 
	VALUES(order_detail_seq.nextVal, 1, 1, 1);
INSERT INTO order_detail(odseq, oseq, pseq, quantity) 
	VALUES(order_detail_seq.nextVal, 1, 2, 2);
	

INSERT INTO orders(oseq, id) VALUES(orders_seq.nextVal, 'two');
SELECT MAX(oseq) FROM orders;

INSERT INTO order_detail(odseq, oseq, pseq, quantity) 
	VALUES(order_detail_seq.nextVal, 2, 4, 3);
INSERT INTO order_detail(odseq, oseq, pseq, quantity) 
	VALUES(order_detail_seq.nextVal, 2, 5, 2);	
	
	
INSERT INTO orders(oseq, id) VALUES(orders_seq.nextVal, 'one');
SELECT * FROM	orders;
SELECT MAX(oseq) FROM orders;

INSERT INTO order_detail(odseq, oseq, pseq, quantity) 
	VALUES(order_detail_seq.nextVal, 3, 3, 1);
INSERT INTO order_detail(odseq, oseq, pseq, quantity) 
	VALUES(order_detail_seq.nextVal, 3, 2, 1);

-- Qna 추가
INSERT INTO qna(qseq, subject, content, id)
	VALUES(qna_seq.nextval, '배송관련 문의입니다', '현재 배송상태와 예상 배송일을 답변 부탁드립니다.', 'one');
INSERT INTO qna(qseq, subject, content, id)
	VALUES(qna_seq.nextval, '환불관련', '환불절차 부탁드려요 배송사 선택은 어떻게 되는지도', 'one');
INSERT INTO qna(qseq, subject, content, id)
	VALUES(qna_seq.nextval, '사이즈 교환 하고 싶어요', '사이즈가 예상보다 작습니다 교환 절차를 부탁드려요.', 'two');
INSERT INTO qna(qseq, subject, content, id)
	VALUES(qna_seq.nextval, '배송이 많이 지연되고 있습니다', '언제 받을 수 있나요', 'scott');
INSERT INTO qna(qseq, subject, content, id)
	VALUES(qna_seq.nextval, '불량품 교환 문의', '교환 또는 환불 등의 안내가 필요합니다', 'scott');

	
-- cart 안의 상품번호와 사용자 아이디로 상품이름과 사용자 이름을 함께 조회하는 view를 생성합니다
SELECT * FROM cart;
	
CREATE OR REPLACE VIEW cart_view 
AS
SELECT c.cseq, c.id, m.name AS mname, c.pseq, p.name AS pname, c.quantity, p.price2, c.result, c.indate
FROM cart c, shopproduct p, shopmem m
WHERE c.pseq = p.pseq AND c.id = m.id;

SELECT * FROM cart_view;



-- orders 와 order_detail 의 join 으로 
-- 1. 주문번호(oseq)에 따른 주문상품들의 표시 
-- 2. 상품번호에 따른 상품 이름과 가격등의 정보 표시
-- 3. 아이디에 따른 고객 이름과 배송주소 등의 정보 표시

CREATE OR REPLACE VIEW order_view
AS
SELECT d.odseq, o.oseq, o.indate, o.id, 
			m.name AS mname, m.zip_num, m.address, m.phone, 
			d.pseq, p.name AS pname, p.price2, d.quantity, d.result
FROM orders o, order_detail d, shopmem m, shopproduct p
WHERE o.oseq = d.oseq AND o.id = m.id AND d.pseq = p.pseq;

SELECT * FROM order_view;



-- 신상품 View 생성 
DROP VIEW new_pro_view;

CREATE OR REPLACE VIEW new_pro_view
AS
SELECT * FROM 
(SELECT rownum, pseq, name, price2, image
FROM shopproduct
WHERE useyn='y'
ORDER BY indate DESC)
WHERE rownum <= 4;

SELECT * FROM new_pro_view;
SELECT * FROM shopproduct;

UPDATE shopproduct SET bestyn='y' WHERE pseq=11;

-- 베스트 상품 View 생성
DROP VIEW best_pro_view;

CREATE OR REPLACE VIEW best_pro_view
AS
SELECT * FROM
(SELECT rownum, pseq, name, price2, image
FROM shopproduct
WHERE bestyn='y'
ORDER BY indate DESC)
WHERE rownum <= 4;

SELECT * FROM best_pro_view;

SELECT * FROM address;
SELECT COUNT(*) FROM address;


insert into shopproduct(pseq, name, kind, price1, price2, price3, content, image) 
values(product_seq.nextval, '크로그다일부츠', '2', 40000, 50000, 10000, '오리지날 크로그다일부츠 입니다.', 'w2.jpg');

insert into shopproduct(pseq, name, kind, price1, price2, price3, content, image, bestyn) 
values(product_seq.nextval, '롱부츠', '2', 40000, 50000, 10000, '따뜻한 롱부츠 입니다.', 'w-28.jpg', 'n');
insert into shopproduct(pseq,  name, kind, price1, price2, price3, content, image, bestyn) 
values(product_seq.nextval, '힐', '1', 10000, 12000, 2000, '여성용전용 힐', 'w-26.jpg', 'n');
insert into shopproduct(pseq,  name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '슬리퍼', '4', 5000, 5500, 500, '편안한 슬리퍼입니다.', 'w-25.jpg', 'y');
insert into shopproduct(pseq,  name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '회색힐', '1', 10000, 12000, 2000, '여성용전용 힐', 'w9.jpg', 'n');
insert into shopproduct(pseq,  name, kind, price1, price2, price3, content, image) 
values(product_seq.nextval, '여성부츠', '2', 12000, 18000, 6000, '여성용 부츠', 'w4.jpg');
insert into shopproduct(pseq,  name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval,  '핑크샌달', '3', 5000, 5500, 500, '사계절용 샌달입니다.', 'w-10.jpg', 'y');
insert into shopproduct(pseq,  name, kind, price1, price2, price3, content, image, bestyn)
values(product_seq.nextval, '슬리퍼', '3', 5000, 5500, 500, '편안한 슬리퍼입니다.', 'w11.jpg', 'y');
insert into shopproduct(pseq,  name, kind, price1, price2, price3, content, image) 
values( product_seq.nextval,  '스니커즈', '4', 15000, 20000, 5000, '활동성이 좋은 스니커즈입니다.', 'w1.jpg');
insert into shopproduct(pseq,  name, kind, price1, price2, price3, content, image, bestyn)
values( product_seq.nextval,  '샌달', '3', 5000, 5500, 500,'사계절용 샌달입니다.', 'w-09.jpg','n');
insert into shopproduct(pseq,  name, kind, price1, price2, price3, content, image,bestyn)
values( product_seq.nextval,  '스니커즈', '5', 15000, 20000, 5000,'활동성이 좋은 스니커즈입니다.', 'w-05.jpg','y');	

--SELECT product_seq.nextVal, product_seq.currVal FROM dual;
--
--DELETE FROM shopproduct WHERE price2 LIKE '%0%';
--DELETE FROM shopproduct WHERE kind LIKE '%0%';
--	
SELECT * FROM shopproduct;
UPDATE shopproduct SET pseq=product_seq.nextVal, name='크로그다일부츠', kind='2', 
content= '오리지날 크로그다일부츠 입니다.', image='w2.jpg'  WHERE pseq=1;
	
UPDATE shopproduct SET pseq=product_seq.nextVal, name='롱부츠', kind='2', 
content= '따뜻한 롱부츠 입니다', image='w-28.jpg'  WHERE pseq=2;
UPDATE shopproduct SET pseq=product_seq.nextVal, name='힐', kind='1', 
content= '여성용전용 힐', image='w-26.jpg'  WHERE pseq=3;
UPDATE shopproduct SET pseq=product_seq.nextVal, name='슬리퍼', kind='4', 
content= '편안한 슬리퍼입니다.', image='w-25.jpg'  WHERE pseq=4;
UPDATE shopproduct SET pseq=product_seq.nextVal, name='회색힐', kind='1', 
content= '여성용전용 힐', image='w9.jpg'  WHERE pseq=5;
UPDATE shopproduct SET pseq=product_seq.nextVal, name='여성부츠', kind='2', 
content= '여성용 부츠', image='w4.jpg'  WHERE pseq=6;
UPDATE shopproduct SET pseq=product_seq.nextVal, name='핑크샌달', kind='3', 
content= '사계절용 샌달입니다.', image='w-10.jpg'  WHERE pseq=7;
UPDATE shopproduct SET pseq=product_seq.nextVal, name='슬리퍼', kind='3', 
content= '편안한 슬리퍼입니다', image='w11.jpg'  WHERE pseq=8;
UPDATE shopproduct SET pseq=product_seq.nextVal, name='스니커즈', kind='4', 
content= '활동성이 좋은 스니커즈입니다', image='w1.jpg'  WHERE pseq=9;
UPDATE shopproduct SET pseq=product_seq.nextVal, name='샌달', kind='3', 
content= '사계절용 샌달입니다', image='w-09.jpg'  WHERE pseq=10;
UPDATE shopproduct SET pseq=product_seq.nextVal, name='스니커즈', kind='5', 
content= '활동성이 좋은 스니커즈입니다', image='w-05.jpg'  WHERE pseq=11;

DELETE FROM shopproduct WHERE pseq=12;
DELETE FROM shopproduct WHERE pseq=13;




SELECT * FROM shopmem;
SELECT * FROM shopproduct;
SELECT * FROM worker;
SELECT * FROM cart;
SELECT * FROM cart_view;
SELECT * FROM order_view;
SELECT * FROM orders;
SELECT * FROM order_detail;
SELECT * FROM address;
SELECT * FROM qna;
