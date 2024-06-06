CREATE database quizoo;

CREATE TABLE accounts
(id         serial,
name        text    NOT NULL   UNIQUE,
pass        text    NOT NULL,
delete_at   text,
PRIMARY KEY (id));

CREATE TABLE journal
(id         serial,
name        text    NOT NULL,
mode        text   NOT NULL,
correct_count  INTEGER,
q1_id     text  NOT NULL,
q1_result text  NOT NULL,
q2_id     text  NOT NULL,
q2_result text  NOT NULL,
q3_id     text  NOT NULL,
q3_result text  NOT NULL,
q4_id     text  NOT NULL,
q4_result text  NOT NULL,
q5_id     text  NOT NULL,
q5_result text  NOT NULL,
q6_id     text  NOT NULL,
q6_result text  NOT NULL,
q7_id     text  NOT NULL,
q7_result text  NOT NULL,
q8_id     text  NOT NULL,
q8_result text  NOT NULL,
q9_id     text  NOT NULL,
q9_result text  NOT NULL,
q10_id     text  NOT NULL,
q10_result text  NOT NULL,
play_date   text     DEFAULT(TO_CHAR(now(), 'YYYY/MM/DD HH24:MI:SS')),
delete_at   text,
PRIMARY KEY (id));

CREATE TABLE journal_challenge
(id         serial,
name        text    NOT NULL,
correct_count  INTEGER,
play_date   text     DEFAULT(TO_CHAR(now(), 'YYYY/MM/DD HH24:MI:SS')),
delete_at   text,
PRIMARY KEY (id));


CREATE TABLE quiz
(id         serial,
mode        text    NOT NULL,
question    text    NOT NULL,
answer      text    NOT NULL,
button1     text    NOT NULL,
button2     text    NOT NULL,
button3     text    NOT NULL,
button4     text    NOT NULL,
button_text1    text    NOT NULL,
button_text2    text    NOT NULL,
button_text3    text    NOT NULL,
button_text4    text    NOT NULL,
delete_at   text,
PRIMARY KEY (id));


