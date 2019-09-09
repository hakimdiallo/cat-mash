package com.soul.back.cat.mash.dal;

import java.util.List;
import com.soul.back.cat.mash.entity.CatEntity;

public interface ICatDAL {

  List<CatEntity> getCats();
  
  List<CatEntity> getCatsOrderByScore();
  
  Integer getNumberOfScores();
  
  CatEntity voteForCat(String id);

  List<CatEntity> getCatMash();
  
  List<CatEntity> saveAll(List<CatEntity> cats);
}
