
package org.nevack.android.dvach2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class File {

    public static final int TYPE_WEBM = 6;
    public static final int TYPE_GIF = 4;
    public static final int TYPE_PIC = 1;
    public static final int TYPE_STICKER = 100;

    @SerializedName("displayname")
    @Expose
    private String displayname;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("md5")
    @Expose
    private String md5;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nsfw")
    @Expose
    private Integer nsfw;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("tn_height")
    @Expose
    private Integer tnHeight;
    @SerializedName("tn_width")
    @Expose
    private Integer tnWidth;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("duration")
    @Expose
    private String duration;

    /**
     * 
     * @return
     *     The displayname
     */
    public String getDisplayname() {
        return displayname;
    }

    /**
     * 
     * @param displayname
     *     The displayname
     */
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    /**
     * 
     * @return
     *     The fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * 
     * @param fullname
     *     The fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * 
     * @return
     *     The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * 
     * @param md5
     *     The md5
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The nsfw
     */
    public Integer getNsfw() {
        return nsfw;
    }

    /**
     * 
     * @param nsfw
     *     The nsfw
     */
    public void setNsfw(Integer nsfw) {
        this.nsfw = nsfw;
    }

    /**
     * 
     * @return
     *     The path
     */
    public String getPath() {
        return path;
    }

    /**
     * 
     * @param path
     *     The path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 
     * @return
     *     The size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * 
     * @param size
     *     The size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * 
     * @return
     *     The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * @param thumbnail
     *     The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * 
     * @return
     *     The tnHeight
     */
    public Integer getTnHeight() {
        return tnHeight;
    }

    /**
     * 
     * @param tnHeight
     *     The tn_height
     */
    public void setTnHeight(Integer tnHeight) {
        this.tnHeight = tnHeight;
    }

    /**
     * 
     * @return
     *     The tnWidth
     */
    public Integer getTnWidth() {
        return tnWidth;
    }

    /**
     * 
     * @param tnWidth
     *     The tn_width
     */
    public void setTnWidth(Integer tnWidth) {
        this.tnWidth = tnWidth;
    }

    /**
     * 
     * @return
     *     The type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 
     * @return
     *     The duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The duration
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

}
