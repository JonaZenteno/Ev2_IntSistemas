private final JmsTemplate jmsTemplate;

public MessageProducer(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
}

public void sendMessage(String message) {
    jmsTemplate.convertAndSend("myQueue", message);
}