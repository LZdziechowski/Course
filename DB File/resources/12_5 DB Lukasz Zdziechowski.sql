insert into POSTS (USER_ID, BODY)
values (3, "To change");
commit;

update POSTS
set BODY = "To delete"
where ID = 8;
commit;

delete from POSTS
where ID = 8;
commit;