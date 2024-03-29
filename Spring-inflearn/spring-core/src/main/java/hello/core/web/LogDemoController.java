package hello.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class LogDemoController {

	private final LogDemoService logDemoService;
	private final ObjectProvider<MyLogger> myLoggerProvider;

	@GetMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		MyLogger myLogger = myLoggerProvider.getObject();
		String requestURL = request.getRequestURL().toString();
		myLogger.setRequestURL(requestURL);

		myLogger.log("controller test");
		logDemoService.logic("testId");

		return "OK";
	}
}
