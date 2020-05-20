package com.heyou.springboot.elasticsearch;

import com.heyou.springboot.elasticsearch.dao.ArticleRepository;
import com.heyou.springboot.elasticsearch.entity.Article;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@SpringBootTest
class ElasticsearchApplicationTests {
	@Autowired
	private ArticleRepository articleRepository;


	/**
	 * 存储文章到es中
	 */
	@Test
	void saveArticle() {
		String title = "谷歌是如何做Code Review的";
		String content = "Code Review的主要目的是始终保证随着时间的推移，谷歌代码越来越健康，所有Code Review的工具和流程也是针对于此设计的。";
		Article article = createArticle(title, content);
		articleRepository.save(article);
		// 44db8516-1565-4fea-b19b-cc550b47f85d
		System.out.println(article.getId());

		title = "iOS 13大更新曝光：苹果手机或要调整位置权限";
		content = "据外媒报道称，苹果正在对iOS 13系统进行调整，主要是修复之前出现的Bug，并且还打算iOS 13的位置权限设置进行调整，因为这个细节，他们正在接受反垄断调查。";
		Article article2 = createArticle(title, content);
		articleRepository.save(article2);
		// 73a50b15-e1c9-4afd-b675-fba2ffdc6e3e
		System.out.println(article2.getId());

		title = "日媒：中国手机为何在东南亚受欢迎？";
		content = "人类可能地球上是最不珍惜粮食的物种之一，根据全球农业与食品营养问题委员会的统计数据，全球每年食物浪费总量达到 13 亿吨，其中超过一半的水果和蔬菜被浪费。";
		Article article3 = createArticle(title, content);
		articleRepository.save(article3);
		// feec732b-bf04-4c23-97fa-3d28ffd23a83
		System.out.println(article3.getId());
	}


	private static Article createArticle(String title, String content) {
		//UUID模拟ID
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		//创建Article
		Article article = new Article();
		article.setId(id);
		article.setTitle(title);
		article.setContent(content);
		article.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return article;
	}


	/**
	 * 根据Id查询
	 */
	@Test
	void findArticleById() {
		Optional<Article> articleDaoById = articleRepository.findById("feec732b-bf04-4c23-97fa-3d28ffd23a83");

        /* Article(id=feec732b-bf04-4c23-97fa-3d28ffd23a83,
           title=日媒：中国手机为何在东南亚受欢迎？,
           content=人类可能地球上是最不珍惜粮食的物种之一，根据全球农业与食品营养问题委员会的统计数据，全球每年食物浪费总量达到 13 亿吨，其中超过一半的水果和蔬菜被浪费。,
           createTime=2020-04-09 14:48:47)
         */
		System.out.println(articleDaoById.get());
	}


	/**
	 * 根据关键字在文章title中进行搜索
	 * 分词
	 */
	@Test
	void findArticleByTitle() {
		String titleKeyWord = "谷歌中国";
		//matchQuery 会对关键字分词后进行搜索:谷歌中国---> 谷歌  中国
		MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", titleKeyWord);
		QueryBuilders.commonTermsQuery("title", "谷歌中国");
		Iterable<Article> search = articleRepository.search(matchQueryBuilder);
		Iterator<Article> iterator = search.iterator();
		while (iterator.hasNext()) {
			Article next = iterator.next();
			/*
			 * Article(id=44db8516-1565-4fea-b19b-cc550b47f85d,
			 *      title=谷歌是如何做Code Review的,
			 *      content=Code Review的主要目的是始终保证随着时间的推移，谷歌代码越来越健康，所有Code Review的工具和流程也是针对于此设计的。,
			 *      createTime=2020-04-09 14:01:00)
			 * Article(id=f8df737a-fc46-4471-8b80-e2756ca8c85c,
			 *      title=日媒：中国手机为何在东南亚受欢迎？,
			 *      content=人类可能地球上是最不珍惜粮食的物种之一，根据全球农业与食品营养问题委员会的统计数据，全球每年食物浪费总量达到 13 亿吨，其中超过一半的水果和蔬菜被浪费。,
			 *      createTime=2020-04-09 14:02:55)
			 * ... ...
			 */
			System.out.println(next);
		}
	}


	/**
	 * 根据关键字在文章title中进行搜索
	 * 全匹配
	 */
	@Test
	void findArticleByTitle2() {
		String titleKeyWord = "谷歌";
		//matchPhraseQueryBuilder 对关键字不进行分词，全匹配查询
		MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("title", titleKeyWord);
		Iterable<Article> search = articleRepository.search(matchPhraseQueryBuilder);
		Iterator<Article> iterator = search.iterator();
		while (iterator.hasNext()) {
			Article next = iterator.next();
			/*
			 * Article(id=cf7037d7-1b0e-4568-be94-221371903651,
			 *      title=谷歌是如何做Code Review的,
			 *      content=Code Review的主要目的是始终保证随着时间的推移，谷歌代码越来越健康，所有Code Review的工具和流程也是针对于此设计的。,
			 *      createTime=2020-04-09 11:00:00)
			 * Article(id=1fb7c348-3fa2-4c05-aaf3-c677338afd31,
			 *      title=谷歌是如何做Code Review的,
			 *      content=Code Review的主要目的是始终保证随着时间的推移，谷歌代码越来越健康，所有Code Review的工具和流程也是针对于此设计的。,
			 *      createTime=2020-04-09 14:01:00)
			 * ... ...
			 */
			System.out.println(next);
		}
	}


	/**
	 * 根据关键字在文章title中进行搜索
	 * 分页+排序
	 * es应尽量避免深层分页
	 */
	@Test
	void findArticleByTitlePage() {
		Sort createTime = Sort.by("createTime").ascending();
		Pageable pageable = PageRequest.of(0, 1, createTime);

		String titleKeyWord = "谷歌中国";
		//matchQuery 会对关键字分词后进行搜索:谷歌中国---> 谷歌  中国
		MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", titleKeyWord);
		QueryBuilders.commonTermsQuery("title", "谷歌中国");
		Iterable<Article> search = articleRepository.search(matchQueryBuilder, pageable);
		Iterator<Article> iterator = search.iterator();
		while (iterator.hasNext()) {
			Article next = iterator.next();
			/*
			 * Article(id=44db8516-1565-4fea-b19b-cc550b47f85d,
			 *      title=谷歌是如何做Code Review的,
			 *      content=Code Review的主要目的是始终保证随着时间的推移，谷歌代码越来越健康，所有Code Review的工具和流程也是针对于此设计的。,
			 *      createTime=2020-04-09 14:01:00)
			 * ... ...
			 */
			System.out.println(next);
		}
	}

	/**
	 * 删除所有
	 */
	@Test
	void deleteAllArticle() {
		articleRepository.deleteAll();
	}

}
