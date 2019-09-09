package com.soul.back.cat.mash.service;

import java.net.URISyntaxException;
import java.util.List;
import org.springframework.web.client.RestClientException;
import com.soul.back.cat.mash.bean.CatDto;
import com.soul.back.cat.mash.entity.CatEntity;

public interface ICatService {
  
  List<CatDto> getCats();
  
  List<CatDto> getCatsOrderByScore();
  
  Integer getNumberOfScores();
  
  List<CatDto> getCatMash();

  CatDto voteForCat(String id);
  
  List<CatEntity> initData() throws RestClientException, URISyntaxException;
}
