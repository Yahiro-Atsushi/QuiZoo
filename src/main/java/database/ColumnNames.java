package database;

//データベースの列名を管理する列挙型クラス
public enum ColumnNames {
/* --------accountsテーブル-------- */
	id,		 /* レコードID */
	name,	 /* ユーザー名 */
	pass, 	 /* パスワード */
/* --------quizテーブル-------- */
	question,		 /* 問題文 */
	answer,			 /* 答え */
	button1, button_text1, /* ボタンとそれに紐づく説明 1 (ボタンは4つまで) */
	button2, button_text2, /* ボタンとそれに紐づく説明 2 */
	button3, button_text3, /* ボタンとそれに紐づく説明 3 */
	button4, button_text4, /* ボタンとそれに紐づく説明 4 */
/* --------journalテーブル-------- */
	mode,			 /* 難易度 */
	correct_count,	 /* 正解数 */
	play_date,		 /* プレイした日付 */
	q1_id, q1_result, /* クイズIDとその結果 1 (10問まで) */
	q2_id, q2_result, /* クイズIDとその結果 2 */
	q3_id, q3_result, /* クイズIDとその結果 3 */
	q4_id, q4_result, /* クイズIDとその結果 4 */
	q5_id, q5_result, /* クイズIDとその結果 5 */
	q6_id, q6_result, /* クイズIDとその結果 6 */
	q7_id, q7_result, /* クイズIDとその結果 7 */
	q8_id, q8_result, /* クイズIDとその結果 8 */
	q9_id, q9_result, /* クイズIDとその結果 9 */
	q10_id, q10_result;/* クイズIDとその結果 10 */
}
