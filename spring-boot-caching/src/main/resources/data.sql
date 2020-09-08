-- Courses
insert into course (id, name, created_date, last_updated_date)
values (10000, 'Software Architecture', sysdate(), sysdate());

insert into course (id, name, created_date, last_updated_date)
values (10001, 'Concurrency', sysdate(), sysdate());

insert into course (id, name, created_date, last_updated_date)
values (10002, 'Team Project', sysdate(), sysdate());

-- here

insert into course (id, name, created_date, last_updated_date)
values (10003, 'Software Architecture2', sysdate(), sysdate());

insert into course (id, name, created_date, last_updated_date)
values (10004, 'Concurrency2', sysdate(), sysdate());

insert into course (id, name, created_date, last_updated_date)
values (10005, 'Team Project2', sysdate(), sysdate());

insert into course (id, name, created_date, last_updated_date)
values (10006, 'Software Architecture3', sysdate(), sysdate());

insert into course (id, name, created_date, last_updated_date)
values (10007, 'Concurrency3', sysdate(), sysdate());

insert into course (id, name, created_date, last_updated_date)
values (10008, 'Team Project3', sysdate(), sysdate());

insert into course (id, name, created_date, last_updated_date)
values (10009, 'Software Architecture4', sysdate(), sysdate());

insert into course (id, name, created_date, last_updated_date)
values (10010, 'Concurrency4', sysdate(), sysdate());

insert into course (id, name, created_date, last_updated_date)
values (10011, 'Team Project4', sysdate(), sysdate());

-- Passport
insert into passport (id, number) values (1000, 'e1234');
insert into passport (id, number) values (1001, 'e1235');
insert into passport (id, number) values (1002, 'e2234');
insert into passport (id, number) values (1003, 'e4234');

-- Students
insert into student (id, name, passport_id) values (100, 'Abe', 1000);
insert into student (id, name, passport_id) values (101, 'Michel', 1001);
insert into student (id, name, passport_id) values (102, 'Bogdan', 1002);
insert into student (id, name, passport_id) values (103, 'Darius', 1003);

-- Review
insert into review (id, rating, description, course_id) values (10, 3, 'This was nice', 10000);
insert into review (id, rating, description, course_id) values (11, 4, 'Amazing', 10000);
insert into review (id, rating, description, course_id) values (12, 1, 'Useless', 10001);
insert into review (id, rating, description, course_id) values (13, 5, 'Essential', 10002);

-- Student_Course
insert into student_course(student_id, course_id) values (100, 10000);
insert into student_course(student_id, course_id) values (101, 10000);
insert into student_course(student_id, course_id) values (102, 10001);
insert into student_course(student_id, course_id) values (100, 10001);
insert into student_course(student_id, course_id) values (103, 10001);