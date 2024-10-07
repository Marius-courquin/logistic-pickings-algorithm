package com.ig2i.algorithms;

import com.ig2i.instances.models.Article;
import com.ig2i.instances.models.Instance;
import com.ig2i.instances.models.Order;
import com.ig2i.instances.models.Zone;

import java.util.List;

public class AlgorithmV1 extends BaseAlgorithm {

    public AlgorithmV1(Instance instance) {
        super(instance);
    }

    @Override
    void algorithm() {
        List<Zone> zones = null;
        Zone zone_aC_aC = new Zone();
        Zone zone_aD_aC = new Zone();
        Zone zone_aE_aE = new Zone();
        Zone zone_aG_aE = new Zone();
        Zone zone_aH_aH = new Zone();
        Zone zone_aI_aH = new Zone();
        Zone zone_aK_aK = new Zone();
        Zone zone_aL_aK = new Zone();
        Zone zone_aM_aM = new Zone();
        Zone zone_aO_aM = new Zone();
        Zone zone_aQ_aP = new Zone();
        Zone zone_bA_bA = new Zone();
        Zone zone_bC_bC = new Zone();
        Zone zone_bD_bC = new Zone();
        Zone zone_bE_bE = new Zone();
        Zone zone_bG_bE = new Zone();
        Zone zone_bH_bH = new Zone();
        Zone zone_bI_bH = new Zone();
        Zone zone_bK_bK = new Zone();
        Zone zone_bL_bK = new Zone();

        for (Order order : this.instance.getOrders()) {
            for (Article article : order.getArticles()){
                switch (article.getProduct().getLocation().getName().substring(0,5)) {
                    case "aC_aC":
                        zone_aC_aC.addArticle(article);
                        break;
                    case "aD_aC":
                        zone_aD_aC.addArticle(article);
                        break;
                    case "aE_aE":
                        zone_aE_aE.addArticle(article);
                        break;
                    case "aG_aE":
                        zone_aG_aE.addArticle(article);
                        break;
                    case "aH_aH":
                        zone_aH_aH.addArticle(article);
                        break;
                    case "aI_aH":
                        zone_aI_aH.addArticle(article);
                        break;
                    case "aK_aK":
                        zone_aK_aK.addArticle(article);
                        break;
                    case "aL_aK":
                        zone_aL_aK.addArticle(article);
                        break;
                    case "aM_aM":
                        zone_aM_aM.addArticle(article);
                        break;
                    case "aO_aM":
                        zone_aO_aM.addArticle(article);
                        break;
                    case "aQ_aP":
                        zone_aQ_aP.addArticle(article);
                        break;
                    case "bA_bA":
                        zone_bA_bA.addArticle(article);
                        break;
                    case "bC_bC":
                        zone_bC_bC.addArticle(article);
                        break;
                    case "bD_bC":
                        zone_bD_bC.addArticle(article);
                        break;
                    case "bE_bE":
                        zone_bE_bE.addArticle(article);
                        break;
                    case "bG_bE":
                        zone_bG_bE.addArticle(article);
                        break;
                    case "bH_bH":
                        zone_bH_bH.addArticle(article);
                        break;
                    case "bI_bH":
                        zone_bI_bH.addArticle(article);
                        break;
                    case "bK_bK":
                        zone_bK_bK.addArticle(article);
                        break;
                    case "bL_bK":
                        zone_bL_bK.addArticle(article);
                        break;
                    default:
                        System.out.println("La chaîne ne correspond à aucun des cas définis.");
                        break;
                }

            }

        }

    }
}
// pour chaque zone, parcours les articles , crée des cartons pour chaque commande présente dans la liste d'articles
// une fois fini passe à la zone qui suit, check si possibilité de rajouter tous les articles de la commande si déjà un carton
//sinon créé un nouveau carton pour la commande suivante sachant qu'on est limité à un nombre de carton
// et ainsi de suite si carton plein pour une commande et suite alors on continue