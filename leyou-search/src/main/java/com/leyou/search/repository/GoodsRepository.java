package com.leyou.search.repository;

import com.leyou.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Auther xcai
 * @Date 2020/2/13
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods,Long> {
}
