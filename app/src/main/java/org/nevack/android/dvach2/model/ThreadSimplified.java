
package org.nevack.android.dvach2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThreadSimplified {

    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("lasthit")
    @Expose
    private Integer lasthit;
    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("posts_count")
    @Expose
    private Integer postsCount;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;
    @SerializedName("views")
    @Expose
    private Integer views;

    /**
     * 
     * @return
     *     The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * 
     * @param comment
     *     The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 
     * @return
     *     The lasthit
     */
    public Integer getLasthit() {
        return lasthit;
    }

    /**
     * 
     * @param lasthit
     *     The lasthit
     */
    public void setLasthit(Integer lasthit) {
        this.lasthit = lasthit;
    }

    /**
     * 
     * @return
     *     The num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 
     * @param num
     *     The num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 
     * @return
     *     The postsCount
     */
    public Integer getPostsCount() {
        return postsCount;
    }

    /**
     * 
     * @param postsCount
     *     The posts_count
     */
    public void setPostsCount(Integer postsCount) {
        this.postsCount = postsCount;
    }

    /**
     * 
     * @return
     *     The score
     */
    public Double getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * 
     * @return
     *     The subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 
     * @param subject
     *     The subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 
     * @return
     *     The timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * @param timestamp
     *     The timestamp
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 
     * @return
     *     The views
     */
    public Integer getViews() {
        return views;
    }

    /**
     * 
     * @param views
     *     The views
     */
    public void setViews(Integer views) {
        this.views = views;
    }

}
