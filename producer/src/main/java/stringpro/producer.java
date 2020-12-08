package stringpro;

import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.TypedMessageBuilder;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import java.util.stream.IntStream;
import org.apache.pulsar.client.api.ClientBuilder;
public class producer
{
	private static final String SERVICE_URL = "pulsar://localhost:6650";
	private static final String TOPIC_NAME = "my-topic";
	public static void main( String[] args ) throws Exception
	{
		String text = "default message";
		if (args.length != 0) {
			text = args[0];
		}
		System.out.println("pubd: " + callablePro(text));
					      
	}
	
	public static String callablePro(String text) throws Exception {
		PulsarClient client = PulsarClient.builder() 
			.serviceUrl("pulsar://localhost:6650") 
			.build();
		Producer<byte[]> producer = client.newProducer()
			.topic("my-topic")  
			.create();
		byte[] content = text.getBytes();          
		MessageId msgId = producer.newMessage().value(content).send();
	       	producer.close();
		client.close();
		return text;	
	}
}	
