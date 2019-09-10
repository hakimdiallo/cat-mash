package com.soul.back.cat.mash.dal.impl;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.soul.back.cat.mash.dal.ICatDAL;
import com.soul.back.cat.mash.entity.CatEntity;

@Repository
public class CatDALImpl implements ICatDAL {
  
  private final MongoTemplate mongoTemplate;
  
  @Autowired
  public CatDALImpl(MongoTemplate mongoTemplate) {
      this.mongoTemplate = mongoTemplate;
  }

  @Override
  public List<CatEntity> getCats() {
    return mongoTemplate.findAll(CatEntity.class);
  }

  @SuppressWarnings("deprecation")
  @Override
  public List<CatEntity> getCatsOrderByScore() {
    Query query = new Query();
    query.with(new PageRequest(0, 10, new Sort(Sort.Direction.DESC, "score")));
    return mongoTemplate.find(query, CatEntity.class);
  }

  @Override
  public Integer getNumberOfScores() {
    List<CatEntity> cats = mongoTemplate.findAll(CatEntity.class);
    Integer sum = 0; 
    for (CatEntity catEntity : cats) {
      sum += catEntity.getScore();
    }
    return sum;
  }

  @Override
  public List<CatEntity> getCatMash() {
    int index = (int)Math.floor(Math.random() * 99);
    List<CatEntity> cats = mongoTemplate.findAll(CatEntity.class);
    Collections.shuffle(cats, new Random());
    return cats.subList(index, index+2);
  }

  @Override
  public CatEntity voteForCat(String id) {
    Query query = new Query();
    query.addCriteria(Criteria.where("id").is(id));
    CatEntity cat = mongoTemplate.findOne(query, CatEntity.class);
    cat.setScore(cat.getScore() + 1);
    return mongoTemplate.save(cat);
  }

  @Override
  public List<CatEntity> saveAll(List<CatEntity> cats) {
    for (CatEntity catEntity : cats) {
      mongoTemplate.save(catEntity);
    }
    return cats;
  }

}
