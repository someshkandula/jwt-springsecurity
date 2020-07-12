/**
 * 
 */
package com.somesh.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ksomalin
 *
 */
@Controller
public class PingResource {

	@RequestMapping({ "/ping" })
	@ResponseBody
	public String ping() {
		return "Ping Pong !!!!";
	}

}
