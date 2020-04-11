package com.leyou.goods.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @Auther xcai
 * @Date 2020/2/18
 */
@Service
public class GoodsHtmlService {

    @Autowired
    private TemplateEngine engine;

    @Autowired
    private GoodsService goodsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsHtmlService.class);


    public void createHtml(Long spuId){

        //初始化运行上下文
        Context context = new Context();
        //设置数据模型
        PrintWriter printWriter = null;
        context.setVariables(this.goodsService.loadData(spuId));
        try {

            //静态文件生成到服务器本地
            File file = new File("F:\\tools\\nginx-1.14.0\\html\\item\\" + spuId + ".html");

            printWriter = new PrintWriter(file);
            this.engine.process("item", context,printWriter);
        } catch (FileNotFoundException e) {
            LOGGER.error("页面静态化出错：{}，"+ e, spuId);
        }finally {
            if(printWriter != null){
                printWriter.close();
            }
        }
    }

    public void deleteHtml(Long id) {

        File file = new File("F:\\tools\\nginx-1.14.0\\html\\item\\" + id + ".html");
        file.deleteOnExit();
    }
}
