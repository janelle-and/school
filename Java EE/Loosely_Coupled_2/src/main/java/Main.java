public class Main {
    public static void main(String[] args) {
        MessageClient email = new EmailClient();
        NotificationService emailService = new NotificationService(email);

        emailService.sendNotification("Order shipped");


        MessageClient sms = new SMSClient();
        NotificationService smsService = new NotificationService(sms);

        smsService.sendNotification("Order shipped");
    }
}
