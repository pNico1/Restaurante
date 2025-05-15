package RestauranteClases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import EstadosPedido.Entregado;
import PedidosClases.Pedido;

public class Restaurante {
    private static File ventas = new File("ventas.txt");
    private Menu menu;
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public Restaurante(Menu menu) {   //Constructor restaurante
        this.menu = menu;
    }

    public void consultarMenu() {
        for (Categoria categoria : menu.obtenerCategorias()) {
            System.out.println("Categoría: " + categoria.getNombre());
            for (Plato plato : categoria.getPlatos()) {
                System.out.println("- " + plato.getNombre() + " $" + plato.getPrecio());
            }
        }
    }

    public void generarReporteVentas(){
        try (FileWriter writer = new FileWriter("ventas.txt", true)) {
            for (Pedido pedido : pedidos) {
                if (pedido.getEstado() instanceof Entregado){       //Si el pedido no fue entregado no lo cuenta
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    String fecha = LocalDateTime.now().format(format);
                    writer.append(fecha+ " ");
                    writer.append("Orden Nº" + String.valueOf(pedido.getNumeroOrden()) + '\n');
                    for (Plato pl : pedido.getPlatos()){
                        writer.append(pl.getNombre()+ "-----" + pl.getPrecio() + '\n');
                    }
                    writer.append('\n');
                    if (pedido.getMetodoDePago().getCupon() != null) {
                        writer.append("Cupon %" + pedido.getMetodoDePago().getCupon().getDescuento() * 100 + '\n');
                    }

                    writer.append("Total: " + pedido.calcularTotal() + '\n');
                    writer.append("------------------------------");
                    writer.append('\n');
                }
            }
            pedidos.clear();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}