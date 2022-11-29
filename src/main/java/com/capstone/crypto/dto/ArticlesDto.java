package com.capstone.crypto.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "articles")
public class ArticlesDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) int articleId;

    private String title;
    private String date;
    private String src;

    private int type;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
