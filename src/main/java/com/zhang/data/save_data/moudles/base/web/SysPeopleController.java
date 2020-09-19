package com.zhang.data.save_data.moudles.base.web;

import com.zhang.data.save_data.moudles.base.service.IPeopleService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zlg
 * @date 2020/9/19 0019 上午 9:29
 */
@RestController
@AllArgsConstructor
@RequestMapping("/base/people/")
@Api(value = "查询表字段名称条件", tags = "查询表字段名称条件接口")
public class SysPeopleController {

    @Autowired
    private IPeopleService peopleService;

    @RequestMapping(value = "saveData", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> saveData() {
        Map<String,Object> resMap = new HashMap<String, Object>();
        try {
            peopleService.saveData();
            resMap.put("sucess",true);
            resMap.put("code","同步成功");
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("sucess",false);
            resMap.put("code","同步失败");
            resMap.put("code",e.fillInStackTrace().getMessage());
        }
        return resMap;
    }

}