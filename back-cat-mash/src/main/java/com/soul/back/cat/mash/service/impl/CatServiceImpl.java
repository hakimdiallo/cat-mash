package com.soul.back.cat.mash.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soul.back.cat.mash.bean.CatDto;
import com.soul.back.cat.mash.dal.ICatDAL;
import com.soul.back.cat.mash.entity.CatEntity;
import com.soul.back.cat.mash.service.ICatService;

@Service("catService")
public class CatServiceImpl implements ICatService {
  
  private final String DATA_URL = "https://latelier.co/data/cats.json";
  
  @Autowired
  private ObjectMapper mapper;
  
  @Autowired
  private ICatDAL catDal;

  @Override
  public List<CatDto> getCats() {
    return mapEntityToDto(catDal.getCats());
  }

  @Override
  public List<CatDto> getCatsOrderByScore() {
    return mapEntityToDto(catDal.getCatsOrderByScore());
  }

  @Override
  public Integer getNumberOfScores() {
    return catDal.getNumberOfScores();
  }

  @Override
  public List<CatDto> getCatMash() {
    return mapEntityToDto(catDal.getCatMash());
  }

  @Override
  public CatDto voteForCat(String id) {
    return mapper.convertValue(catDal.voteForCat(id), CatDto.class);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<CatEntity> initData() throws RestClientException, URISyntaxException {
    RestTemplate template = new RestTemplate();
    ResponseEntity<Object> response = template.getForEntity(new URI(DATA_URL), Object.class);
    Map<String, List<LinkedHashMap<String, String>>> obj = (Map<String, List<LinkedHashMap<String, String>>>) response.getBody();
    List<LinkedHashMap<String, String>> images = obj.get("images");
    List<CatEntity> cats = new ArrayList<>();
    for (LinkedHashMap<String, String> list : images) {
      CatEntity cat = new CatEntity();
      cat.setId(list.get("id"));
      cat.setUrl(list.get("url"));
      cat.setScore((int)(Math.random() * 100));
      cats.add(cat);
    }
    return catDal.saveAll(cats);
  }
  
  private List<CatDto> mapEntityToDto(List<CatEntity> catEntities) {
    List<CatDto> catDtos = new ArrayList<>();
    for (CatEntity catEntity : catEntities) {
      CatDto cat = mapper.convertValue(catEntity, CatDto.class);
      catDtos.add(cat);
    }
    return catDtos;
  }
}
