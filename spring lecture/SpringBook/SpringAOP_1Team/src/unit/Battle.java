package unit;

public class Battle{

	private int hp=300;
	private String name= "battle";
	
	public String repair(int hp) {
		int result = this.hp-hp;
		int second = (result/10)*1000;
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "배틀 쿠루져 수리 완료";
	}
	
}
