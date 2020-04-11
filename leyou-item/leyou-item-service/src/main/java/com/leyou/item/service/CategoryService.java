package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther xcai
 * @Date 2020/1/28
 */

@Service
public class CategoryService {


     /*
     * 根据父节点查询子节点
    * */
     @Autowired
     private CategoryMapper categoryMapper;

     public List<Category> queryCategoriesByPid(Long pid){

          Category record = new Category();
          record.setParentId(pid);
          return this.categoryMapper.select(record);
     }


     public List<String> queryByNamesByIds(List<Long> ids){

          List<Category> categories = this.categoryMapper.selectByIdList(ids);
          return categories.stream().map(category -> category.getName()).collect(Collectors.toList());
     }


}

