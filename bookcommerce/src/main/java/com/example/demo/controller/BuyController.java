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

import com.example.demo.model.BuyModel;
import com.example.demo.service.BuyService;

@RestController
public class BuyController {
	
	@Autowired
	BuyService aser;
	
	@PostMapping("addBookBuyer")
	public BuyModel add(@RequestBody BuyModel am) {
		return aser.saveinfo(am);
	}
	
	@PostMapping("addBuyer")
	public List<BuyModel> add(@RequestBody List<BuyModel> s) {
		return aser.saveinfo(s);
	}
	
	@GetMapping("showBuyer")
	public List<BuyModel> show(){
		return aser.showinfo();
	}
	
	@PutMapping("updateBuyer")
	public BuyModel modify(@RequestBody BuyModel s) {
		return aser.changeinfo(s);
	}
	@PutMapping("updateidBuyer/{id}")

	public String updatenid(@PathVariable int id,@RequestBody BuyModel s)

	{

		return aser.updateinfobyid(id,s);

	}


	
	@DeleteMapping("deleteBuyer")
	public String del(@RequestBody BuyModel s) {
		aser.deleteinfo(s);
		return "Deleted";
	}

	@DeleteMapping("deletebyParamBuyer")
	public String deleteMyIdByParam(@RequestParam int id) {
		 aser.deleteparamid(id);
		 return "Deleted successfully";
    }

	
	@GetMapping("sortbuy/{title}")
	public List<BuyModel> sortinfo(@PathVariable String title){
		return aser.sortinfo(title);
	}
	
	@GetMapping("pagingbuy/{pageno}/{pagesize}")
	public List<BuyModel> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
	{
		return aser.getbypage(pageno,pagesize);
	}
	
}