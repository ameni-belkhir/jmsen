package jmsen;

import org.apache.activemq.broker.BrokerService;

public class ActiveMQBroker {
	public static void main(String[] args) {
		try {
			BrokerService broker = new BrokerService();
			broker.addConnector("tcp://0.0.0.0:61616");
			broker.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
