SELECT table_name FROM all_tables;


SELECT * FROM information_schema.tables;

SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE='BASE TABLE';
SELECT * FROM sysobjects WHERE xtype='U';

Showing all table: show tables;

SELECT owner, table_name FROM all_tables;

SELECT owner, table_name FROM dba_tables;

SELECT * FROM bookproduct WHERE genre = 'edu' ORDER BY bseq DESC;












SELECT * FROM localviewList ;
SELECT * FROM localviewList;

select * from (
select rownum as rn, p.* from
((select * from product  where name like '%'||?||'%'  order by pseq desc) p)
) where rn>=?
) where rn<=?




CREATE OR REPLACE VIEW bestList
AS
SELECT * FROM
	(SELECT * FROM bookproduct WHERE bestyn='y' ORDER BY indate DESC)
WHERE rownum <= 21;


-- bestoneList
SELECT * FROM bestlist WHERE rownum = 1;
-- bestList
SELECT * FROM bestlist WHERE rownum > 1;

CREATE OR REPLACE VIEW bestviewList
AS
SELECT * FROM
	(SELECT rownum AS rn, best.* FROM
		((SELECT * FROM bookproduct WHERE bestyn='y' ORDER BY indate DESC) best)
	WHERE rownum <= 21);
	
SELECT * FROM bestviewList;

SELECT * FROM bestviewList WHERE rn > 10;
SELECT * FROM bestviewList WHERE rn > 1;
SELECT * FROM bestviewList WHERE rn = 1;


SELECT * FROM bestviewList;
SELECT * FROM review;

SELECT best.*, COUNT(r.rseq) AS rcnt, AVG(r.score) AS avg 
FROM (SELECT * FROM bestviewList WHERE rownum = 1) best, review r
WHERE best.bseq = r.bseq GROUP BY r.bseq;










SELECT COUNT(*) AS cnt FROM bookproduct WHERE bestyn='y';
SELECT COUNT(*) AS cnt FROM review r, member m WHERE r.id = m.id;
SELECT * FROM review;
SELECT * FROM bookproduct;