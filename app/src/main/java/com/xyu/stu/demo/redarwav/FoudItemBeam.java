package com.xyu.stu.demo.redarwav;

/**
 * Created by zhibuyu on 2018/3/11 0011.
 */

public class FoudItemBeam {
    private String id;
    private String head_url;

    public FoudItemBeam() {
    }

    public FoudItemBeam(String id, String head_url) {
        this.id = id;
        this.head_url = head_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }
}
