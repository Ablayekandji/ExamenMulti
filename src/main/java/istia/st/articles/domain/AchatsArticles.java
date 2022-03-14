package istia.st.articles.domain;
// Imports
import istia.st.articles.dao.Article;
import istia.st.articles.dao.IArticlesDao;
import istia.st.articles.exception.UncheckedAccessArticlesException;
import java.util.ArrayList;
import java.util.List;

public class AchatsArticles implements IArticlesDomain {
    // Champs
    private IArticlesDao articlesDao;
    private ArrayList erreurs;
    private Object synchro = new Object();
    // Constructeurs
    public AchatsArticles(IArticlesDao articlesDao)
    {
        this.articlesDao = articlesDao;
    }
    // Méthodes
    public ArrayList getErreurs() {
        return erreurs;
    }
    public List getAllArticles() {
        return this.articlesDao.getAllArticles();
    }
    public Article getArticleById(int id) {
        return this.articlesDao.getArticleById(id);
    }
    public void acheter(Panier panier) {

        ArrayList achats = panier.getAchats(); erreurs = new ArrayList();
        Article article = null;
        Achat achat = null;
        for (int i = achats.size() - 1; i >= 0; i--) {
        // on récupère l'achat
            achat = (Achat) achats.get(i);
        // on tente de modifier le stock de l'article dans la base
            int nbarticles = articlesDao.changerStockArticle( achat.getArticle().getId(),
                    -achat.getQte());
            // a-t-on réussi ?
            if (nbarticles != 0) {

                achats.remove(i);
            } else { erreurs.add(
                    "Achat article ["
                            + achat.getArticle()
                            + ","
                            + achat.getQte()
                            + "] impossible - Vérifiez son stock");
            }
        }
    }

}


