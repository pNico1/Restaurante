import MetodosDePago.Cupon;
import MetodosDePago.MetodoDePago;
import MetodosDePago.PagoTarjeta;
import MetodosDePago.Tarjeta;
import Notificaciones.Mail;
import Notificaciones.NotificadorMesero;
import PedidosClases.ModificadorPedido;
import PedidosClases.Pedido;
import RestauranteClases.Categoria;
import RestauranteClases.Menu;
import RestauranteClases.Plato;
import RestauranteClases.Restaurante;
import TiposPedido.Delivery;
import TiposPedido.TakeAway;
import Usuarios.Chef;
import Usuarios.Cliente;
import Usuarios.Mesero;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        //Creacion del Menu
        Menu menu = new Menu();
        Categoria principales = new Categoria("Principales");
        Categoria entradas = new Categoria("Entradas");
        Categoria postres = new Categoria("Postres");

        //creacion de platos salados
        Plato plato1 = new Plato(
                "Lomo Saltado",
                "Tiras de res salteadas con cebolla, tomate y papas fritas, acompañado de arroz blanco.",
                35,
                Arrays.asList("soya", "gluten")
        );

        Plato plato2 = new Plato(
                "Paella de Mariscos",
                "Arroz cocinado con caldo de pescado, camarones, calamares, mejillones y azafrán.",
                42,
                Arrays.asList("mariscos")
        );

        Plato plato3 = new Plato(
                "Pollo al Curry",
                "Pechuga de pollo cocida en salsa de curry con leche de coco y verduras.",
                30,
                Arrays.asList("lácteos")
        );

        Plato plato4 = new Plato(
                "Lasagna Boloñesa",
                "Capas de pasta con carne molida, salsa de tomate y queso gratinado.",
                38,
                Arrays.asList("gluten", "lácteos", "huevo")
        );

        Plato plato5 = new Plato(
                "Tacos de Carnitas",
                "Tortillas de maíz rellenas con cerdo desmenuzado, cebolla, cilantro y salsa verde.",
                28,
                Arrays.asList("gluten")
        );


        //creacion entradas
        Plato entrada1 = new Plato(
                "Bruschettas de Tomate",
                "Pan tostado con tomate fresco, ajo, albahaca y aceite de oliva.",
                15,
                Arrays.asList("gluten")
        );

        Plato entrada2 = new Plato(
                "Ceviche Clásico",
                "Pescado fresco marinado en jugo de limón con cebolla morada, cilantro y ají.",
                18,
                Arrays.asList("pescado")
        );

        Plato entrada3 = new Plato(
                "Croquetas de Jamón",
                "Croquetas crujientes rellenas de bechamel y trozos de jamón.",
                16,
                Arrays.asList("gluten", "lácteos")
        );


        //creacion postres
        Plato postre1 = new Plato(
                "Tiramisú",
                "Postre italiano con capas de bizcocho de café, queso mascarpone y cacao en polvo.",
                20,
                Arrays.asList("gluten", "lácteos", "huevo")
        );

        Plato postre2 = new Plato(
                "Helado de Vainilla",
                "Helado cremoso de vainilla natural servido con sirope de chocolate.",
                14,
                Arrays.asList("lácteos")
        );

        //agregamos los platos a las categorias y estas al menu
        principales.agregarPlato(plato1);
        principales.agregarPlato(plato2);
        principales.agregarPlato(plato3);
        principales.agregarPlato(plato4);
        principales.agregarPlato(plato5);

        entradas.agregarPlato(entrada1);
        entradas.agregarPlato(entrada2);
        entradas.agregarPlato(entrada3);

        postres.agregarPlato(postre1);
        postres.agregarPlato(postre2);

        menu.agregarCategoria(principales);
        menu.agregarCategoria(entradas);
        menu.agregarCategoria(postres);

        //crramos el restaurante
        Restaurante resto1=new Restaurante(menu);

        //mostrar menu

        resto1.consultarMenu();

        //creamos cliente y pedido
        LocalDate localDate = LocalDate.of(2027, 2, 25); // Año, mes, día
        Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Cupon cuponPedro=new Cupon("SNFO2OA987G",0.20,true);

        BigInteger numTarjeta = new BigInteger("4027738194624582");

        Tarjeta tarjetaPedro = new Tarjeta("Patagonia",numTarjeta,"Credito","Pedro","Sanchez",fecha);
        MetodoDePago metodoPedro= new PagoTarjeta(tarjetaPedro);

        Cliente pedro = new Cliente("pedro",new Mail("pedro@gmail.com"), "1122662955");
        Pedido pedido = new Pedido(pedro, new TakeAway(), resto1, metodoPedro);

        pedido.agregarPlato(entrada1);
        pedido.agregarPlato(plato1);
        pedido.agregarPlato(postre1);

        Mesero juan = new Mesero("juan");

        NotificadorMesero notificadorJuan = new NotificadorMesero(juan);
        ModificadorPedido modificadorGaston = new ModificadorPedido(pedido, notificadorJuan);
        ModificadorPedido modificadorJuan = new ModificadorPedido(pedido, notificadorJuan);

        Chef gaston = new Chef("Marcos");

        juan.modificarPedido(modificadorGaston);   // En preparación
        gaston.modificarPedido(modificadorGaston);   // Listo para entregar + listo para recoger en cocina/no hace nada si es el mozo
        gaston.modificarPedido(modificadorGaston);// Entregado

        MetodoDePago metodoPedro2= new PagoTarjeta(tarjetaPedro, cuponPedro);

        Pedido pedido2 = new Pedido(pedro, new Delivery(), resto1,metodoPedro2);

        pedido2.agregarPlato(entrada2);
        pedido2.agregarPlato(plato3);
        pedido2.agregarPlato(postre2);

        NotificadorMesero notificadorJuan2 = new NotificadorMesero(juan);
        ModificadorPedido modificadorGaston2 = new ModificadorPedido(pedido2, notificadorJuan);
        ModificadorPedido modificadorJuan2 = new ModificadorPedido(pedido2, notificadorJuan);

        juan.modificarPedido(modificadorGaston2);       // En preparación
        gaston.modificarPedido(modificadorGaston2);     // Listo para entregar + listo para recoger en cocina/no hace nada si es el mozo
        gaston.modificarPedido(modificadorGaston2);     // Entregado

        resto1.generarReporteVentas();
    }
}
