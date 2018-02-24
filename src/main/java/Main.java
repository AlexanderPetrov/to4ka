import com.to4ka.entities.CategoriesEntity;
import com.to4ka.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by User on 2/8/2018.
 */
public class Main {
    public static void main(final String[] args) throws Exception {
        System.out.println("Hello motherfucker");

        createAndSaveCategory("Knifes");
        HibernateUtil.getSessionFactory().close();

        System.out.println("Done.");
    }

    private static void createAndSaveCategory(String name){
        System.out.println("Create category with name " + name);
        System.out.println("Open session");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        System.out.println("Create category");
        CategoriesEntity categoriesEntity = new CategoriesEntity();
        categoriesEntity.setName(name);

        System.out.println("Save and commit transaction");
        session.save(categoriesEntity);
        session.getTransaction().commit();
    }
}