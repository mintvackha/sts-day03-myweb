package com.example.myweb.user.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myweb.user.UserService;
import com.example.myweb.user.UserVO;

@Controller
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/user/list", method=RequestMethod.GET)
	public String userList(Locale locale, Model model) throws SQLException {
		
		//System.out.println(ds.getConnection());
		//Connection conn = jdbcUtil.getConnection();
		//System.out.println(conn);
		
		List<UserVO> userList = userService.getList(null);
		model.addAttribute("list", userList);
		
		return "user/list";
	}
	
	@RequestMapping(value="/user/detail", method=RequestMethod.GET)
	public String userDetail(@RequestParam("id") String id, Model model) throws SQLException {
		//System.out.println("userDetail >>>> id : " + id);
		
		UserVO vo = new UserVO();
		vo.setId(id);
		UserVO user = userService.getOne(vo);
		model.addAttribute("user", user);
		
		return "user/detail";
	}
	
	@RequestMapping(value="/user/update", method=RequestMethod.GET)
	public String userUpdate(@RequestParam("id") String id, Model model) {
		
		UserVO vo = new UserVO();
		vo.setId(id);
		UserVO user = userService.getOne(vo);
		model.addAttribute("user", user);
		
		return "user/update";
	}
	
	/*@RequestMapping(value="/userUpdate", method=RequestMethod.POST)
	public String userUpdate2(@RequestParam Map<String, String> params, Model model) {
		
		Iterator it = params.entrySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		return "redirect:userList";
	}*/
	
	@RequestMapping(value="/user/update", method=RequestMethod.POST)
	public String userUpdate2(UserVO vo, Model model) {
		
		//System.out.println(vo);
		userService.update(vo);
		
		return "redirect:List.do";
	}
	
	// 설정페이지에서 view-controller 설정으로 대체
	/*@RequestMapping(value="/userWrite", method=RequestMethod.GET)
	public String userWrite(UserVO vo) {
		return "user_write";
	}*/
	
	@RequestMapping(value="/user/write", method=RequestMethod.POST)
	public String userWriteOk(UserVO vo) {
		
		//System.out.println("vo ===> " + vo);
		
		userService.insert(vo);
		
		return "redirect:List.do";
	}
	
	@RequestMapping(value="/user/delete", method=RequestMethod.GET)
	public String userDelete(UserVO vo) {
		
		userService.delete(vo);
		
		return "redirect:List.do";
	}
	
}