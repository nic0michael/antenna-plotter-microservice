package za.co.antenna.resource.access;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccessRequestController {

	// Angular libraries (no intercepter required)

	@RequestMapping("/angmin")
	public String angularMinHandler() {
		return "ang/angular.min.js";
	}

	@RequestMapping("/angcr1")
	public String angularCr1Handler() {
		return "ang/Chart.min.js";
	}

	@RequestMapping("/angcr2")
	public String angularCr2Handler() {
		return "ang/angular-chart.min.js";
	}

	@RequestMapping("/angcr3")
	public String angularCr3Handler() {
		return "ang/chartjs-plugin-zoom.min.js";
	}

	@RequestMapping("/angcr4")
	public String angularCr4Handler() {
		return "ang/Chart.bundle.min.js";
	}

	@RequestMapping("/angcr5")
	public String angularCr5Handler() {
		return "ang/hammer.min.js";
	}

	@RequestMapping("/angmsg")
	public String angularMessageHandler() {
		return "ang/angular-messages.min.js";
	}

	@RequestMapping("/angrte")
	public String angularRouteHandler() {
		return "ang/angular-route.min.js";
	}

	@RequestMapping("/angtxt")
	public String angularTextHandler() {
		return "ang/textAngular.min.js";
	}

	// Cascading style sheets (no intercepter required)

	@RequestMapping("/csscrt")
	public String cssChartHandler() {
		return "pre/css/crt_man_stylesheet.css";
	}

	@RequestMapping("/csspub")
	public String cssPublicHandler() {
		return "pre/css/pub_man_stylesheet.css";
	}

	// Error pages (no intercepter required)

	@RequestMapping("/err403")
	public String error403Handler() {
		return "err/error403.html";
	}

	// Images (intercepted by AccessPrivateRequestInterceptor)

	@RequestMapping("/imglogo")
	public String imgLogoHandler() {
		return "pre/img/Poynting.jpg";
	}

	// Chart pages (intercepted by AccessPrivateRequestInterceptor)

	@RequestMapping("/crtgainfrm")
	public String chartGainIframeHandler() {
		return "pre/crt/crt_gain_ifrm.html";
	}

	@RequestMapping("/crthpolfrm")
	public String chartHorizontalPolarIFrameHandler() {
		return "pre/crt/crt_hpol_ifrm.html";
	}

	@RequestMapping("/crtvswrfrm")
	public String chartVswrIframeHandler() {
		return "pre/crt/crt_vswr_ifrm.html";
	}

	@RequestMapping("/crtvpolfrm")
	public String chartVerticalPolarIFrameHandler() {
		return "pre/crt/crt_vpol_ifrm.html";
	}

	// Environment administration pages (intercepted by
	// AccessPrivateRequestInterceptor)

	@RequestMapping("/pre")

 String amAdminHomeHandler() {
		return "pre/amAdminHome.html";
	}
}
