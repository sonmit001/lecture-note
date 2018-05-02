package DI_06_Spring;

//Mysql , Oracle , Mssql , Sysbase 동일한 함수 (표준화)
public interface ArticleDao {
	void insert(Article article);
}
