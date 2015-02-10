package com.example.takahiro_tsuno.newsreader.domain.rss;

import com.example.domain.AbstractValueObject;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict=false)
public class Item extends AbstractValueObject {
    @Element
    private String title;
    @Element
    private String link;
    @Element
    private String pubDate;
}
