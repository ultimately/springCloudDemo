package com.levlin.vo;

import com.levlin.util.MovieStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: levlin
 * @Date: 2018/8/26
 * @param:
 * @Description:
 */
@Document(collection = "movie")
public class Movie {

    @Id
    @Indexed
    private String id;

    /**
     *海报
     */
    private String posterUrl;

    /**
     *英文名
     */
    private String englishTitle;

    /**
     *中文名
     */
    @Indexed(unique = true)
    private String chineseTitle;

    /**
     *上映年代
     */
    private String releaseYear;

    /**
     *国家
     */
    private String country;

    /**
     *类型
     */
    private Integer type;

    /**
     * 标签
     */
    private String tags;

    /**
     *语言
     */
    private String language;

    /**
     *字幕
     */
    private String subtitle;

    /**
     *评分
     */
    private String score;

    /**
     *视频格式
     */
    private String fileType;

    /**
     * 分辨率
     */
    private String videoSize;

    /**
     *片长
     */
    private String movieTime;

    /**
     *导演
     */
    private String director;

    /**
     *主演
     */
    private List<String> stars = new ArrayList<>();

    /**
     *截图
     */
    private List<String> snapshots = new ArrayList<>();

    /**
     *简介
     */
    private String introduction;

    /**
     *获奖情况
     */
    private String awards;

    /**
     * 迅雷下载链接
     */
    private String thunderDownloadLink;

    /**
     * 发布时间
     */
    private Date publishDate;

    /**
     * 状态 默认0审核中
     */
    private Integer status = MovieStatus.AUDIT.getCode();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getChineseTitle() {
        return chineseTitle;
    }

    public void setChineseTitle(String chineseTitle) {
        this.chineseTitle = chineseTitle;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(String videoSize) {
        this.videoSize = videoSize;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getStars() {
        return stars;
    }

    public void setStars(List<String> stars) {
        this.stars = stars;
    }

    public List<String> getSnapshots() {
        return snapshots;
    }

    public void setSnapshots(List<String> snapshots) {
        this.snapshots = snapshots;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getThunderDownloadLink() {
        return thunderDownloadLink;
    }

    public void setThunderDownloadLink(String thunderDownloadLink) {
        this.thunderDownloadLink = thunderDownloadLink;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
