package com.example.springboot;

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

					      PulsarClient client = PulsarClient.builder()
						                           .serviceUrl("pulsar://localhost:6650")
									                                .build();

					           Producer<byte[]> producer = client.newProducer()
							            .topic(TOPIC_NAME)
								             .create();

						        String text = "default message";
							if (args.length != 0) {
								text = args[0];
							}
							     byte[] content = text.getBytes();



							             MessageId msgId = producer.newMessage().value(content).send();
								             System.out.println("pubd " + msgId);
									     producer.close();
									     client.close();
									         }
	public static String stringPro(String[] args) throws Exception {
		PulsarClient client = PulsarClient.builder()
			.serviceUrl("pulsar://localhost:6650")
			.build();
		Producer<byte[]> producer = client.newProducer()
			.topic("my-topic")
			.create();
		String text = "default message";
		if (args.length !=0) {
			text = args[0];
		}
		byte[] content = text.getBytes();
		MessageId msgId = producer.newMessage().value(content).send();

		producer.close();
		client.close();
		return text;

	}
}
