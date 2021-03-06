package com.soul.back.cat.mash.controller;

import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import com.soul.back.cat.mash.bean.CatDto;
import com.soul.back.cat.mash.entity.CatEntity;
import com.soul.back.cat.mash.service.ICatService;

@RestController
@CrossOrigin
@RequestMapping(value="/api/cat-mash")
public class CatController {
  
  @Autowired
  private ICatService catService;

  @GetMapping("/cats")
  public ResponseEntity<List<CatDto>> getCats() {
    return new ResponseEntity<>(catService.getCats(),HttpStatus.OK);
  }
  
  @GetMapping("/cats-order-score")
  public ResponseEntity<List<CatDto>> getCatsOrderByScore() {
    return new ResponseEntity<>(catService.getCatsOrderByScore(),HttpStatus.OK);
  }
  
  @GetMapping("/cat/scores")
  public ResponseEntity<Integer> getNumberOfScores() {
    return new ResponseEntity<>(catService.getNumberOfScores(),HttpStatus.OK);
  }
  
  @GetMapping("/")
  public ResponseEntity<List<CatDto>> getCatMash() {
    return new ResponseEntity<>(catService.getCatMash(),HttpStatus.OK);
  }
  
  @PostMapping("/cat/vote")
  public ResponseEntity<CatDto> voteForCat(@RequestBody String id) {
    return new ResponseEntity<CatDto>(catService.voteForCat(id),HttpStatus.OK);
  }
  
  @GetMapping("/init/data")
  public ResponseEntity<List<CatEntity>> initData() throws RestClientException, URISyntaxException{
    return new ResponseEntity<>(null, HttpStatus.OK);
  }
}
