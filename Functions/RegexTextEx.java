package Functions;

public class RegexTextEx {
	public static boolean EmailCheck(String email) {
		String emailPattern ="^\\w+@\\w+\\.\\w+(\\.\\w+)?";
		
			boolean check = email.matches(emailPattern);
			if (check == true) return true;
			else return false;
			
		}
	}

