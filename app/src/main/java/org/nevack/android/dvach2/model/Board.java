
package org.nevack.android.dvach2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Board {

    @SerializedName("Board")
    @Expose
    private String board;
    @SerializedName("BoardInfo")
    @Expose
    private String boardInfo;
    @SerializedName("BoardInfoOuter")
    @Expose
    private String boardInfoOuter;
    @SerializedName("BoardName")
    @Expose
    private String boardName;
    @SerializedName("advert_bottom_image")
    @Expose
    private String advertBottomImage;
    @SerializedName("advert_bottom_link")
    @Expose
    private String advertBottomLink;
    @SerializedName("advert_top_image")
    @Expose
    private String advertTopImage;
    @SerializedName("advert_top_link")
    @Expose
    private String advertTopLink;
    @SerializedName("board_banner_image")
    @Expose
    private String boardBannerImage;
    @SerializedName("board_banner_link")
    @Expose
    private String boardBannerLink;
    @SerializedName("bump_limit")
    @Expose
    private Integer bumpLimit;
    @SerializedName("default_name")
    @Expose
    private String defaultName;
    @SerializedName("enable_dices")
    @Expose
    private Integer enableDices;
    @SerializedName("enable_flags")
    @Expose
    private Integer enableFlags;
    @SerializedName("enable_icons")
    @Expose
    private Integer enableIcons;
    @SerializedName("enable_images")
    @Expose
    private Integer enableImages;
    @SerializedName("enable_likes")
    @Expose
    private Integer enableLikes;
    @SerializedName("enable_names")
    @Expose
    private Integer enableNames;
    @SerializedName("enable_oekaki")
    @Expose
    private Integer enableOekaki;
    @SerializedName("enable_posting")
    @Expose
    private Integer enablePosting;
    @SerializedName("enable_sage")
    @Expose
    private Integer enableSage;
    @SerializedName("enable_shield")
    @Expose
    private Integer enableShield;
    @SerializedName("enable_subject")
    @Expose
    private Integer enableSubject;
    @SerializedName("enable_thread_tags")
    @Expose
    private Integer enableThreadTags;
    @SerializedName("enable_trips")
    @Expose
    private Integer enableTrips;
    @SerializedName("enable_video")
    @Expose
    private Integer enableVideo;
    @SerializedName("filter")
    @Expose
    private String filter;
    @SerializedName("max_comment")
    @Expose
    private Integer maxComment;
    @SerializedName("max_files_size")
    @Expose
    private Integer maxFilesSize;
    @SerializedName("news")
    @Expose
    private List<News> news;
    @SerializedName("threads")
    @Expose
    private List<Thread> threads;

    /**
     * 
     * @return
     *     The board
     */
    public String getBoard() {
        return board;
    }

    /**
     * 
     * @param board
     *     The Board
     */
    public void setBoard(String board) {
        this.board = board;
    }

    /**
     * 
     * @return
     *     The boardInfo
     */
    public String getBoardInfo() {
        return boardInfo;
    }

    /**
     * 
     * @param boardInfo
     *     The BoardInfo
     */
    public void setBoardInfo(String boardInfo) {
        this.boardInfo = boardInfo;
    }

    /**
     * 
     * @return
     *     The boardInfoOuter
     */
    public String getBoardInfoOuter() {
        return boardInfoOuter;
    }

    /**
     * 
     * @param boardInfoOuter
     *     The BoardInfoOuter
     */
    public void setBoardInfoOuter(String boardInfoOuter) {
        this.boardInfoOuter = boardInfoOuter;
    }

    /**
     * 
     * @return
     *     The boardName
     */
    public String getBoardName() {
        return boardName;
    }

    /**
     * 
     * @param boardName
     *     The BoardName
     */
    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    /**
     * 
     * @return
     *     The advertBottomImage
     */
    public String getAdvertBottomImage() {
        return advertBottomImage;
    }

    /**
     * 
     * @param advertBottomImage
     *     The advert_bottom_image
     */
    public void setAdvertBottomImage(String advertBottomImage) {
        this.advertBottomImage = advertBottomImage;
    }

    /**
     * 
     * @return
     *     The advertBottomLink
     */
    public String getAdvertBottomLink() {
        return advertBottomLink;
    }

    /**
     * 
     * @param advertBottomLink
     *     The advert_bottom_link
     */
    public void setAdvertBottomLink(String advertBottomLink) {
        this.advertBottomLink = advertBottomLink;
    }

    /**
     * 
     * @return
     *     The advertTopImage
     */
    public String getAdvertTopImage() {
        return advertTopImage;
    }

    /**
     * 
     * @param advertTopImage
     *     The advert_top_image
     */
    public void setAdvertTopImage(String advertTopImage) {
        this.advertTopImage = advertTopImage;
    }

    /**
     * 
     * @return
     *     The advertTopLink
     */
    public String getAdvertTopLink() {
        return advertTopLink;
    }

    /**
     * 
     * @param advertTopLink
     *     The advert_top_link
     */
    public void setAdvertTopLink(String advertTopLink) {
        this.advertTopLink = advertTopLink;
    }

    /**
     * 
     * @return
     *     The boardBannerImage
     */
    public String getBoardBannerImage() {
        return boardBannerImage;
    }

    /**
     * 
     * @param boardBannerImage
     *     The board_banner_image
     */
    public void setBoardBannerImage(String boardBannerImage) {
        this.boardBannerImage = boardBannerImage;
    }

    /**
     * 
     * @return
     *     The boardBannerLink
     */
    public String getBoardBannerLink() {
        return boardBannerLink;
    }

    /**
     * 
     * @param boardBannerLink
     *     The board_banner_link
     */
    public void setBoardBannerLink(String boardBannerLink) {
        this.boardBannerLink = boardBannerLink;
    }

    /**
     * 
     * @return
     *     The bumpLimit
     */
    public Integer getBumpLimit() {
        return bumpLimit;
    }

    /**
     * 
     * @param bumpLimit
     *     The bump_limit
     */
    public void setBumpLimit(Integer bumpLimit) {
        this.bumpLimit = bumpLimit;
    }

    /**
     * 
     * @return
     *     The defaultName
     */
    public String getDefaultName() {
        return defaultName;
    }

    /**
     * 
     * @param defaultName
     *     The default_name
     */
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    /**
     * 
     * @return
     *     The enableDices
     */
    public Integer getEnableDices() {
        return enableDices;
    }

    /**
     * 
     * @param enableDices
     *     The enable_dices
     */
    public void setEnableDices(Integer enableDices) {
        this.enableDices = enableDices;
    }

    /**
     * 
     * @return
     *     The enableFlags
     */
    public Integer getEnableFlags() {
        return enableFlags;
    }

    /**
     * 
     * @param enableFlags
     *     The enable_flags
     */
    public void setEnableFlags(Integer enableFlags) {
        this.enableFlags = enableFlags;
    }

    /**
     * 
     * @return
     *     The enableIcons
     */
    public Integer getEnableIcons() {
        return enableIcons;
    }

    /**
     * 
     * @param enableIcons
     *     The enable_icons
     */
    public void setEnableIcons(Integer enableIcons) {
        this.enableIcons = enableIcons;
    }

    /**
     * 
     * @return
     *     The enableImages
     */
    public Integer getEnableImages() {
        return enableImages;
    }

    /**
     * 
     * @param enableImages
     *     The enable_images
     */
    public void setEnableImages(Integer enableImages) {
        this.enableImages = enableImages;
    }

    /**
     * 
     * @return
     *     The enableLikes
     */
    public Integer getEnableLikes() {
        return enableLikes;
    }

    /**
     * 
     * @param enableLikes
     *     The enable_likes
     */
    public void setEnableLikes(Integer enableLikes) {
        this.enableLikes = enableLikes;
    }

    /**
     * 
     * @return
     *     The enableNames
     */
    public Integer getEnableNames() {
        return enableNames;
    }

    /**
     * 
     * @param enableNames
     *     The enable_names
     */
    public void setEnableNames(Integer enableNames) {
        this.enableNames = enableNames;
    }

    /**
     * 
     * @return
     *     The enableOekaki
     */
    public Integer getEnableOekaki() {
        return enableOekaki;
    }

    /**
     * 
     * @param enableOekaki
     *     The enable_oekaki
     */
    public void setEnableOekaki(Integer enableOekaki) {
        this.enableOekaki = enableOekaki;
    }

    /**
     * 
     * @return
     *     The enablePosting
     */
    public Integer getEnablePosting() {
        return enablePosting;
    }

    /**
     * 
     * @param enablePosting
     *     The enable_posting
     */
    public void setEnablePosting(Integer enablePosting) {
        this.enablePosting = enablePosting;
    }

    /**
     * 
     * @return
     *     The enableSage
     */
    public Integer getEnableSage() {
        return enableSage;
    }

    /**
     * 
     * @param enableSage
     *     The enable_sage
     */
    public void setEnableSage(Integer enableSage) {
        this.enableSage = enableSage;
    }

    /**
     * 
     * @return
     *     The enableShield
     */
    public Integer getEnableShield() {
        return enableShield;
    }

    /**
     * 
     * @param enableShield
     *     The enable_shield
     */
    public void setEnableShield(Integer enableShield) {
        this.enableShield = enableShield;
    }

    /**
     * 
     * @return
     *     The enableSubject
     */
    public Integer getEnableSubject() {
        return enableSubject;
    }

    /**
     * 
     * @param enableSubject
     *     The enable_subject
     */
    public void setEnableSubject(Integer enableSubject) {
        this.enableSubject = enableSubject;
    }

    /**
     * 
     * @return
     *     The enableThreadTags
     */
    public Integer getEnableThreadTags() {
        return enableThreadTags;
    }

    /**
     * 
     * @param enableThreadTags
     *     The enable_thread_tags
     */
    public void setEnableThreadTags(Integer enableThreadTags) {
        this.enableThreadTags = enableThreadTags;
    }

    /**
     * 
     * @return
     *     The enableTrips
     */
    public Integer getEnableTrips() {
        return enableTrips;
    }

    /**
     * 
     * @param enableTrips
     *     The enable_trips
     */
    public void setEnableTrips(Integer enableTrips) {
        this.enableTrips = enableTrips;
    }

    /**
     * 
     * @return
     *     The enableVideo
     */
    public Integer getEnableVideo() {
        return enableVideo;
    }

    /**
     * 
     * @param enableVideo
     *     The enable_video
     */
    public void setEnableVideo(Integer enableVideo) {
        this.enableVideo = enableVideo;
    }

    /**
     * 
     * @return
     *     The filter
     */
    public String getFilter() {
        return filter;
    }

    /**
     * 
     * @param filter
     *     The filter
     */
    public void setFilter(String filter) {
        this.filter = filter;
    }

    /**
     * 
     * @return
     *     The maxComment
     */
    public Integer getMaxComment() {
        return maxComment;
    }

    /**
     * 
     * @param maxComment
     *     The max_comment
     */
    public void setMaxComment(Integer maxComment) {
        this.maxComment = maxComment;
    }

    /**
     * 
     * @return
     *     The maxFilesSize
     */
    public Integer getMaxFilesSize() {
        return maxFilesSize;
    }

    /**
     * 
     * @param maxFilesSize
     *     The max_files_size
     */
    public void setMaxFilesSize(Integer maxFilesSize) {
        this.maxFilesSize = maxFilesSize;
    }

    /**
     * 
     * @return
     *     The news
     */
    public List<News> getNews() {
        return news;
    }

    /**
     * 
     * @param news
     *     The news
     */
    public void setNews(List<News> news) {
        this.news = news;
    }

    /**
     * 
     * @return
     *     The threads
     */
    public List<Thread> getThreads() {
        return threads;
    }

    /**
     * 
     * @param threads
     *     The threads
     */
    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

}
