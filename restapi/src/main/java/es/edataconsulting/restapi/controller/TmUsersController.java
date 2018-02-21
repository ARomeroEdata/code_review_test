package es.edataconsulting.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import es.edataconsulting.restapi.component.TmUsersConverter;
import es.edataconsulting.restapi.entity.TmUsers;
import es.edataconsulting.restapi.model.TmUsersModel;
import es.edataconsulting.restapi.service.TmUsersService;

@Controller
@RequestMapping("/tmusers")
public class TmUsersController {
	@Autowired
	@Qualifier("tmUsersServiceImpl")
	private TmUsersService tmUsersService;
	
	@Autowired
	@Qualifier("tmUsersConverter")
	private TmUsersConverter tmUsersConverter;
	//Method that returns all TmUsers in the database.
	//CrossOrigin added to be used from another domain, I add this to use this project in one server and be access from front-end project in localhost.
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody String list(){
		List<TmUsers> tmUsersList=tmUsersService.findAll();
		List<TmUsersModel> tmUsersModelList=new ArrayList<>(tmUsersList.size());
		for(TmUsers tmUsers:tmUsersList) {
			tmUsersModelList.add(tmUsersConverter.tmUsers2TmUsersModel(tmUsers));
		}
		return new Gson().toJson(tmUsersModelList);
	}
	//Method that returns one TmUsers by id.
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody String get(@RequestParam(name="id",required=true)int id){
		TmUsers tmUsers=tmUsersService.findById(id);
		if(tmUsers==null) {
			return "User doesn´t exist";
		}
		return new Gson().toJson(tmUsersConverter.tmUsers2TmUsersModel(tmUsers));
	}
	//Add a TmUsers passed by parameter, if succeeded returns the TmUsers after persist it in the database, with the ids assigned: id, roles id..
	@CrossOrigin
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody String add(@RequestBody(required = true) TmUsersModel tmUsersModel) {
		TmUsers tmUsers=tmUsersConverter.tmUsersModel2TmUsers(tmUsersModel);
		tmUsers=tmUsersService.save(tmUsers);
		return tmUsers!=null?new Gson().toJson(tmUsersConverter.tmUsers2TmUsersModel(tmUsers)):null;
	}
}
