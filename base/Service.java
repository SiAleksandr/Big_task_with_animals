package base;

import java.util.HashMap;
import java.util.Map;

import view.View;
import base.util.Attachment;
import base.util.Collector;

public class Service {
    public Attachment transform;
    public Collector source;

    public Service() {
        transform = new Attachment();
        source = new Collector();
    }

    public Boolean start() {
        return source.startWork();
    }

    public void describeNewAnimal() {

    }
    
}
