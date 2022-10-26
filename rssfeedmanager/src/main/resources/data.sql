

create table rss_feed_user (user_id bigint not null, email_id varchar(255), user_name varchar(255), primary key (user_id));

insert into rss_feed_user (email_id, user_name, user_id) values ('dayalan143@gmail.com', 'dayalan', 25);