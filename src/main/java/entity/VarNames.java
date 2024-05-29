package entity;

// 列挙型で属性名を所持するクラス
// マジックワードを減らすのが目的
public enum VarNames {
	name, /* String */
	pass, /* String */
	loginErrorMsg, /* LoginErrorMsg */
	registerErrorMsg, /* RegisterErrorMsg */
	userName, /* String */
	gameMode, /* GameMode */
	game,  /* Game */
	quiz, /* Quiz */
	randomIdList, /* List<String> */
	easy, /* String */
	normal, /* String */
	hard, /* String */
	challenge, /* String */
	gameIsAbone, /* boolean */
	gameErrorMsg, /* GameErrorMsg */
	answerCount; /* int */

}
