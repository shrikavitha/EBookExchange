package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.ApiModel;
import com.example.demo.repository.ApiRepo;

@Service
public class ApiService {
	
     @Autowired
     ApiRepo ar;
     
     public ApiModel saveinfo(ApiModel am) {
 		return ar.save(am);
 	}
 	
     public List<ApiModel> saveinfo(List<ApiModel> s) {
 		return (List<ApiModel>)ar.saveAll(s);
 	}
     
 	public List<ApiModel> showinfo(){
 		return ar.findAll();
 	}
 	public ApiModel changeinfo(ApiModel s) {
		return ar.saveAndFlush(s);
	}
	
	public void deleteinfo(ApiModel s) {
		ar.delete(s);
	}
	
	public void deleteparamid(int id) {
		ar.deleteById(id);
	}
	public String updateinfobyid(int id,ApiModel s)

	{

		ar.saveAndFlush(s);

		if(ar.existsById(id))

		{

			return "Updated";

		}

		else

		{

			return "Enter valid id";

		}
	}
     
	public List<ApiModel> sortinfo(String s){
		return ar.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
    
    public List<ApiModel> getbypage(int pgno,int pgsize)
    {
    	Page<ApiModel> p = ar.findAll(PageRequest.of(pgno, pgsize));
    	return p.getContent();
    }
    public List<ApiModel> get(int i,String s)
	{
		return ar.getInfo(i, s);
	}
	
	public int del(int id)
	{
		return ar.deleteInfo(id);
	}
	public int update(int id,int id1)
	{
		return ar.updateInfo(id,id1);
	}
}
