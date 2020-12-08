package com.example.springboot;

import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.TypedMessageBuilder;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import java.util.stream.IntStream;
import org.apache.pulsar.client.api.ClientBuilder;
public class consumer
{
	   private static final String SERVICE_URL = "pulsar://localhost:6650";
	          private static final String TOPIC_NAME = "my-topic";
		     public static void main( String[] args ) throws Exception
			         {

					      PulsarClient client = PulsarClient.builder()
						                           .serviceUrl("pulsar://localhost:6650")
									                                .build();

					           Consumer consumer = client.newConsumer()
							            .topic(TOPIC_NAME)
								             .subscriptionName("fs")
									     .subscribe();
							boolean waiting = true;
						   while (waiting) {
							   Message msg = consumer.receive();
							   try {
								   System.out.printf("Message rec: %s", new String(msg.getData()));
								   consumer.acknowledge(msg);
								   waiting = false;
							   } catch (Exception e) {
								   consumer.negativeAcknowledge(msg);
							   }
						   }
						   consumer.close();
						   client.close();
									         }
}
