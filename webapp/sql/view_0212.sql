SELECT * FROM best_pro_view;
SELECT * FROM new_pro_view;
SELECT * FROM bestList;

CREATE OR REPLACE VIEW best_pro_view
AS
SELECT * FROM
(SELECT rownum, bseq, bname, price, image, writer
FROM bookproduct
WHERE bestyn='y'
ORDER BY indate DESC)
WHERE rownum <= 8;

CREATE OR REPLACE VIEW new_pro_view
AS
SELECT * FROM 
(SELECT rownum, bseq, bname, price, image, writer
FROM bookproduct
WHERE useyn='y'
ORDER BY indate DESC)
WHERE rownum <= 8;


CREATE OR REPLACE VIEW bestviewList
AS
SELECT * FROM
	(SELECT rownum AS rn, best.* FROM
		((SELECT * FROM bookproduct WHERE bestyn='y' ORDER BY indate DESC) best)
	WHERE rownum <= 21);
	
SELECT * FROM bestviewList;
-- bestoneList
SELECT * FROM bestviewList WHERE rn = 1;
-- bestviewList
SELECT * FROM bestviewList WHERE rn > 1;


CREATE OR REPLACE VIEW newviewList
AS
SELECT * FROM
	(SELECT rownum AS rn, new.* FROM
		((SELECT * FROM bookproduct WHERE useyn='y' ORDER BY indate DESC) new)
	WHERE rownum <= 21);
	
SELECT * FROM newviewList;
-- newoneList
SELECT * FROM newviewList WHERE rn = 1;
-- newviewList
SELECT * FROM newviewList WHERE rn > 1;

--paging
SELECT * FROM localviewList ;
SELECT * FROM localviewList;

select * from (
select rownum as rn, p.* from
((select * from product  where name like '%'||?||'%'  order by pseq desc) p)
) where rn>=?
) where rn<=?

-- localview List
CREATE OR REPLACE VIEW localviewList
AS
SELECT * FROM bookproduct WHERE kind='l' ORDER BY bseq DESC;

SELECT * FROM localviewList;

-- globalview List
CREATE OR REPLACE VIEW globalviewList
AS
SELECT * FROM bookproduct WHERE kind='g' ORDER BY bseq DESC;

SELECT * FROM globalviewList;




