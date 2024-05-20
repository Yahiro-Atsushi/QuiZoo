package businessObject;

import java.util.List;
import java.util.Map;

import database.QuizDao;
import entity.GameMode;
import entity.Quiz;

public class SetNextQuizLogic {

	public static Quiz execute(Map<Integer, Quiz> quizzes) {
		//宣言
		int section = quizzes.size(); //問題数カウント
		
		//クイズテーブルの全Idを取得
		QuizDao dao = new QuizDao();
		List<String> allQuizIds = dao.selectAllQuizId(GameMode.CHALLENGE);

		//最大の要素数までの数字をランダムに取得する
		int randomIterator = new java.util.Random().nextInt(allQuizIds.size());
		System.out.println("イテレータ：" + randomIterator);
		//id取得し、ランダムなIDを引数にクイズを取得する
		String randomId = allQuizIds.get(randomIterator);
		System.out.println("randomID:" + randomId);
		Quiz quiz = dao.selectQuizById(mode, randomId);
		
		
		
		
		//データベースに10問以上あれば、問題の重複を排除するために
		//全IDリストから削除する
		if(allQuizIds.size() >= 10) {
			allQuizIds.remove(randomIterator);
		}
		//これで問題数分のクイズリストが格納された状態になる。
		
		return game;
	}

}
