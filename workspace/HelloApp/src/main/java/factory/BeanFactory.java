package factory;

public class BeanFactory {
	public static TV getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LgTV();
		}
		
		return null;
	}

}
