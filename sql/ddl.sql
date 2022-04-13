create table board
(
	id bigint not null auto_increment,
	title varchar(255),
	contents varchar(50000),
	writer varchar(20)
	primary key(id)
);

insert into member(title, contents, writer) values ('spring 연습', '같이 스프링 해요!', '이진서');