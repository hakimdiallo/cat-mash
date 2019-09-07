package com.soul.back.cat.mash.service;

import java.util.List;
import com.soul.back.cat.mash.bean.CatDto;

public interface ICatService {
  
  List<CatDto> getCats();
  
  List<CatDto> getCatsOrderByScore();
  
  Integer getNumberOfScores();
  
  List<CatDto> getCatMash();

  CatDto voteForCat(int id);
  
  List<CatDto> initData();
}
