public class NotificationService {
    private EmailClient emailClient;

    public NotificationService(){
        this.emailClient = new EmailClient();
    }

    public void sendNotification(String message){
        this.emailClient.sendEmail(message);
    }
}
