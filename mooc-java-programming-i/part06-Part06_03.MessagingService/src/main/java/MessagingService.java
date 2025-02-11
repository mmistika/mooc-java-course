
import java.util.ArrayList;

public class MessagingService {
    
    ArrayList<Message> msgs;
    
    public MessagingService() {
        this.msgs = new ArrayList<>();
    }
    
    public void add(Message message) {
        if (message.getContent().length() <= 280) {
            msgs.add(message);
        }
    }
    
    public ArrayList<Message> getMessages() {
        return this.msgs;
    }
}
