package com.example.takahiro_tsuno.newsreader.domain.rss;

import com.example.domain.AbstractValueObject;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict=false)
public class Channel extends AbstractValueObject {
    @Element
    private String title;
    @Element
    private String link;
    @Element
    private String description;
    @Element
    private String pubDate;
    @Element
    private String language;

    @ElementList(entry = "item", inline = true)
    private List<Item> itemList;

    public String getTitle(){
        return title;
    }
}
