package com.benxiaopao.provider.common.config;

import com.benxiaopao.provider.common.constant.CommonConstant;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
* 读取推荐数据配置类
* @author liupoyang
* @since 2019-05-12
*/
@Configuration
@Slf4j
public class ReadRecommendDataConfig {
   /**
    * 配置文件名称
    */
   @Value("${local.config.recommend.file-name}")
   private String fileName;
   /**
    * 推荐数据容器
    */
   private static Map<Integer, List<String>> recommendDataMap = Maps.newHashMap();

   /**
    * 初始化配置文件
    */
   @Bean
   public Map<Integer, List<String>> initConfig() {
       BufferedReader br = null;
       InputStream in = null;
       try {
           String path= this.getClass().getResource("/").getPath() + fileName;
           br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
           String line = null;
           String[] array = null, subarr = null;
           List<String> temp = null;
           while ((line = br.readLine()) != null) {
               if (!line.trim().isEmpty()) {
                   array = line.trim().split("\t");
                   subarr = array[1].split(",");

                   temp = recommendDataMap.get(Integer.valueOf(array[0]));
                   if(temp == null){
                       temp = Lists.newArrayList();
                       recommendDataMap.put(Integer.valueOf(array[0]), temp);
                   }
                   temp.add(subarr[0].substring(1));
               }
           }
           log.info("#初始化配置文件成功：{}", fileName);
       } catch (Exception e) {
           log.error("#设置配置文件失败：" + fileName, e);
       }
       finally{
           try {
               if(in!=null) in.close();
               if(br!=null) br.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       CommonConstant.recommedDataMap = recommendDataMap;
       return recommendDataMap;
   }
}