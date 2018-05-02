package springbook.user.dao;

public class UserDaoFactory {
//UserDao 생산하는 공장을 하나 만들어서 관리
	public UserDao userDao(){
		//NConnectionMaker nconnect = new NConnectionMaker();
		//UserDao dao = new UserDao(nconnect);
		UserDao dao = new UserDao(connectionMaker());
		return dao;
	}
	/* public AccountDao accountDao(){
		NConnectionMaker nconnect = new NConnectionMaker();
		AccountDao dao = new AccountDao(nconnect);
		return dao;
	}
	*/
  
	public ConnectionMaker connectionMaker(){
		//함수가 여러개이면 그 함수마다 써주어야 하는 것을 따로 함수로 빼서 유지보수 용이하게 만든다.
		ConnectionMaker connectmaker = new NConnectionMaker();
		//벤더 마다 바뀌는 코드 :  new NConnectionMaker();
		return connectmaker;
	}




}
