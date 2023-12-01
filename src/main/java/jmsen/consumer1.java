package jmsen;

import java.sql.Connection;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import java.util.Scanner;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.Message;


public class consumer1 {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		String code = scanner.nextLine();
		try {
		//Create a Connection Factory
		ConnectionFactory connectionfactory= new ActiveMQConnectionFactory("tcp://localhost:61616");
		//Create a Connection
		javax.jms.Connection connection= connectionfactory.createConnection();
		//Start The connection
		connection.start();
		//Create the session
		Session session= connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		//Create The destination (Topic or Queue)
		Destination destination=session.createTopic("Dtopic");
		//Create the Message Consumer from the session to the Topic or Queue
		MessageConsumer consumer=session.createConsumer(destination,"code = '"+code+"'");
		//Create JMS Listener form messages
		consumer.setMessageListener(new MessageListener(){
		public void onMessage(Message message) {
		if (message instanceof TextMessage) {
		try {
		TextMessage textmessage= (TextMessage) message;
		String text = textmessage.getText();
		System.out.println("recieved"+message);
		} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}}}

		public void onMessage(javax.jms.Message message) {
			// TODO Auto-generated method stub
			
		}});
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}}


