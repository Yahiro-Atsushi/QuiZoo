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

-------- アカウント ----------
CREATE VIEW accounts_view
(id, name, pass)
AS
SELECT
 id, name, pass
FROM 
 accounts
WHERE
 delete_at IS NULL
ORDER BY
 id;

---------- TEST ----------
CREATE VIEW quiz_test_view
(id, question, answer, button1, button2, button3, button4, 
 button_text1, button_text2, button_text3, button_text4)
AS
SELECT
 id, question, answer, button1, button2, button3, button4, 
 button_text1, button_text2, button_text3, button_text4
FROM 
 quiz
WHERE
 mode = 'test' AND
 delete_at IS NULL
ORDER BY
 id;

---------- EASY ----------
CREATE VIEW quiz_easy_view
(id, question, answer, button1, button2, button3, button4, 
 button_text1, button_text2, button_text3, button_text4)
AS
SELECT
 id, question, answer, button1, button2, button3, button4, 
 button_text1, button_text2, button_text3, button_text4
FROM 
 quiz
WHERE
 mode = 'easy' AND
 delete_at IS NULL
ORDER BY
 id;

---------- NORMAL ----------
CREATE VIEW quiz_normal_view
(id, question, answer, button1, button2, button3, button4, 
 button_text1, button_text2, button_text3, button_text4)
AS
SELECT
 id, question, answer, button1, button2, button3, button4, 
 button_text1, button_text2, button_text3, button_text4
FROM 
 quiz
WHERE
 mode = 'normal' AND
 delete_at IS NULL
ORDER BY
 id;

---------- HARD ----------
CREATE VIEW quiz_hard_view
(id, question, answer, button1, button2, button3, button4, 
 button_text1, button_text2, button_text3, button_text4)
AS
SELECT
 id, question, answer, button1, button2, button3, button4, 
 button_text1, button_text2, button_text3, button_text4
FROM 
 quiz
WHERE
 mode = 'hard' AND
 delete_at IS NULL
ORDER BY
 id;
 
---------- CHALLENGE ----------
CREATE VIEW quiz_challenge_view
(id, mode,question, answer, button1, button2, button3, button4, 
 button_text1, button_text2, button_text3, button_text4)
AS
SELECT
 id, mode, question, answer, button1, button2, button3, button4, 
 button_text1, button_text2, button_text3, button_text4
FROM 
 quiz
WHERE
 mode != 'test' OR 
 delete_at IS NULL;

---------- 履歴 ----------
CREATE VIEW journal_view
(id, name, mode, correct_count, play_date, 
 q1_id, q1_result, q2_id, q2_result, 
 q3_id, q3_result, q4_id, q4_result,
 q5_id, q5_result, q6_id, q6_result, 
 q7_id, q7_result, q8_id, q8_result,
 q9_id, q9_result, q10_id, q10_result)
AS
SELECT
 id, name, mode, correct_count, play_date, 
 q1_id, q1_result, q2_id, q2_result, 
 q3_id, q3_result, q4_id, q4_result,
 q5_id, q5_result, q6_id, q6_result, 
 q7_id, q7_result, q8_id, q8_result,
 q9_id, q9_result, q10_id, q10_result
FROM 
 journal
WHERE
 delete_at IS NULL
ORDER BY
 id;
 
---------- チャレンジモードランキング ----------
CREATE VIEW ranking_challenge
(rank, name, correct_count, play_date, id)
AS
SELECT DISTINCT
 RANK() OVER 
	(ORDER BY correct_count DESC) AS rank,
 name, correct_count, play_date, id
FROM 
 journal_challenge
WHERE
 delete_at IS NULL
ORDER BY
 rank;

---------- ランキング ----------
CREATE VIEW ranking
(rank, name, mode, correct_count, play_date, id)
AS
SELECT DISTINCT
 RANK() OVER 
	(PARTITION BY mode
	 ORDER BY correct_count DESC) AS rank,
 name,
 mode,
 correct_count,
 play_date,
 id
FROM
 journal
WHERE
 delete_at IS NULL 
ORDER BY 
 rank ,
 play_date,
 id;


