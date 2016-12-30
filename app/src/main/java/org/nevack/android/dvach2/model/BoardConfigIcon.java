package org.nevack.android.dvach2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BoardConfigIcon {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("url")
    @Expose
    private String url;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The num
     */
    public Integer getNum() {
        return num;
    }

    /**
     *
     * @param num
     * The num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}