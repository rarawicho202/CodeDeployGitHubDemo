import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class MyHandler extends StreamHandler {
    public void publish (LogRecord record){
super.publish(record);
    }
    public void flush(){super.flush(); }
    public void  close() throws SecurityException{
        super.close();
    }

}
