drop table user_list;
create table user_list (
    name varchar2(20) primary key,
    password varchar2(100),
    authority varchar(20),
    enabled number(1)
);

insert into user_list values ('user', '��ȣȭ�� �н�����', 'ROLE_USER', 1);
insert into user_list values ('admin', '��ȣȭ�� �н�����', 'ROLE_ADMIN', 1);
commit;

select * from user_list;