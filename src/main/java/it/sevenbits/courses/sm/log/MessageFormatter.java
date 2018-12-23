package it.sevenbits.courses.sm.log;

import java.util.HashMap;
import java.util.Map;

/**
 * message formatter
 */
public class MessageFormatter {

    private final Map<String, String> states;

    /**
     * default constructor
     */
    public MessageFormatter() {
        states = new HashMap<>();
        states.put("MESSAGE", "Part of message: %1$s");
        states.put("TRASH", "Trash received");
        states.put("MESSAGE_START", "Message creating started");
        states.put("MESSAGE_FINISH", "Message creating finished");

    }

    /**
     * @param type type
     * @return state string
     */
    public String getStringFormatByType(final String type) {
        String defaultString =  "Unknown package type";
        return states.getOrDefault(type, defaultString);
//        if(type.equals("MESSAGE")){
//            return "Part of message: %1$s";
//        } else if(type.equals("TRASH")) {
//            return "Trash received";
//        } else if(type.equals("MESSAGE_START")){
//            return "Message creating started";
//        } else if(type.equals("MESSAGE_FINISH")){
//            return "Message creating finished";
//        }
//        return "Unknown package type";
    }
}
