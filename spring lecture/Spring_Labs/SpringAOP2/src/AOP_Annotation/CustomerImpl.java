package AOP_Annotation;

public class CustomerImpl implements Customer {

	@Override
	public void addCustomerBefore() {
		System.out.println("addCustomerBefore() 실행 중...");

	}
	
	@Override
	public void addCustomerAfter() {
		System.out.println("addCustomerAfter() 실행 중...");

	}

	@Override
	public String addCustomerReturnValue() {
		System.out.println("addCustomerReturnValue() 실행 중...");
		return "리턴 합니다";
	}

	@Override
	public void addCustomerThrowException() throws Exception {
		System.out.println("addCustomerThrowException() 실행 중...");
		throw new Exception("Generic Error");
	}

	@Override
	public void addCustomerAround(String name) {
		System.out.println("addCustomerAround() 실행 중, 매개변수 : " + name);

	}

}
