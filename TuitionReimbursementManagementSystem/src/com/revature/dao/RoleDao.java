package com.revature.dao;

import org.apache.log4j.Logger;
import com.revature.connector.Connector;
import com.revature.services.RoleServices;

public class RoleDao implements RoleServices {

	Connector conn = Connector.getConnector();
	Logger log = Logger.getLogger(RoleDao.class.getName());
	
	
	
}
