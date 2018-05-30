package unit;

public class Command {

	private int hp = 1500;
	private String name= "command";
	

	public String repair(int hp) {
		int result = this.hp-hp;
		int second = (result/10)*1000;
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return "커맨드 수리 완료";
	}

	
}
