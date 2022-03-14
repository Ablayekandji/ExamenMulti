package istia.st.articles.domain;
// Imports
import istia.st.articles.dao.Article;
import istia.st.articles.dao.IArticlesDao;
import istia.st.articles.exception.UncheckedAccessArticlesException;
import java.util.ArrayList;
import java.util.List;

public class AchatsArticles implements IArticlesDomain {
    // Champs
    private IArticlesDao articlesDao; private ArrayList erreurs;
    // Constructeurs
    public AchatsArticles(IArticlesDao articlesDao)
    {
        this.articlesDao = articlesDao;
    }
    // Méthodes
    public ArrayList getErreurs() {
        return null;
    }
    public List getAllArticles() {
        return this.articlesDao.getAllArticles();
    }
    public Article getArticleById(int id) {
        return this.articlesDao.getArticleById(id);
    }
    public void acheter(Panier panier) { }
}
