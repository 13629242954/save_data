package com.zhang.data.save_data.moudles.base.service.impl;

import com.zhang.data.save_data.moudles.base.mapper.PeopleMapper;
import com.zhang.data.save_data.moudles.base.model.People;
import com.zhang.data.save_data.moudles.base.service.IPeopleService;
import com.zhang.data.save_data.moudles.utils.IdCardGenerator;
import com.zhang.data.save_data.moudles.utils.ThreadPoolTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PeopleServiceImpl implements IPeopleService {
    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public void saveData() {
        List<People> listMap;
        for (int i = 0; i < 200000; i++) {
            listMap = new ArrayList<People>();
            long a = System.currentTimeMillis();
            System.out.println("开始时间："+a);
          /*  ThreadPoolTool tool = new ThreadPoolTool(10000,listMap);
            tool.setCallBack(new ThreadPoolTool.CallBack<People>() {
                @Override
                public void method(List<People> listMap) {
                    People people = null;
                    for (int j = 0; j < 100000; j++) {
                        people = new People();
                        people.setId( UUID.randomUUID().toString());
                        people.setCreateDate(new Date());
                        people.setCreateUser( (j + ""));
                        int age = (int) (Math.random() * 100);
                        people.setAge( age);
                        people.setIdCard(new IdCardGenerator().generate());
                        people.setName( createName());
                        people.setPhone(createPhone());
                        people.setOrgId(new IdCardGenerator().getCode());
                        listMap.add(people);
                    }
                }
            });
            try {
                tool.excute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("开始时间："+a);
            People people = null;
            for (int j = 0; j < 100000; j++) {
                people = new People();
                people.setId( UUID.randomUUID().toString());
                people.setCreateDate(new Date());
                people.setCreateUser( (j + ""));
                int age = (int) (Math.random() * 100);
                people.setAge( age);
                people.setIdCard(new IdCardGenerator().generate());
                people.setName( createName());
                people.setPhone(createPhone());
                people.setOrgId(new IdCardGenerator().getCode());
                listMap.add(people);
            }
            long b = System.currentTimeMillis();
            System.out.println("开始时间："+b);
            System.out.println("赋值总耗时："+(b-a));
             peopleMapper.saveDatePeopleBatch(listMap);
            long c = System.currentTimeMillis();
            System.out.println("保存总耗时："+(c-b));
        }


    }

    public String createName(){
        Random rand = new Random();
        char[] letters=new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
                'R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i',
                'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','r',
                '0','1','2','3','4','5','6','7','8','9'};
        String str = "";
        int index;
        boolean[] flags = new boolean[letters.length];//默认为false
        for(int i=0;i<10;i++){
            do{
                index = rand.nextInt(letters.length);
            }while(flags[index]==true);
            char c = letters[index];
            str += c;
            flags[index]=true;
        }
        return str;
    }
    public String createPhone() {
        String number = "13";//定义电话号码以13开头
        Random random = new Random();//定义random，产生随机数
        for (int j = 0; j < 9; j++) {
            //生成0~9 随机数
            number += random.nextInt(10);
        }
        // System.out.println(number);//输出一个电话号码
        return number;
    }
}
