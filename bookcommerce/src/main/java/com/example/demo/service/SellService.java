package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.SellModel;

import com.example.demo.repository.SellRepo;



@Service
public class SellService {
	
     @Autowired
     SellRepo ar;
     
     public SellModel saveinfo(SellModel am) {
 		return ar.save(am);
 	}
 	
     public List<SellModel> saveinfo(List<SellModel> s) {
 		return (List<SellModel>)ar.saveAll(s);
 	}  
     
 	public List<SellModel> showinfo(){
 		return ar.findAll();
 	}
 	public SellModel changeinfo(SellModel s) {
		return ar.saveAndFlush(s);
	}
	
	public void deleteinfo(SellModel s) {
		ar.delete(s);
	}
	
	public void deleteparamid(int id) {
		ar.deleteById(id);
	}
	public String updateinfobyid(int id,SellModel s)

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
    public List<SellModel> sortinfo(String a)
    {
    	return ar.findAll(Sort.by(Sort.DEFAULT_DIRECTION,a));
    }
    
    public List<SellModel> pageinfo(int pageno,int pagesize)
    {
        Page<SellModel> p = ar.findAll(PageRequest.of(pageno, pagesize));
    	return p.getContent();
    }
}