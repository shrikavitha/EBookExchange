package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.BuyModel;
import com.example.demo.repository.BuyRepo;

@Service
public class BuyService {
	
     @Autowired//to create object 
     BuyRepo ar;
     
     public BuyModel saveinfo(BuyModel am) {
 		return ar.save(am);//post
 	}
 	
     public List<BuyModel> saveinfo(List<BuyModel> s) {
 		return (List<BuyModel>)ar.saveAll(s);//post
 	}
     
 	public List<BuyModel> showinfo(){
 		return ar.findAll();//get
 	}
 	public BuyModel changeinfo(BuyModel s) {
		return ar.saveAndFlush(s);//update
	}
 	public String updateinfobyid(int id,BuyModel s)

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
	
	public void deleteinfo(BuyModel s) 
	{
		ar.delete(s);//delete
	}
	public void deleteparamid(int id) {
		ar.deleteById(id);//deletebyid
	}
	
	public List<BuyModel> sortinfo(String s){
		return ar.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
    
    public List<BuyModel> getbypage(int pgno,int pgsize)
    {
    	Page<BuyModel> p = ar.findAll(PageRequest.of(pgno, pgsize));
    	return p.getContent();
    }
}