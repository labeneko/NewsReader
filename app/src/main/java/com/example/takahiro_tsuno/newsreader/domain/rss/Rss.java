package com.example.takahiro_tsuno.newsreader.domain.rss;

import com.example.domain.AbstractValueObject;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Version;

@Root
public class Rss extends AbstractValueObject {
    @Version
    private double version;

    @Element
    private Channel channel;

    public Channel getChannel(){
        return channel;
    }
}
