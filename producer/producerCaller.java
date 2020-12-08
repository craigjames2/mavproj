import stringpro.*;

public class producerCaller {


	public static void main(String[] args) {
		producer myproducer = new producer();
		String text = producer.callablePro(args[0]);
		if (text.length() !=0) {
			System.out.println("Success");
		}
		else { System.out.println("Error");
		}
	}
}	
