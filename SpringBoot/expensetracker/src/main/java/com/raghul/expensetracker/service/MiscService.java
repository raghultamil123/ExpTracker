package com.raghul.expensetracker.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface MiscService {
	
	public void build() throws JsonParseException, JsonMappingException, IOException;

}
