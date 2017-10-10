package com.jinkor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jinkor.model.Customer;


@Mapper
public interface CustomerMapper {
	
	public List<Customer> queryFotList();
}
