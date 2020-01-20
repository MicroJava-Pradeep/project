package com.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Component
public class UserIdToObjectConverter implements Converter<Object,WhUserType> {

	@Autowired
	private IWhUserTypeService whService;
	@Override
	public WhUserType convert(Object wid) {
		try
		{
		int id=Integer.parseInt((String)wid);
		return whService.getoneWhUserType(id);
		
		}catch (Exception e) {
			// TODO: handle exception
			return new WhUserType();
		}
	}

}
