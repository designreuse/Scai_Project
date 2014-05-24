package net.com.scaiprojectv.dto;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import net.com.scaiprojectv.model.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendEmailDTO {
	private static final String REPLY_TO = "gpaulo42@gmail.com";
	private static final String FROM = "gpaulo42@gmail.com";
	private static final String SUBJECT = "Scai Idiomas";

	@Autowired
	private JavaMailSender mailSender;

	public void enviar(Aluno aluno, String urlPagamento)
			throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

		mimeMessageHelper.setTo(aluno.getEmail());
		mimeMessageHelper.setSubject(SUBJECT);
		// mimeMessageHelper.setText(montarEmail(urlPagamento));
		mimeMessageHelper.setSentDate(new Date());
		mimeMessageHelper.setFrom(FROM);
		mimeMessage.setContent(montarEmail(urlPagamento, aluno), "text/html");
		mimeMessageHelper.setCc(aluno.getEmail());
		mimeMessageHelper.setReplyTo(REPLY_TO);

		// this.simpleMail.setCc(aluno.getEmail());
		// this.simpleMail.setFrom(FROM);
		// this.simpleMail.setTo(aluno.getEmail());
		// this.simpleMail.setReplyTo(REPLY_TO);
		// this.simpleMail.setSentDate(new Date());
		// this.simpleMail.setText(montarEmail(urlPagamento));
		// this.simpleMail.setSubject(SUBJECT);

		mailSender.send(mimeMessage);
	}

	private String montarEmail(String urlPagamento, Aluno aluno) {
		return "<h2>Scai Sistema: Oi "
				+ aluno.getNome()
				+ ", tudo bom ?</h2>"
				+ "<h4>Obrigado por acreditar em nosso ensino!</h4>"
				+ "<p>Para concluir sua matrícula, segue abaixo o link para o pagamento de seu investimento: </p>"
				+ "<p>Link: " + urlPagamento + "</p>"
				+ "</br> Um abraço,<br><br>" + "Att. Equipe sistema Scai<br>";
	}
}
