package com.zouftou.grocery.web.dto;

import java.util.Date;

public class OrderDto {

    private Long id;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
