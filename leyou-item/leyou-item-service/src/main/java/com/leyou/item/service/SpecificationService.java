package com.leyou.item.service;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Auther xcai
 * @Date 2020/2/2
 */

@Service
public class SpecificationService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    @Autowired
    private SpecParamMapper specParamMapper;

    /**
     *  根据分类id查询参数组
     * @param cid
     * @return
     */

    public List<SpecGroup> queryGroupsByCid(Long cid) {

        SpecGroup record = new SpecGroup();
        record.setCid(cid);

        return this.specGroupMapper.select(record);
    }

    /**
     *  根据gid查询商品规格参数
     * @param gid
     * @return
     */
    public List<SpecParam> queryParams(Long gid,Long cid,Boolean generic,Boolean searching) {

        SpecParam record = new SpecParam();
        record.setGroupId(gid);
        record.setCid(cid);
        record.setGeneric(generic);
        record.setSearching(searching);

        return this.specParamMapper.select(record);
    }


    public List<SpecGroup> queryGroupsWithParam(Long cid) {

        //先查询组的信息
        List<SpecGroup> groups = this.queryGroupsByCid(cid);

        //遍历每一个组，查询每一个组下的相关信息
        groups.forEach(group ->{
            List<SpecParam> params = this.queryParams(group.getId(), null, null, null);
            group.setParams(params);
        });

        return groups;
    }
}
