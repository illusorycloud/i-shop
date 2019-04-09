package com.illusory.i.shop.service.search.provider.test;

import com.illusory.i.shop.service.search.domain.TbItemResult;
import com.illusory.i.shop.service.search.provider.IShopServiceSearchProviderApplication;
import com.illusory.i.shop.service.search.provider.mapper.TbItemResultMapper;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author illusory
 * @version 1.0.0
 * @date 2019/4/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IShopServiceSearchProviderApplication.class)
public class SearchServiceTest {
    @Autowired
    private SolrClient solrClient;

    @Autowired
    private TbItemResultMapper tbItemResultMapper;

    /**
     * 初始化 Solr
     */
    @Test
    public void testInitSolr() {
        List<TbItemResult> tbItemResults = tbItemResultMapper.selectAll();
        SolrInputDocument document = null;
        for (TbItemResult tbItemResult : tbItemResults) {
            document = new SolrInputDocument();
            document.addField("id", tbItemResult.getId());
            document.addField("tb_item_cid", tbItemResult.getTbItemCid());
            document.addField("tb_item_cname", tbItemResult.getTbItemCname());
            document.addField("tb_item_title", tbItemResult.getTbItemTitle());
            document.addField("tb_item_sell_point", tbItemResult.getTbItemSellPoint());
            document.addField("tb_item_desc", tbItemResult.getTbItemDesc());

            try {
                solrClient.add(document);
                solrClient.commit();
            } catch (SolrServerException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 添加索引库
     */
    @Test
    public void testAddDocument() {
        // 创建文档对象
        SolrInputDocument document = new SolrInputDocument();

        // 向文档中添加域
        document.addField("id", 536563);
        document.addField("tb_item_title", "new2 - 阿尔卡特 (OT-927) 炭黑 联通3G手机 双卡双待");

        // 将文档添加到索引库
        try {
            solrClient.add(document);
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除索引库
     */
    @Test
    public void testDeleteDocument() {
        try {
            solrClient.deleteByQuery("*:*");
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询索引库
     */
    @Test
    public void testQueryDocument() {
        // 创建查询对象
        SolrQuery query = new SolrQuery();

        // 设置查询条件
        query.setQuery("手机");

        // 设置分页
        query.setStart(0);
        query.setRows(10);

        // 设置默认搜索域
        query.set("df", "tb_item_keywords");

        // 设置高亮显示
        query.setHighlight(true);
        query.addHighlightField("tb_item_title");
        query.setHighlightSimplePre("<span style='color:red;'>");
        query.setHighlightSimplePost("</span>");

        try {
            // 执行查询操作
            QueryResponse response = solrClient.query(query);

            // 获取查询结果集
            SolrDocumentList results = response.getResults();

            // 获取高亮显示
            Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

            // 遍历结果集
            for (SolrDocument result : results) {
                String tbItemTitle = "";
                List<String> strings = highlighting.get(result.get("id")).get("tb_item_title");
                if (strings != null && strings.size() > 0) {
                    tbItemTitle = strings.get(0);
                } else {
                    tbItemTitle = (String) result.get("tb_item_title");
                }

                System.out.println(tbItemTitle);
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
