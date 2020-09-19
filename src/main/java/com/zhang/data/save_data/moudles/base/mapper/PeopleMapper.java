/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.zhang.data.save_data.moudles.base.mapper;

import com.zhang.data.save_data.moudles.base.model.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface PeopleMapper {

    void saveDatePeopleBatch( @Param("data") List<People> listMap);
}