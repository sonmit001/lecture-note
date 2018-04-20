show databases;

create table member(
  id varchar(50) not null primary key,
  passwd varchar(16) not null,
  name varchar(10) not null,
  reg_date datetime not null
);

desc member;

create table test(
  num_id int not null primary key auto_increment,
  title varchar(50) not null,
  content text not null
);

desc test;

alter table member
     add (address varchar(100) not null,
          tel varchar(20) not null);
          
desc member;

show tables;

drop table test;

show tables;

insert into member(id, passwd, name, reg_date, address, tel) 
values('kingdora@dragon.com','1234','김개동', now(), '서울시', '010-1111-1111');

insert into member(id, passwd, name, reg_date, address, tel) 
values('hongkd@aaa.com','1111','홍길동', now(), '경기도', '010-2222-2222');

select * from member;

select id, passwd from member;

select id, passwd from member where id='hongkd@aaa.com';

select * from member where id='hongkd@aaa.com';

update member set passwd='3579' where id='hongkd@aaa.com';

delete from member where id='hongkd@aaa.com';

delete from member; 



select * from member;

alter table member modify passwd varchar(60) not null;

desc member;

create table board(
  num int not null primary key auto_increment,
  writer varchar(50) not null,
  subject varchar(50) not null,
  content text not null,
  passwd varchar(60) not null,
  reg_date datetime not null,
  ip varchar(30) not null,
  readcount int default 0,
  ref int not null,
  re_step smallint not null,
  re_level smallint not null
);

desc board;

drop table member;

drop table board;

select * from board;

delete * from board where num=4;

update member set passwd='1234' where id='kingdora@dragon.com';

--쇼핑몰--

create table manager(
 managerId varchar(50) not null primary key,
 managerPasswd varchar(60) not null
);

insert into manager(managerId,managerPasswd)
values('bookmaster@shop.com','123456');

select * from manager;

drop table manager;

create table book(
  book_id int not null primary key auto_increment,
  book_kind varchar(3) not null,
  book_title varchar(100) not null,
  book_price int not null,
  book_count smallint not null,
  author varchar(40) not null,
  publishing_com varchar(30) not null,
  publishing_date varchar(15) not null,
  book_image varchar(16) default 'nothing.jpg',
  book_content text not null,
  discount_rate tinyint default 10,
  reg_date datetime not null
);

desc book;

create table qna(
  qna_id int not null primary key auto_increment,
  book_id int not null,
  book_title varchar(100) not null,
  qna_writer varchar(50) not null,
  qna_content text not null,
  group_id int not null,
  qora tinyint not null,
  reply tinyint default 0,
  reg_date datetime not null
);

desc qna;

select * from qna;

drop table qna;

create table bank(
  account varchar(30) not null,
  bank varchar(10) not null,
  name varchar(10) not null
);

insert into bank(account, bank, name)
values('11111-111-11111','내일은행','오내일');

select * from bank;

create table cart(
  cart_id int not null primary key auto_increment,
  buyer varchar(50) not null,
  book_id int not null,
  book_title varchar(100) not null,
  buy_price int not null,
  buy_count tinyint not null,
  book_image varchar(16) default 'nothing.jpg'
); 

desc cart;

select * from cart;

create table buy(
  buy_id bigint not null,
  buyer varchar(50) not null,
  book_id varchar(12) not null,
  book_title varchar(100) not null,
  buy_price int not null,
  buy_count tinyint not null,
  book_image varchar(16) default 'nothing.jpg',
  buy_date datetime not null,
  account varchar(50) not null,
  deliveryName varchar(10) not null,
  deliveryTel varchar(20) not null,
  deliveryAddress varchar(100) not null,
  sanction varchar(10) default '상품준비중'
);

desc buy;

drop table buy;

select * from buy;

select * from book;

drop table book;




