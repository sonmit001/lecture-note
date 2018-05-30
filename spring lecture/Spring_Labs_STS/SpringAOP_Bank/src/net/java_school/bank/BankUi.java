package net.java_school.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BankUi {

	private Bank bank;

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	private PrintStream stream;

	public void setStream(PrintStream stream) {
		this.stream = stream;
	}

	private String readCommandLine() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String input = br.readLine();
		return input;
	}

	public void startWork() {

		String menu = null;

		do {
			stream.println(" ** 메뉴를 선택하세요 ** ");
			stream.println(" 1 ** 계좌 등록    ");
			stream.println(" 2 ** 계좌 목록    ");
			stream.println(" 3 ** 입금    ");
			stream.println(" 4 ** 출금    ");
			stream.println(" 5 ** 이체    ");
			stream.println(" 6 ** 입출금 명세    ");
			stream.println(" q ** 종료    ");
			stream.println(" ********************** ");
			stream.print(">>");

			try {
				menu = readCommandLine();

				String accountNo = null;
				String name = null;
				String kind = null;
				long amount = 0;

				if (menu.equals("1")) {
					//TODO 계좌등록
					System.out.print("계좌 번호를 입력하세요: ");
					accountNo = this.readCommandLine();
					System.out.print("소유자 이름을 입력하세요: ");
					name = this.readCommandLine();
					System.out.print("계좌 종류를 선택하세요. 일반(n), 마이너스(m):  일반(n): : ");
					kind = this.readCommandLine();
					if (kind.equals("") || kind.equals("n") || kind.equals("m")) {
						if (kind.equals("")) {
							kind = Account.NORMAL;
						} else if (kind.equals("n")) {
							kind = Account.NORMAL;
						} else {
							kind = Account.MINUS;
						}
						bank.addAccount(accountNo, name, kind);
					}

				} else if (menu.equals("2")) {
					//TODO 계좌목록
					List<Account> accounts = bank.getAccounts();
					for (Account account : accounts) {
						stream.println(account);
					}
				} else if (menu.equals("3")) {
					//TODO 입금
					System.out.print("계좌 번호를 입력하세요: ");
					accountNo = this.readCommandLine();
					System.out.print("입금 액을 입력하세요: ");
					amount = Integer.parseInt(this.readCommandLine());
					bank.deposit(accountNo, amount);
				} else if (menu.equals("4")) {
					//TODO 출금
					System.out.print("계좌 번호를 입력하세요: ");
					accountNo = this.readCommandLine();
					System.out.print("출금 액을 입력하세요: ");
					amount = Integer.parseInt(this.readCommandLine());
					bank.withdraw(accountNo, amount);
				} else if (menu.equals("5")) {
					//TODO 이체
					System.out.print("송금 계좌(From) 번호를 입력하세요: ");
					String from = this.readCommandLine();
					System.out.print("입금 계좌(To) 번호를 입력하세요: ");
					String to = this.readCommandLine();
					System.out.print("이체 금액을 입력하세요: ");
					amount = Integer.parseInt(this.readCommandLine());
					bank.transfer(from, to, amount);
				} else if (menu.equals("6")) {
					//TODO 입출금 명세
					System.out.print("계좌 번호를 입력하세요: ");
					accountNo = this.readCommandLine();
					List<Transaction> transactions = bank.getTransactions(accountNo);
					for (Transaction transaction : transactions) {
						stream.println(transaction);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			stream.println();
		} while (!menu.equals("q"));

	}

	public static void main(String[] args) throws Exception {
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BankConfig.class);
		BankUi ui = ctx.getBean(BankUi.class);
		ui.startWork();
		ctx.close();
	}

}