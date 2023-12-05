package hkdelivery;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfing implements WebMvcConfigurer{

	@Autowired
	InterceptorConfig interceptorConfig;
	//로그인 하지 않아도 되는 페이지와 로그앤 해야 하는 페이지를 지정
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//로그인 안해도 되는 페이지 지정
		List<String> excludeList = new ArrayList<String>();
		excludeList.add("/**/*");
		
		//사실 처음부터 생각을 안해놓고 페이지들을 만들어서 제대로 써먹을 수 없을 듯...
		
		registry.addInterceptor(interceptorConfig)
			.addPathPatterns("/**/*")	//모든 페이지 차단, session 없으면 로그인 페이지로
			.excludePathPatterns(excludeList);	//session 없어도 해당 페이지 그대로 이용
	
	
	
	}
	
}
