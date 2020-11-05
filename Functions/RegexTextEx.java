package Functions;

public class RegexTextEx {
	public static boolean EmailCheck(String email) {
		String emailPattern ="^\\w+@\\w+\\.\\w+(\\.\\w+)?";
		
			boolean check = email.matches(emailPattern);
			if (check == true) return true;
			else return false;
		}
	
	public static boolean TelephoneNumCheck(String tel) {
		String telPattern ="^\\d{2,3}-\\d{3,4}-\\d{4}$";
		String phonePattern ="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$	";

		boolean telcheck = tel.matches(telPattern);
		boolean phonecheck = tel.matches(phonePattern);
		
		if (telcheck == true) return true;
		else {
			if (phonecheck == true) return true;
			else return false;
		}
		
		}
	}

