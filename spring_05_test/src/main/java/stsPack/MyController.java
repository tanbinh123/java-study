package stsPack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/Freeboard")
	public String freeBoard() {
		return "/freeboard/freeboard";
	}
}
