package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class EmailService {

	public static void main(String[] args) {
		var emailService = new EmailService();
		var service = new KafkaService(EmailService.class.getSimpleName(),
				"ECOMMERCE_SEND_EMAIL", emailService::parse);

		service.run();
	}

	public void parse(ConsumerRecord<String, String> record) {
		System.out.println("----------------------------------------");
		System.out.println("Send email");
		System.out.println(record.key());
		System.out.println(record.value());
		System.out.println(record.partition());
		System.out.println(record.offset());

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("Email sent");
	}

}
