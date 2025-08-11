package Structural.Adapter;

/*
 * You have your own logging interface, but a new project wants to use SLF4J instead.
 */

/*
 * Target interface
 */
interface MyLogger{
    void log(String message);
}

/*
 * Third-party logging framework
 */
class Slf4jLogger{
    public void info(String msg){
        System.out.println("[INFO] " + msg);
    }
}

/*
 * Adapter
 */
class Slf4jLoggerAdapter implements MyLogger{
    private Slf4jLogger slf4jLogger;

    public Slf4jLoggerAdapter(Slf4jLogger slf4jLogger){
        this.slf4jLogger = slf4jLogger;
    }

    @Override
    public void log(String message) {
        slf4jLogger.info(message);
    }

}

/*
 * Client
 */
public class LoggingFrameworkDemo {
    public static void main(String[] args){
        MyLogger logger = new Slf4jLoggerAdapter(new Slf4jLogger());
        logger.log("Log my message");
    }
    
}
