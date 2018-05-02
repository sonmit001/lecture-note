package AOP_Annotation;

public interface Customer {
	void addCustomerBefore();
	void addCustomerAfter();
	String addCustomerReturnValue();
	void addCustomerThrowException() throws Exception;
	void addCustomerAround(String name);
}
