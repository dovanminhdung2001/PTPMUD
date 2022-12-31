use ptpmud;

create table tbl_logining (
	logining int
);

delete from tbl_logining where logining = 2;

create table tbl_admin (
	username varchar(250),
	password varchar(250)
);

create table tbl_user (
	id int primary key auto_increment ,
	password varchar(100),
	full_name varchar(100),
	phone varchar(12)
);
 
insert into tbl_user values (null, 'p1', 'user 1', '0123451111'), (null, 'p2', 'user 2', '0123452222'),
							(null, 'p3', 'user 2', '0123453333'), (null, 'p4', 'user 3', '0123454444');

create table tbl_checkin (
	id int primary key auto_increment, 	-- 1
	user_id int,						-- 2
	checkin datetime,					-- 3
	go_out1 datetime  ,					-- 4
	go_in1 datetime,					-- 5
	go_out2 datetime,					-- 6
	go_in2 datetime,					-- 7
	go_out3 datetime,					-- 8
	go_in3 datetime,					-- 9
	checkout datetime,					-- 10
	checkin_late int,					-- 11
	checkout_early int,					-- 12
	go_out_amount int,					-- 13
	go_out_time int,					-- 14
	work_time int						-- 15
);

select * from tbl_checkin tc ;

-- insert into tbl_checkin (user_id, checkin, go_out1, go_in1, checkout) values (1, '2022-12-30 07:04:34', '2022-12-30 07:54:34', '2022-12-30 07:59:50', '2022-12-30 09:31:04');

update tbl_checkin set go_out_time = 1, work_time = 2, go_out_amount = 3;

delete from tbl_checkin where id = 2;

drop  table tbl_checkin ;

create table tbl_test ( zzz time  );

insert into tbl_test values ('2022-12-30 07:04:34');

drop table tbl_test;

select * from tbl_test;

