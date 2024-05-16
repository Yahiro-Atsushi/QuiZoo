package businessObject;

import java.util.List;

import database.SelectDao;
import entity.Game;
import entity.GameMode;
import entity.Quiz;

public class SetGameLogic {
	public static Game execute(GameMode mode) {
		//ゲームインスタンス生成
		Game game = new Game(mode);

		//リストをランダムな10個のidが並んだリストを作る
		//宣言
		int count = 10; //問題数分格納するためのカウント
		
		//クイズテーブルの全Idを取得
		SelectDao dao = new SelectDao();
		List<String> allQuizIds = dao.selectAllQuizId(mode);

		while (count != 0) {
			//最大の要素数までの数字をランダムに取得する
			int randomIterator = new java.util.Random().nextInt(allQuizIds.size());
			System.out.println("イテレータ：" + randomIterator);
			//id取得し、ランダムなIDを引数にクイズを取得する
			String randomId = allQuizIds.get(randomIterator);
			System.out.println("randomID:" + randomId);
			Quiz quiz = dao.selectQuizById(mode, randomId);
			
			//取得したクイズを格納する。
			game.getQuizzes().put(count, quiz);
			
			//クイズの結果は一旦falseで置く
			game.getIsCorrects().put(count, false);
			
			//クイズを格納したのでカウントを減らす。
			count--;
			
			//データベースに10問以上あれば、問題の重複を排除するために
			//全IDリストから削除する
			if(allQuizIds.size() >= 10) {
				allQuizIds.remove(randomIterator);
			}
		}
		//これで問題数分のクイズリストが格納された状態になる。
		
		return game;
	}
}
