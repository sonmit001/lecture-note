package unit;

public class Tank{

	private int hp=150;
	private String name = "tank";

	public String repair(int hp) {
		// TODO Auto-generated method stub
		int result = this.hp-hp;
		int second = (result/10)*1000;
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "시즈 탱크 수리 완료";
	}
	
}
