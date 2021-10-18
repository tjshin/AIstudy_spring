CREATE TABLE userTBL ( 
  id        NUMBER(3)       NOT NULL,   -- 아이디 
  password  VARCHAR2(8)     NOT NULL,   -- 비밀번호 
  userName  VARCHAR2(20)    NOT NULL,   -- 회원이름 
  PRIMARY KEY (id)  
); 

--테이블 수정(질문)
alter table userTBL
modify id varchar2(8);


-- c(create, insert)

insert into userTBL (id, password, userName)
values('admin', '1234', 'kim');
insert into userTBL (id, password, userName)
values('user', '2354', 'lee');
insert into userTBL (id, password, userName)
values('tester', '5214', 'park');

--read(select) 조회
select * from userTBL
where id = 'admin';

--전체 목록
select * from userTBL
order by id desc;

--비번검증(cnt:1 인증 성공, cnt:0 인증 실패)
select count(id) as cnt
from userTBL
where id = 'admin'
and password = '1234';


delete from userTBL;

delete from userTBL where id = 'admin';
