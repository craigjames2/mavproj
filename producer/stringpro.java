import com.example.*;

public class stringpro {


	public static void main(String[] args) {
		callablePro producer = new callablePro();
		String text = producer.stringPro(args[0]);
		if (text.length() !=0) {
			System.out.println("Success");
		}
		else { System.out.println("Error");
		}
	}
}	
