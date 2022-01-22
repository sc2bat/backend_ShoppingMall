
-- 회원
CREATE TABLE wmem(
	id VARCHAR2(30) NOT NULL PRIMARY KEY,
	pwd VARCHAR2(30) NOT NULL,
	name VARCHAR2(30) NOT NULL,
	email VARCHAR2(30) NOT NULL,
	zip_num VARCHAR2(20) NOT NULL,
	address VARCHAR2(100) NOT NULL,
	phone VARCHAR2(30) NOT NULL,
	useyn CHAR(1) DEFAULT 'y',
	indate DATE DEFAULT sysdate
);

-- 상품
CREATE TABLE wproduct(
	pseq NUMBER(10) NOT NULL PRIMARY KEY,
	name VARCHAR2(100) NOT NULL,
	kind CHAR(3) NOT NULL,
	price_b NUMBER(10),
	price_s NUMBER(10),
	price_dc NUMBER(10),
	content VARCHAR2(1000),
	image VARCHAR2(50),
	useyn CHAR(1) DEFAULT 'y',
	bestyn CHAR(1) DEFAULT 'n',
	indate DATE DEFAULT sysdate
);

-- 관리자
CREATE TABLE wadmin(
	id VARCHAR2(20) NOT NULL PRIMARY KEY,
	pwd VARCHAR2(20) NOT NULL,
	name VARCHAR2(20) NOT NULL, 
	phone VARCHAR2(20) NOT NULL
);

-- 장바구니
CREATE TABLE wcart(
	cseq NUMBER(10) PRIMARY KEY,
	id VARCHAR2(30) REFERENCES wmem(id),
	pseq NUMBER(10) REFERENCES wproduct(pseq),
	quantity NUMBER(5) DEFAULT 1,
	result CHAR(1) DEFAULT '1',
	indate DATE DEFAULT sysdate
);

-- 주문
CREATE TABLE worders(
	oseq NUMBER(10) PRIMARY KEY,
	id VARCHAR2(30) REFERENCES wmem(id),
	indate DATE DEFAULT sysdate
);

-- 주문 상세내역
CREATE TABLE wo_detail(
	odseq NUMBER(10) PRIMARY KEY,
	oseq NUMBER(10) REFERENCES worders(oseq),
	pseq NUMBER(10) REFERENCES wproduct(pseq),
	quantity NUMBER(5) DEFAULT 1,
	result CHAR(1) DEFAULT '1'
);

-- 주소
CREATE TABLE address(
	zip_num VARCHAR2(10) NOT NULL, 
	sido VARCHAR2(30) NOT NULL, 
	gugun VARCHAR2(30) NOT NULL,
	dong VARCHAR2(100) NOT NULL,
	zip_code VARCHAR2(30),
	bunji VARCHAR2(30),
);

-- qna 
CREATE TABLE wqna(
	qseq NUMBER(5) PRIMARY KEY, 
	subject VARCHAR2(300),
	content VARCHAR2(1000),
	reply VARCHAR2(1000),
	id VARCHAR2(30),
	rep CHAR(1) DEFAULT 'n',
	indate DATE DEFAULT sysdate
);

--관리자 추가
INSERT INTO wadmin VALUES('admin', 'admin', '관리자', '010-0000-0000');
INSERT INTO wadmin VALUES('scott', 'tiger', '가나다', '010-1111-1111');

--회원 추가
--id pwd name email zip_num address phone
INSERT INTO wmem(id, pwd, name, email, zip_num, address, phone)
	VALUES('rose', '1234', '노지선', 'f9_noline@naver.com', '124-124', '서울시 가나다 가나동1가 1000', '010-3333-3333');
INSERT INTO wmem(id, pwd, name, email, zip_num, address, phone)
	VALUES('chang', '1234', '이채영', 'f9_chang@naver.com', '124-124', '서울시 파랑 로소3가 30', '010-2222-2222');

--상품 추가
--pseq name kind price_b price_s price_dc content image useyn bestyn indate
-- 1 손목시계 2 탁상시계 3 벽시계 4 LED 시계 5 애플워치 6 갤럭시워치
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '카시오손목시계', '1', '27000', '25000', '2000', '손목 전자시계 F모델', 'w1_1.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '메탈손목시계', '1', '70000', '69000', '1000', '니바다 남성용 멀티펑션 메탈 손목시계', 'w1_2.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '저소음손목시계', '1', '21000', '16100', '4900', '저소음 큰 숫자 수험생 오르네 ORNE 수능시계', 'w1_3.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '전자손목시계', '1', '27000', '25000', '2000', '프레시오 스포츠방수 전자손목시계', 'w1_4.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '스마트손목시계', '1', '30000', '24000', '6000', '스트로만 스마트워치 SL1', 'w1_5.png', 'n');
	
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '트윈벨알람탁상시계', '2', '17500', '15000', '2500', '오리엔트 저소음 스노우엔틱 트윈벨알람 탁상시계', 'w2_1.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '오리엔트탁상시계', '2', '12500', '10000', '2500', '오리엔트 벽탁상겸용 인테리어시계', 'w2_2.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '심플탁상시계', '2', '16500', '15500', '1000', '서운아트 심플 교육용 탁상시계', 'w2_3.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '모던탁상시계', '2', '20000', '16000', '4000', '플라이토 모던 무소음 탁상 벽시계 17cm', 'w2_4.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '무소음탁상시계', '2', '12400', '12000', '400', '묵스 심블 무소음 탁상시계', 'w2_5.png', 'n');
	
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '국 벽시계', '3', '30000', '20000', '10000', '진성산업 무소음 국민 벽시계', 'w3_1.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '무소음벽시계', '3', '10000', '9500', '500', '오리엔트 무소음 라운드엣지 벽시계 ', 'w3_2.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '대형벽시계', '3', '22000', '16000', '6000', '휴트리 우든패턴 무소음 대형 벽시계', 'w3_3.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '모던벽시계', '3', '10000', '9500', '500', 'MJK 모던샤인 무소음 벽시계', 'w3_4.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '메탈벽시계', '3', '24000', '20000', '4000', '오리엔트 무소음 로즈골드핸즈링 메탈 인테리어벽시계', 'w3_5.png', 'n');
	
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '오리엔트LED 시계', '4', '50000', '45000', '5000', '오리엔트 OWC 미드나잇 무드조명 LED 탁상시계', 'w4_1.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '무아스LED 시계', '4', '18000', '14000', '4000', '무아스 퓨어 미니 LED 벽시계', 'w4_2.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '홈플래닛LED 시계', '4', '40000', '25000', '15000', '홈플래닛 리모컨 빅 3D LED 벽시계', 'w4_3.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '무아스LED 시계', '4', '40000', '37500', '2500', '무아스 3D LED벽시계 빅플러스', 'w4_4.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '무선충전LED 시계', '4', '30000', '25000', '5000', '오리엔트 클린 미러 LED 무선충전 디지털 탁상시계', 'w4_5.png', 'n');
	
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '애플워치3', '5', '260000', '230000', '30000', 'Apple 애플워치3 실버', 'w5_1.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '애플워치3', '5', '260000', '230000', '30000', 'Apple 애플워치3 스페이스그레이', 'w5_2.png', 'y');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '애플워치SE', '5', '360000', '350000', '10000', 'Apple 애플워치 SE', 'w5_3.png', 'y');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '애플워치7', '5', '1000000', '900000', '100000', 'Apple 애플워치 7 스테인리스 스틸 케이스 밀레니즈 루프', 'w5_4.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '애플워치7', '5', '1000000', '900000', '100000', 'Apple 애플워치 7 알루미늄 케이스 스포츠 밴드', 'w5_5.png', 'n');
	
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '갤럭시워치 44', '6', '300000', '250000', '50000', '삼성전자 갤럭시 워치 4 44mm', 'w6_1.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '갤럭시워치 핑크골드', '6', '250000', '200000', '50000', '삼성전자 갤럭시 워치 4 40mm 핑크골드', 'w6_2.png', 'y');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '갤럭시워치 실버', '6', '250000', '200000', '50000', '삼성전자 갤럭시 워치 4 40mm 실버', 'w6_3.png', 'y');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '갤럭시워치 블랙', '6', '250000', '200000', '50000', '삼성전자 갤럭시 워치 4 40mm 블랙', 'w6_4.png', 'n');
INSERT INTO wproduct(pseq, name, kind, price_b, price_s, price_dc, content, image, bestyn)
	VALUES(wp_seq.nextVal, '갤럭시워치 스트랩', '6', '10000', '5000', '5000', '모모켓 갤럭시워치 기어 액티브 20mm 호환 캐쥬얼레더 스트랩', 'w6_5.png', 'n');

-- 장바구니 추가
INSERT INTO wcart(cseq, id, pseq, quantity, result) VALUES(wc_seq.nextVal, 'rose', 3, 1, '1');
INSERT INTO wcart(cseq, id, pseq, quantity, result) VALUES(wc_seq.nextVal, 'rose', 3, 1, '1');
INSERT INTO wcart(cseq, id, pseq, quantity, result) VALUES(wc_seq.nextVal, 'rose', 10, 5, '2');
INSERT INTO wcart(cseq, id, pseq, quantity, result) VALUES(wc_seq.nextVal, 'rose', 11, 1, '1');
INSERT INTO wcart(cseq, id, pseq, quantity, result) VALUES(wc_seq.nextVal, 'chang', 3, 3, '2');
INSERT INTO wcart(cseq, id, pseq, quantity, result) VALUES(wc_seq.nextVal, 'chang', 4, 2, '1');

-- 주문 추가
INSERT INTO worders(oseq, id) VALUES(wo_seq.nextVal, 'rose');
INSERT INTO worders(oseq, id) VALUES(wo_seq.nextVal, 'rose');
INSERT INTO worders(oseq, id) VALUES(wo_seq.nextVal, 'rose');
SELECT * FROM worders;
SELECT MAX(oseq) FROM worders;
INSERT INTO wo_detail(odseq, oseq, pseq, quantity) VALUES(wo_d_seq.nextVal, 1, 3, 1);
INSERT INTO wo_detail(odseq, oseq, pseq, quantity) VALUES(wo_d_seq.nextVal, 2, 3, 1);
INSERT INTO wo_detail(odseq, oseq, pseq, quantity) VALUES(wo_d_seq.nextVal, 3, 10, 5);
INSERT INTO wo_detail(odseq, oseq, pseq, quantity) VALUES(wo_d_seq.nextVal, 4, 11, 1);
INSERT INTO wo_detail(odseq, oseq, pseq, quantity) VALUES(wo_d_seq.nextVal, 5, 3, 3);
INSERT INTO wo_detail(odseq, oseq, pseq, quantity) VALUES(wo_d_seq.nextVal, 6, 4, 2);

INSERT INTO worders(oseq, id) VALUES(wo_seq.nextVal, 'chang');
INSERT INTO worders(oseq, id) VALUES(wo_seq.nextVal, 'chang');
SELECT * FROM worders;

UPDATE worders SET id='rose' WHERE oseq=2;
UPDATE worders SET id='chang' WHERE oseq=5;

DELETE FROM worders WHERE oseq=7;

-- qna 추가
INSERT INTO qna(qseq, subject, content, id)
	VALUES(wq_seq.nextVal, '배송', '헌법시행 당시에 이 헌법에 의하여 새로 설치될', 'rose');
INSERT INTO qna(qseq, subject, content, id)
	VALUES(wq_seq.nextVal, '환불', '헌법시행 당시에 이 헌법에 의하여 새로 설치될', 'rose');
INSERT INTO qna(qseq, subject, content, id)
	VALUES(wq_seq.nextVal, '환불', ' 존속하며 그 직무를 행한다.', 'chang');
INSERT INTO qna(qseq, subject, content, id)
	VALUES(wq_seq.nextVal, '배송', '직무를 행하고 있는 기관', 'chang');
INSERT INTO qna(qseq, subject, content, id)
	VALUES(wq_seq.nextVal, '배송', '직무를 행하고 있는 기관', 'rose');

-- view
CREATE OR REPLACE VIEW wc_view
AS
SELECT wc.cseq, wc.id, wm.name AS mname, wc.pseq, wp.name AS pname, wc.quantity, wp.price_s, wc.result, wc.indate
FROM wcart wc, wproduct wp, wmem wm
WHERE wc.pseq = wp.pseq and wc.id = wm.id;

CREATE OR REPLACE VIEW wo_view
AS
SELECT wd.odseq, wo.oseq, wo.indate, wo.id, wm.name AS mname, wm.zip_num, wm.address, wm.phone,
			wd.pseq, wp.name AS pname, wp.price_s, wd.quantity, wd.result
FROM worders wo, wo_detail wd, wmem wm, wproduct wp
WHERE wo.oseq = wd.oseq AND wo.id = wm.id AND wd.pseq = wp.pseq;

CREATE OR REPLACE VIEW wnew_view
AS
SELECT * FROM
	(SELECT rownum, pseq, name, price_s, image FROM wproduct WHERE useyn='y' ORDER BY indate DESC)
WHERE rownum <= 4;

CREATE OR REPLACE VIEW wbest_view
AS
SELECT * FROM
	(SELECT rownum, pseq, name, price_s, image FROM wproduct WHERE bestyn='y' ORDER BY indate DESC)
WHERE rownum <= 4;

-- 시퀀스
DROP SEQUENCE wp_seq;
CREATE SEQUENCE wp_seq INCREMENT BY 1 START WITH 1 NOCACHE;

DROP SEQUENCE wc_seq;
CREATE SEQUENCE wc_seq INCREMENT BY 1 START WITH 1 NOCACHE;

CREATE SEQUENCE wo_seq INCREMENT BY 1 START WITH 1 NOCACHE;
CREATE SEQUENCE wo_d_seq INCREMENT BY 1 START WITH 1 NOCACHE;
CREATE SEQUENCE wq_seq INCREMENT BY 1 START WITH 1 NOCACHE;

DELETE FROM wmem WHERE id='test';



SELECT * FROM wmem;
SELECT * FROM wproduct;
SELECT * FROM wadmin;
SELECT * FROM wcart;
SELECT * FROM worders;
SELECT * FROM wo_detail;
SELECT * FROM address;
SELECT * FROM wqna;
SELECT * FROM wc_view;
SELECT * FROM wo_view;
SELECT * FROM wnew_view;
SELECT * FROM wbest_view;


