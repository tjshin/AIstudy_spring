package com.study.model;

import java.util.Map;

public interface LoginMapper {

	int loginCheck(Map<String, String> map);

	String read(String string);


}
