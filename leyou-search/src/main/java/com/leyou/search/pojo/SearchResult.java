package com.leyou.search.pojo;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;

import java.util.List;
import java.util.Map;

/**
 * @Auther xcai
 * @Date 2020/2/15
 */
public class SearchResult<Goods> extends PageResult<Goods> {

    private List<Map<String,Object>> categoties;
    private List<Brand> brands;
    private List<Map<String,Object>> specs;

    public List<Map<String, Object>> getCategoties() {
        return categoties;
    }

    public void setCategoties(List<Map<String, Object>> categoties) {
        this.categoties = categoties;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public List<Map<String, Object>> getSpecs() {
        return specs;
    }

    public void setSpecs(List<Map<String, Object>> specs) {
        this.specs = specs;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public SearchResult() {
    }

    public SearchResult(List<Map<String, Object>> categoties, List<Brand> brands, List<Map<String, Object>> specs) {
        this.categoties = categoties;
        this.brands = brands;
        this.specs = specs;
    }

    public SearchResult(Long total, List<Goods> items, List<Map<String, Object>> categoties, List<Brand> brands, List<Map<String, Object>> specs) {
        super(total, items);
        this.categoties = categoties;
        this.brands = brands;
        this.specs = specs;
    }

    public SearchResult(Long total, Integer totalPage, List<Goods> items, List<Map<String, Object>> categoties, List<Brand> brands, List<Map<String, Object>> specs) {
        super(total, totalPage, items);
        this.categoties = categoties;
        this.brands = brands;
        this.specs = specs;
    }
}
