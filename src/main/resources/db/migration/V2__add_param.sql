drop extension if exists pgcrypto;
create extension if not exists pgcrypto;

insert into user_account ( user_name, password, first_name, last_name, role, active)
values  ( 'admin', crypt('admin1', gen_salt('bf', 8)), 'admin', 'adminov', 'ROLE_ADMIN', true),
        ( 'user', crypt('qwe1', gen_salt('bf', 8)), 'user', 'userov', 'ROLE_USER', true),
        ( 'ivan', crypt('qwe1', gen_salt('bf', 8)), 'Ivan', 'Ivanov', 'ROLE_USER', false ),
        ( 'sidor', crypt('qwe1', gen_salt('bf', 8)), 'Sidor', 'Sidorov', 'ROLE_USER', false ),
        ( 'petr', crypt('qwe1', gen_salt('bf', 8)), 'Petr', 'Petrov', 'ROLE_USER', true ),
        ( 'tom', crypt('qwe1', gen_salt('bf', 8)), 'Tom', 'Thompson', 'ROLE_USER', true ),
        ( 'michael', crypt('qwe1', gen_salt('bf', 8)), 'Michael', 'Smith', 'ROLE_USER', true ),
        ( 'bob', crypt('qwe1', gen_salt('bf', 8)), 'Bob', 'Barret', 'ROLE_USER', true ),
        ( 'rob', crypt('qwe1', gen_salt('bf', 8)), 'Rob', 'Davis', 'ROLE_USER', true ),
        ( 'adam', crypt('qwe1', gen_salt('bf', 8)), 'Adam', 'Clark', 'ROLE_USER', true ),
        ( 'doug', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true );


