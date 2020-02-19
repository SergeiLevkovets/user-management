drop table if exists user_account;

drop table if exists flyway_schema_history;

drop extension if exists pgcrypto;

-- drop sequence if exists hibernate_sequence;

-- drop sequence if exists hibernate_sequence;

-- create sequence hibernate_sequence start 1 increment 1;

/*alter table if exists user_account
    drop constraint if exists user_name_uniq;

alter table if exists user_account
    add constraint user_name_uniq unique (user_name);*/