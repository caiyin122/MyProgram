package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;
import com.leyou.item.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @Auther xcai
 * @Date 2020/2/3
 */

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    /**
     *  根据条件分页查询spu
     * @param key
     * @param saleable
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("spu/page")
    public ResponseEntity<PageResult<SpuBo>> querySpuByPage(
            @RequestParam(value = "key",required = false)String key,
            @RequestParam(value = "saleable",required = false)Boolean saleable,
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "rows",defaultValue = "5")Integer rows

    ){

        PageResult<SpuBo> result = this.goodsService.querySpuByPage(key,saleable,page,rows);
        if(result == null || CollectionUtils.isEmpty(result.getItems())){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);

    }

    /**
     *  新增商品
     * @param spuBo
     * @return
     */
    @PostMapping("goods")
    public ResponseEntity saveGoods(@RequestBody SpuBo spuBo){

        this.goodsService.saveGoods(spuBo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     *  根据spuId查询spuDetail
     * @param spuId
     * @return
     */
    @GetMapping("spu/detail/{spuId}")
    public ResponseEntity<SpuDetail> querySpuDetailBySpuId(@PathVariable("spuId")Long spuId){

        SpuDetail spuDetail = this.goodsService.querySpuDetailBySpuId(spuId);

        if(spuDetail == null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(spuDetail);
    }


    /**
     *  根据id查询Spu
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<Spu> querySpuById(@PathVariable("id")Long id){

        Spu spu = this.goodsService.querySpuById(id);

        if(spu == null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(spu);

    }

    /**
     *  根据spuId查询Sku
     * @param spuId
     * @return
     */
    @GetMapping("sku/list")
    public ResponseEntity<List<Sku>> querySkusBySpuId(@RequestParam("id")Long spuId){

        List<Sku> skus = this.goodsService.querySkuBySpuId(spuId);

        if(CollectionUtils.isEmpty(skus)){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(skus);
    }

    /**
     *  更新商品信息
     * @param spuBo
     * @return
     */
    @PutMapping("goods")
    public ResponseEntity<Void> updateGoods(@RequestBody SpuBo spuBo){

        this.goodsService.updateGoods(spuBo);
        return ResponseEntity.noContent().build();
    }

    /**
     *  根据SkuId查询sku
     * @param skuId
     * @return
     */
    @GetMapping("sku/{skuId}")
    public ResponseEntity<Sku> querySkuBySkuId(@PathParam("skuId")Long skuId){

        Sku sku =this.goodsService.querySkuBySkuId(skuId);
        if(sku == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(sku);
    }
}
