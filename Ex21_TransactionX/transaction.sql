drop table TRANSACTION1;
create table TRANSACTION1 (
    consumerid varchar2(20),
    amount number
);

drop table TRANSACTION2;
create table TRANSACTION2 (
    consumerid varchar2(20),
    amount number
);

drop table TRANSACTION3;
create table TRANSACTION3 (
    consumerid varchar2(20),
    amount number
);

insert into TRANSACTION1 values ('1', 100);
insert into TRANSACTION2 values ('1', 100);
insert into TRANSACTION3 values ('1', 100);
commit;

select * from TRANSACTION1;
select * from TRANSACTION2;
select * from TRANSACTION3;