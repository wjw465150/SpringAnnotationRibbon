package org.wjw.springannotationribbon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wjw.springannotationribbon.model.User;
import org.wjw.springannotationribbon.service.RemoteService;

public class SpringAnnotationRibbon {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		RibbonConfig ribbonConfig = (RibbonConfig) ctx.getBean(RibbonConfig.class);
		RemoteService service = ribbonConfig.getRemoteService();
		/**
		 * 调用测试
		 */
		User user = new User();
		user.setUsername("hello");
		for (int i = 1; i <= 10; i++) {
			int result = service.getAdd(1, 2);
			System.out.println("result:" + result);

			User userB = service.getOwner(user);
			System.out.println("user:" + userB);
		}

		((ConfigurableApplicationContext) ctx).close();
	}
}
