import com.sdacademy.programcasierie.persistence.dao.BonFiscalDao;
import com.sdacademy.programcasierie.persistence.dao.ObjectFileScanner;
import com.sdacademy.programcasierie.persistence.ui.BonFiscalUI;
import com.sdacademy.programcasierie.persistence.ui.CartUI;
import com.sdacademy.programcasierie.persistence.ui.CategoryUI;
import com.sdacademy.programcasierie.persistence.ui.ProductUI;
import org.junit.Test;

public class TestCasierie {

    CategoryUI categoryUI = new CategoryUI();
    ProductUI productUI = new ProductUI();
    CartUI cartUI = new CartUI();
    BonFiscalDao bonFiscalDao = new BonFiscalDao();
    BonFiscalUI bonFiscalUI = new BonFiscalUI();

@Test
    public void testCasierie(){

        categoryUI.printCategories();
        productUI.printProducts();
    System.out.println();
    bonFiscalUI.printBons();
 //      productUI.printByCateg("1");


}
}
