public class NotificationService {
    private final MessageClient messageClient;

    public NotificationService(MessageClient messageClient) {
        this.messageClient = messageClient;
    }

    public void sendNotification(String message){
        this.messageClient.sendMessage(message);
    }
}
