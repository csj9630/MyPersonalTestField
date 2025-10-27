package pwRegEx;

public class runwValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pwstr= "qwer1234,erty,1235,@#@%,qwer@1234,QWer@1234";
		String[] pwlist = pwstr.split(",");
		
		boolean flag = false;
		for (String pw : pwlist) {
			flag = PasswordValidator.isValid(pw);
			System.out.println(pw+" / "+flag);
		}
	}

}
