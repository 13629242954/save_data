package com.zhang.data.save_data.moudles.base.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zlg
 * @date 2020/9/19 0019 上午 9:30
 */
@Data
public class People  implements Serializable {
    private  String id;
    private String name;
    private int age;
    private String phone;
    private String orgId;
    private String idCard;

    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date createDate;
    private String createUser;

}