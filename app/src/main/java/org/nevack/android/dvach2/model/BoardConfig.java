package org.nevack.android.dvach2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BoardConfig {

    @SerializedName("bump_limit")
    @Expose
    private Integer bumpLimit;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("default_name")
    @Expose
    private String defaultName;
    @SerializedName("enable_likes")
    @Expose
    private Integer enableLikes;
    @SerializedName("enable_posting")
    @Expose
    private Integer enablePosting;
    @SerializedName("enable_thread_tags")
    @Expose
    private Integer enableThreadTags;
    @SerializedName("icons")
    @Expose
    private List<BoardConfigIcon> icons;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("sage")
    @Expose
    private Integer sage;
    @SerializedName("tripcodes")
    @Expose
    private Integer tripcodes;

    /**
     *
     * @return
     * The bumpLimit
     */
    public Integer getBumpLimit() {
        return bumpLimit;
    }

    /**
     *
     * @param bumpLimit
     * The bump_limit
     */
    public void setBumpLimit(Integer bumpLimit) {
        this.bumpLimit = bumpLimit;
    }

    /**
     *
     * @return
     * The category
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     * The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return
     * The defaultName
     */
    public String getDefaultName() {
        return defaultName;
    }

    /**
     *
     * @param defaultName
     * The default_name
     */
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    /**
     *
     * @return
     * The enableLikes
     */
    public Integer getEnableLikes() {
        return enableLikes;
    }

    /**
     *
     * @param enableLikes
     * The enable_likes
     */
    public void setEnableLikes(Integer enableLikes) {
        this.enableLikes = enableLikes;
    }

    /**
     *
     * @return
     * The enablePosting
     */
    public Integer getEnablePosting() {
        return enablePosting;
    }

    /**
     *
     * @param enablePosting
     * The enable_posting
     */
    public void setEnablePosting(Integer enablePosting) {
        this.enablePosting = enablePosting;
    }

    /**
     *
     * @return
     * The enableThreadTags
     */
    public Integer getEnableThreadTags() {
        return enableThreadTags;
    }

    /**
     *
     * @param enableThreadTags
     * The enable_thread_tags
     */
    public void setEnableThreadTags(Integer enableThreadTags) {
        this.enableThreadTags = enableThreadTags;
    }

    /**
     *
     * @return
     * The icons
     */
    public List<BoardConfigIcon> getIcons() {
        return icons;
    }

    /**
     *
     * @param icons
     * The icons
     */
    public void setIcons(List<BoardConfigIcon> icons) {
        this.icons = icons;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
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
     * The pages
     */
    public Integer getPages() {
        return pages;
    }

    /**
     *
     * @param pages
     * The pages
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     *
     * @return
     * The sage
     */
    public Integer getSage() {
        return sage;
    }

    /**
     *
     * @param sage
     * The sage
     */
    public void setSage(Integer sage) {
        this.sage = sage;
    }

    /**
     *
     * @return
     * The tripcodes
     */
    public Integer getTripcodes() {
        return tripcodes;
    }

    /**
     *
     * @param tripcodes
     * The tripcodes
     */
    public void setTripcodes(Integer tripcodes) {
        this.tripcodes = tripcodes;
    }

}