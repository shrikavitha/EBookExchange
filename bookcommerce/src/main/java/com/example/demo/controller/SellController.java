package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SellModel;
import com.example.demo.service.SellService;


@RestController
public class SellController {
	
	@Autowired
	SellService aser;	
	@PostMapping("addSell")
	public SellModel add(@RequestBody SellModel am) {
		return aser.saveinfo(am);
	}
	
	@PostMapping("addBookSell")
	public List<SellModel> add(@RequestBody List<SellModel> s) {
		return aser.saveinfo(s);
	}
	
	@GetMapping("showSell")
	public List<SellModel> show(){
		return aser.showinfo();
	}
	
	@PutMapping("updateSell")
	public SellModel modify(@RequestBody SellModel s) {
		return aser.changeinfo(s);
	}
	
	@DeleteMapping("deleteSell")
	public String del(@RequestBody SellModel s) {
		aser.deleteinfo(s);
		return "Deleted";
	}	
	
	@DeleteMapping("deletebyParamSell")
	public String deleteMyIdByParam(@RequestParam int id) {
		 aser.deleteparamid(id);
		 return "Deleted successfully";
    }
	@PutMapping("updateidSell/{id}")

	public String updatenid(@PathVariable int id,@RequestBody SellModel s)

	{

		return aser.updateinfobyid(id,s);

	}
	@GetMapping("Sort/{str}") 
	public List<SellModel> Sorting(@PathVariable String str)
	{
		return aser.sortinfo(str);
	}
	@GetMapping("Page/{pageno}/{pagesize}")
	public List<SellModel> paging(@PathVariable int pageno, @PathVariable int pagesize)
	{
		return aser.pageinfo(pageno, pagesize);
	}
}