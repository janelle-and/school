public class SMSClient implements MessageClient{
    @Override
    public void sendMessage(String message){
        System.out.println("SMS sent: " + message);
    }
}
