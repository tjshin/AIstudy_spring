package com.study.model;

import java.util.List;
import java.util.Map;

public interface BbsMapper {

	int create(BbsDTO dto);

	int total(Map map);

	List < BbsDTO > list(Map map);

	void upViewcnt(int bbsno);

	BbsDTO read(int bbsno);

	int passCheck(Map map);

	int update(BbsDTO dto);

	void upAnsnum(Map map);

	int createReply(BbsDTO dto);

	Object readReply(int bbsno);

	int delete(int bbsno);

	int checkRefnum(int bbsno);

}
