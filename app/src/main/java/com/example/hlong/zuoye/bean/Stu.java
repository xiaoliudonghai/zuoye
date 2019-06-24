package com.example.hlong.zuoye.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Stu {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String text;
    @Property
    private String thumbnail;
    @Generated(hash = 1956970201)
    public Stu(Long id, String text, String thumbnail) {
        this.id = id;
        this.text = text;
        this.thumbnail = thumbnail;
    }
    @Generated(hash = 501767467)
    public Stu() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
