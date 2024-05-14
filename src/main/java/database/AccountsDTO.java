package database;

public class AccountsDTO {
	private String id;
	private String name;
	private String pass;
	private String delete_at;
	
	public AccountsDTO() {
		
	}
	
	public AccountsDTO(final String id, final String name, final String pass, final String delete_at) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.delete_at = delete_at;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
	public String getDelete_at() {
		return delete_at;
	}
	
	@Override
	public String toString() {
		return "AccountsDTO [id=" + id + ", name=" + name + ", pass=" + pass + ", delete_at=" + delete_at + "]";
	}
	
	

}
