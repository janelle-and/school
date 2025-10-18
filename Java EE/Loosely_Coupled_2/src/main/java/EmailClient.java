public class EmailClient implements MessageClient{

    @Override
    public void sendMessage(String message){
        System.out.println("Email sent: " + message);
    }
}
