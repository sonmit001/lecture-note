package net.java_school.bank;

import java.util.List;

public class ShinhanBank implements Bank {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1317940306920472056L;
	private BankDao dao;

	public void setDao(BankDao dao) {
		this.dao = dao;
	}

	public void addAccount(String accountNo, String name, String kind) {
		dao.insertAccount(accountNo, name, kind);
	}

	@Override
	public Account getAccount(String accountNo) {
		return dao.selectOneAccount(accountNo);
	}

	@Override
	public List<Account> findAccountByName(String name) {
		return dao.selectAccountsByName(name);
	}

	@Override
	public List<Account> getAccounts() {
		return dao.selectAllAccounts();
	}

	@Override
	public void deposit(String accountNo, long amount) {
		dao.deposit(accountNo, amount);
	}

	@Override
	public void withdraw(String accountNo, long amount) {
		dao.withdraw(accountNo, amount);
	}

	@Override
	public void transfer(String from, String to, long amount) {
		dao.withdraw(from, amount);
		dao.deposit(to, amount);
	}

	@Override
	public List<Transaction> getTransactions(String accountNo) {
		return dao.selectAllTransactions(accountNo);
	}
}
