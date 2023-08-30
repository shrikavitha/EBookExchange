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

import com.example.demo.model.ApiModel;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
	
	@Autowired
	ApiService aser;
	
	@PostMapping("addBook")
	public ApiModel add(@RequestBody ApiModel am) {
		return aser.saveinfo(am);
	}
	
	@PostMapping("add")
	public List<ApiModel> add(@RequestBody List<ApiModel> s) {
		return aser.saveinfo(s);
	}
	
	@GetMapping("showBook")
	public List<ApiModel> show(){
		return aser.showinfo();
	}
	
	@PutMapping("update")
	public ApiModel modify(@RequestBody ApiModel s) {
		return aser.changeinfo(s);
	}
	
	@DeleteMapping("delete")
	public String del(@RequestBody ApiModel s) {
		aser.deleteinfo(s);
		return "Deleted";
	}	
	
	@DeleteMapping("deletebyParam")
	public String deleteMyIdByParam(@RequestParam int id) {
		 aser.deleteparamid(id);
		 return "Deleted successfully";
    }
	@PutMapping("updateid/{id}")

	public String updatenid(@PathVariable int id,@RequestBody ApiModel s)

	{

		return aser.updateinfobyid(id,s);

	}
	
	@GetMapping("sort/{title}")
	public List<ApiModel> sortinfo(@PathVariable String title){
		return aser.sortinfo(title);
	}
	
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<ApiModel> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
	{
		return aser.getbypage(pageno,pagesize);
	}
	@GetMapping("showquery/{id}/{title}")
	public 	List<ApiModel> showBookdetails(@PathVariable int id,@PathVariable String title)
	{
		return aser.get(id, title);
	}
	@DeleteMapping("deletequery/{id}")
	public String deldetails(@PathVariable int id)
	{
		return aser.del(id)+"deleted";
	}
	@PutMapping("updatequery/{newid}/{oldid}")
	public String updatedetails(@PathVariable int newid,@PathVariable int oldid)
	{
		return aser.update(newid, oldid)+"updated";
	}
}