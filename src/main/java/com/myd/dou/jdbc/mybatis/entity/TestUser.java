package com.myd.dou.jdbc.mybatis.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/1 17:37
 * @Description:
 */
@Setter
@Getter
@Builder
public class TestUser implements Serializable{
    private static final long serialVersionUID = -4907049344672717772L;

    private Long id;


    private Long memberId;


    private String realName;


    private String nickname;


    private Date dateCreate;


    private Date dateUpdate;


    private Long deleted;
}
