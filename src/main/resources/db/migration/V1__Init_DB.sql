drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start 1 increment 1;

create table user_account
(
    id         int8    not null,
    user_name  varchar(16),
    password   varchar(16),
    first_name varchar(16),
    last_name  varchar(16),
    role       varchar(16),
    active     boolean not null,
    created_at timestamp DEFAULT current_timestamp,
    primary key (id)
);

alter table if exists user_account
    drop constraint if exists user_name_uniq;

alter table if exists user_account
    add constraint user_name_uniq unique (user_name);
