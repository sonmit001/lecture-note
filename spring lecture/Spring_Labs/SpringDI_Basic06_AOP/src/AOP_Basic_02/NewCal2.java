package AOP_Basic_02;

public class NewCal2 implements Cal2{

	@Override
	public int ADD(int a, int b) {
		//보조업무(공통업무 : cross-cutting concern)
		int sum = a + b; //주업무(core concern)
		//보조업무(공통업무 : cross-cutting concern)
		return sum;
	}

	@Override
	public int MUL(int a, int b) {
		//보조업무(공통업무 : cross-cutting concern)
		int mul = a * b; //주업무(core concern)
		//보조업무(공통업무 : cross-cutting concern)
		return mul;
	}

	@Override
	public int SUB(int a, int b) {
		//보조업무(공통업무 : cross-cutting concern)
		int sub = a/b; //주업무(core concern)
		//보조업무(공통업무 : cross-cutting concern)
		return sub;
	}

}
