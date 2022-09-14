package com.spring.test.sdboard.vo;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component("SDboardVO")
public class SDboardVO {

    private String sd_board_NO;
    private String sd_title;
    private String sd_content;
    private Date sd_regDate;
    private String member_id;

    public String getSd_board_NO() {
        return sd_board_NO;
    }

    public void setSd_board_NO(String sd_board_NO) {
        this.sd_board_NO = sd_board_NO;
    }
    public String getSd_title() {
        return sd_title;
    }

    public void setSd_title(String sd_title) {
        this.sd_title = sd_title;
    }

    public String getSd_content() {
        return sd_content;
    }

    public void setSd_content(String sd_content) {
        this.sd_content = sd_content;
    }

    public Date getSd_regDate() {
        return sd_regDate;
    }

    public void setSd_regDate(Date sd_regDate) {
        this.sd_regDate = sd_regDate;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
}
