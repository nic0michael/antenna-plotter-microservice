package za.co.antenna.resource.access;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = { "za.co.antenna" })
public class AccessRequestConfiguration extends WebMvcConfigurationSupport {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// Register public request intercepter with multiple path patterns

		registry.addInterceptor(new AccessPublicRequestInterceptor()).
				addPathPatterns("/pub/**");

		// Register private request intercepter with multiple path patterns

		registry.addInterceptor(new AccessPrivateRequestInterceptor()).
				addPathPatterns("/crtgainfrm/**",
								"/crthpolfrm/**",
								"/crtvswrfrm/**",
								"/crtvpolfrm/**",
								"/pre/**");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		return resolver;
	}
}
