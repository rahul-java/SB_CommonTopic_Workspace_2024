package com.mea.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mea.entity.Tourist;
import com.mea.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist-api")
public class TouristOperationsController {

	@Autowired
	private ITouristMgmtService touristService;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		try {
			String resultMsg = touristService.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED); //201 CREATED
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report")
	public ResponseEntity<Object> getAllTourist(){
		try {
			List<Tourist> allTourist = touristService.fetchAllTourist();
			return new ResponseEntity<Object>(allTourist,HttpStatus.OK); //200 OK
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Object> showTouristById(@PathVariable("id") Integer tid){
		//try {
			Tourist touristById = touristService.fetchTouristById(tid);
			return new ResponseEntity<Object>(touristById,HttpStatus.OK); 
		//} catch (Exception e) {
		//	e.printStackTrace();
		//	return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		//}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist){
		try {
			String resultMsg = touristService.updateTourist(tourist);
			return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/updateBudget/{id}/{percentage}")
	public ResponseEntity<String> updateTouristBudget(@PathVariable("id") Integer tid, @PathVariable("percentage") Double prcnt){
		try {
			String resultMsg = touristService.updateBudgetById(tid, prcnt);
			return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTourist(@PathVariable("id") Integer tid){
		try {
			String resultMsg = touristService.deleteTouristById(tid);
			return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
