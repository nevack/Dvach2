package org.nevack.android.dvach2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {

    @SerializedName("banned")
    @Expose
    private Integer banned;
    @SerializedName("closed")
    @Expose
    private Integer closed;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("files")
    @Expose
    private List<File> files = null;
    @SerializedName("lasthit")
    @Expose
    private Integer lasthit;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("op")
    @Expose
    private Integer op;
    @SerializedName("parent")
    @Expose
    private String parent;
    @SerializedName("sticky")
    @Expose
    private Integer sticky;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;
    @SerializedName("trip")
    @Expose
    private String trip;

    /**
     *
     * @return
     * The banned
     */
    public Integer getBanned() {
        return banned;
    }

    /**
     *
     * @param banned
     * The banned
     */
    public void setBanned(Integer banned) {
        this.banned = banned;
    }

    /**
     *
     * @return
     * The closed
     */
    public Integer getClosed() {
        return closed;
    }

    /**
     *
     * @param closed
     * The closed
     */
    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    /**
     *
     * @return
     * The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     * The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     * The date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The files
     */
    public List<File> getFiles() {
        return files;
    }

    /**
     *
     * @param files
     * The files
     */
    public void setFiles(List<File> files) {
        this.files = files;
    }

    /**
     *
     * @return
     * The lasthit
     */
    public Integer getLasthit() {
        return lasthit;
    }

    /**
     *
     * @param lasthit
     * The lasthit
     */
    public void setLasthit(Integer lasthit) {
        this.lasthit = lasthit;
    }

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
     * The number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     *
     * @param number
     * The number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     *
     * @return
     * The op
     */
    public Integer getOp() {
        return op;
    }

    /**
     *
     * @param op
     * The op
     */
    public void setOp(Integer op) {
        this.op = op;
    }

    /**
     *
     * @return
     * The parent
     */
    public String getParent() {
        return parent;
    }

    /**
     *
     * @param parent
     * The parent
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     *
     * @return
     * The sticky
     */
    public Integer getSticky() {
        return sticky;
    }

    /**
     *
     * @param sticky
     * The sticky
     */
    public void setSticky(Integer sticky) {
        this.sticky = sticky;
    }

    /**
     *
     * @return
     * The subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param subject
     * The subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @return
     * The tags
     */
    public String getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     * The tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     *
     * @return
     * The timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     *
     * @param timestamp
     * The timestamp
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     *
     * @return
     * The trip
     */
    public String getTrip() {
        return trip;
    }

    /**
     *
     * @param trip
     * The trip
     */
    public void setTrip(String trip) {
        this.trip = trip;
    }

}
