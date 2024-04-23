
    create table table_ssw_info (
        id bigserial not null,
        ssw_code varchar(255),
        ssw_date varchar(255),
        ssw_hour varchar(255),
        ssw_local varchar(255),
        ssw_obs varchar(255),
        ssw_status varchar(255),
        primary key (id)
    );
