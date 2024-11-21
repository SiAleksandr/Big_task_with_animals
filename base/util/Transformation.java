package base.util;

import base.util.assistant.DBConnector;
import base.util.assistant.DBTranslator;

public class Transformation {
    DBConnector connector;
    DBTranslator translator;
    public Transformation(DBConnector connector, DBTranslator translator) {
        this.connector = connector;
        this.translator = translator;
    }
    
}
