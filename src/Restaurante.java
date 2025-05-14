import java.io.File;
import java.util.List;

public class Restaurante {
    private static File ventas = new File("ventas.txt");
    private Menu menu;
    private List<Pedido> pedidos;

    public Restaurante(Menu menu, List<Pedido> pedidos) {   //Constructor restaurante
        this.menu = menu;
        this.pedidos = pedidos;
    }
}