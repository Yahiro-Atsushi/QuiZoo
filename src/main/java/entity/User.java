package entity;

import java.io.Serializable;

// ユーザー情報を所持するクラス
public class User implements Serializable{
	private String name; // ユーザー名
	private String pass; // パスワード


	public User(final String name, final String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", pass=" + pass + "]";
	}

}
