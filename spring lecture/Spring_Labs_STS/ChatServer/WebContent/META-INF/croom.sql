create table croom(
num number constraint croom_num_pk primary key,
u_id varchar2(34),
chat clob,
reip varchar2(45),
cdate date);
create sequence croom_seq
increment by 1
start with 1;