package com.example.ticket;


import com.example.ticket.model.Tickets;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailTicketSender {

	private final JavaMailSender mailSender;

	public void sendEmail(String toEmail,
	                      String subject,
	                      Tickets tickets) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("omyrzakovbeksultan1@gmail.com");
		message.setTo(toEmail);
		String body = "Departure location: " + tickets.getRoadId().getDeparture().getStationId().getAddress() +
				", your bus gov number: " + tickets.getRoadId().getBus_id().getGovNumber() + ", your place in this: "
				+ tickets.getPlace() + ", departure date: " + tickets.getRoadId().getDeparture_date() + ", ticket prime code: "
				+ tickets.getPrimeCodeTicket() + ", please scan this code. ";
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
		System.out.println("Mail send success");
	}
}
