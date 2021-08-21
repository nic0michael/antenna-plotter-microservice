package za.co.antenna.controllers.error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AntennaErrorController implements ErrorController {
	private static final String PATH = "/WEB-INF/err";

	@RequestMapping(value = PATH)
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.FORBIDDEN.value()) {
				return "/error403.html";
			}

			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "/error404.html";
			}

			if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
				return "/error405.html";
			}
			
			if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "/error500.html";
			}

			return "/errorUnexpected.html";
		}

		return "/errorUnexpected.html";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}