package DI_08_Spring;

//주입되는 parameter
public class JobExcute {
	public JobExcute(String first,int second) {
		System.out.println("String,int");
	}
	public JobExcute(String first,long second) {
		System.out.println("String,long");
	}
	public JobExcute(String first,String second) {
		System.out.println("String,String");
	}
	
	private ArticleDao articledao;
	
	public ArticleDao getArticledao() {
		return articledao;
	}
	public void setArticledao(ArticleDao articledao) {
		this.articledao = articledao;
		System.out.println("ArticleDao : " +  this.articledao);
	}
	
	private int data;
	
	public void setData(int data) {
		this.data = data;
		System.out.println("data value : " + this.data);
	}
	
}
