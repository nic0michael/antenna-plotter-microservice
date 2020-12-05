USE antenna;				


-- INSERT employee			
insert into employee ( fullname, email,id_number,enabled) values ( 'John Warton', 'warton@gmail.com','001', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Mike Lanister', 'lanister@gmail.com','002', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Steve Reeves', 'Reeves@gmail.com','003', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Ronald Connor', 'connor@gmail.com','004', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Jim Salvator', 'Sal@gmail.com','005', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Peter Henley', 'henley@gmail.com','006', 1);	
insert into employee ( fullname, email,id_number,enabled) values ( 'Richard Carson', 'carson@gmail.com','007', 1);	

insert into employee ( fullname, email,id_number,enabled,user_id,authority,password) values ( 'Tony Roggers', 'roggers@gmail.com','009', 1,'user','ROLE_USER','$2a$10$8D29dyYhGe2Z8VPT3BV84eL6JptlMWgoFAJObP9Gq9IYG6Gc1DXSa');	
insert into employee ( fullname, email,id_number,enabled,user_id,authority,password) values ( 'Honor Miles', 'miles@gmail.com','008', 1,'admin','ROLE_ADMIN','$2a$10$XhADpGqFMvF33YzPmdV7JOTVbvRl9KqN5Tgxx3jHyOcVVxfRqPIwi');	
insert into employee ( fullname, email,id_number,enabled,user_id,authority,password) values ( 'Nicholas Michael', 'nmichael@gmail.com','1956', 1,'klidi','ROLE_ADMIN','$2a$10$r4325krPku2wNegHS5zLY.4PWtbc4Xz7Zu4NfS2AWaiNVNONtrt.2');	





-- =============================== CREATE ADMINISTRATOR USER SQL SCRIPT ==================================================================
--
--   set your administrator user 
--   with password = P@55w0rd 
--   and role as administrator 
--   and your logon user id
-
INSERT INTO employee 
            (fullname, 
             email, 
             id_number, 
             enabled, 
             user_id, 
             authority, 
             password) 
VALUES      ( 'Youe_administrators_fullname', 
              'your_email@gmail.com', 
              '123456', -- This is your identity number
              1, 
              'yourlogon_user_id', -- This is your logon user id
              'ROLE_ADMIN', 
              '$2a$10$r4325krPku2wNegHS5zLY.4PWtbc4Xz7Zu4NfS2AWaiNVNONtrt.2'); -- password = P@55w0rd
--              
-- =============================== END OF CREATE ADMINISTRATOR USER SQL SCRIPT ===========================================================




-- EMPLOYEE-USERSTORY-COUNT
SELECT count(*) as userstoryCount, e.fullname as fullName
 FROM employee e 
 LEFT JOIN task t ON t.assigned_to = e.employee_id
 LEFT JOIN user_story u ON u.user_story_id = t.user_story_id
 WHERE t.task_id IS NOT NULL
 GROUP BY e.fullname
 ORDER BY userstoryCount desc;
 
