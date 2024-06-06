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

