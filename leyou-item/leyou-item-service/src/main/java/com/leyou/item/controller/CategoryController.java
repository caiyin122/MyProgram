package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther xcai
 * @Date 2020/1/28
 */

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

        @GetMapping("list")
        public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam(value="pid", defaultValue ="0")Long pid){

                if(pid == null || pid < 0){
                    //400:参数不合法
                    //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                    //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                    return ResponseEntity.badRequest().build();
                }

                List<Category> categoryList = this.categoryService.queryCategoriesByPid(pid);

                if(CollectionUtils.isEmpty(categoryList)){
                    //404:资源服务器未找到
                    //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                    //return ResponseEntity.notFound().build();
                }

                //200:查询成功
                return ResponseEntity.ok(categoryList);

                //程序出错浏览器自己就会产生500的错误 没有必要再进行显示地进行抛出异常

        }

    /**
     *  根据多个分类id查询分类名称
     * @param ids
     * @return
     */
        @GetMapping
        public ResponseEntity<List<String>> queryNamesByIds(@RequestParam("ids")List<Long> ids){

            List<String> names = this.categoryService.queryByNamesByIds(ids);

            if(CollectionUtils.isEmpty(names)){
                //404:资源服务器未找到
                //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                return ResponseEntity.notFound().build();
            }

            //200:查询成功
            return ResponseEntity.ok(names);
        }
}
