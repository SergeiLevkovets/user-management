drop extension if exists pgcrypto;
create extension if not exists pgcrypto;

insert into user_account ( user_name, password, first_name, last_name, role, active)
values  ( 'admin', crypt('admin1', gen_salt('bf', 8)), 'admin', 'adminov', 'ROLE_ADMIN', true),
        ( 'user', crypt('qwe1', gen_salt('bf', 8)), 'user', 'userov', 'ROLE_USER', true),
        ( 'user1', crypt('qwe1', gen_salt('bf', 8)), 'Ivan', 'Ivanov', 'ROLE_USER', false );
