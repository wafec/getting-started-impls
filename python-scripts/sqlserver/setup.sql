create database test
go
create login test with password = 'test-123', check_expiration = off, check_policy = off
go
use test
create user test from login test
grant connect, select, insert, update, delete to test
go

create table test (
    id int primary key,
    content text,
);
go