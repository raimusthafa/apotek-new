import database.ObatDatabase;
import service.ObatService;
import ui.MenuUtama;

public class App {
    public static void main(String[] args) {
        // Inisialisasi database
        ObatDatabase database = new ObatDatabase();

        // Inisialisasi service
        ObatService obatService = new ObatService(database);

        // Inisialisasi dan jalankan menu
        MenuUtama menu = new MenuUtama(obatService);
        menu.tampilkanMenu();
    }
}
