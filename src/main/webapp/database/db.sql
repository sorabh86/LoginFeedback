/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sorabh86 <ssorabh.ssharma@gmail.com>
 * Created: Sep 11, 2018
 */

-- create table for user for customers
CREATE TABLE user (
    id NUMBER NOT NULL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

-- create a auto incremented sequence for id
CREATE SEQUENCE user_seq;

-- create a trigger on insert and add automatic id in users table
CREATE TRIGGER user_trigger
    BEFORE INSERT ON user
FOR EACH ROW
BEGIN
    SELECT user_seq.nextval
        INTO :new.id
    FROM dual;
END;
/

-- insert default record for login
INSERT INTO users VALUES ("admin","admin1234");

-- create a table for saving feedbacks with reference/forign key
CREATE TABLE feedback (
    id NUMBER NOT NULL PRIMARY KEY,
    user_id NUMBER NOT NULL REFERENCES users(id), 
    message VARCHAR(255)
);

-- create sequence for feedback table
CREATE SEQUENCE feedback_seq;

-- trigger for feedback id generation
CREATE TRIGGER feedback_trigger
    BEFORE INSERT ON feedback
FOR EACH ROW
BEGIN
    SELECT feedback_seq.nextval INTO :new.id FROM dual;
END;
/


