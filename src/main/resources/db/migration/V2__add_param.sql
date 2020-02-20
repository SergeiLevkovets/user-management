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
        ( 'doug', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'qaz', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'wsx', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'edc', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'rfv', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'tgb', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'yhn', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'ujm', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'ikm', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'qwe', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'asd', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'zxc', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'wer', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'sdf', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'xcv', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'ert', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'dfg', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'cvb', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'rty', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'fgh', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'vbn', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'tyu', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'ghj', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'bnm', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'ewq', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'dsa', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'cxz', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'rew', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'fds', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'vcx', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'tre', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'gfd', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'bvc', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'ytr', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'hgf', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'nbv', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'uyt', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'jhg', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'mmnb', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'zaq', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'xsw', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'cde', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'vfr', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'bgt', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'nhy', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'mju', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'zse', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'xdr', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true ),
        ( 'cft', crypt('qwe1', gen_salt('bf', 8)), 'Doug', 'Lee', 'ROLE_USER', true );


