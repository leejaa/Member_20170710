-- String id,pw,ssn,name,regdate;
SELECT * from MEMBER;
INSERT INTO MEMBER(id,name,password,ssn,regdate)
VALUES('JOJO','조조','1','570619-1336491',SYSDATE);
SELECT COUNT(*) AS COUNT FROM MEMBER;
