package DI_06_Spring;

//요청판단(DAO 생성 , DTO 생성하면)
public class WriteArticleService {
	private ArticleDao articledao;
	public WriteArticleService(ArticleDao articledao) {
		this.articledao = articledao;
		System.out.println("WriteArticleService 생성자 호출");
	}
	public void write(Article article) {
		this.articledao.insert(article);
	}
}
