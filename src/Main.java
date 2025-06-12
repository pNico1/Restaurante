import MetodosDePago.Cupon;
import MetodosDePago.MetodoDePago;
import MetodosDePago.PagoTarjeta;
import MetodosDePago.Tarjeta;
import Notificaciones.Mail;
import Notificaciones.NotificadorMesero;
import Notificaciones.TipoMedioNotificaciones;
import Notificaciones.UserApp;
import PedidosClases.ModificadorPedido;
import PedidosClases.Pedido;
import PedidosClases.PedidoFactory;
import RestauranteClases.Categoria;
import RestauranteClases.Menu;
import RestauranteClases.Plato;
import RestauranteClases.Restaurante;
import TiposPedido.Delivery;
import TiposPedido.Rappi;
import TiposPedido.TakeAway;
import Usuarios.Chef;
import Usuarios.Cliente;
import Usuarios.Mesero;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
                "Ensalada César",
                "Ensalada con lechuga romana, pollo a la parrilla, crutones y aderezo César.",
                8500,
                Arrays.asList("Huevo", "Lácteos", "Anchoas"),
                10
        );

        Plato plato2 = new Plato(
                "Hamburguesa Clásica",
                "Carne de res con queso cheddar, lechuga, tomate, cebolla y pan artesanal.",
                12000,
                Arrays.asList("Gluten", "Lácteos", "Huevo"),
                15
        );

        Plato plato3 = new Plato(
                "Sopa de Mariscos",
                "Caldo de mariscos con camarones, calamares y mejillones.",
                14000,
                Arrays.asList("Mariscos"),
                20
        );

        Plato plato4 = new Plato(
                "Pizza Margarita",
                "Pizza con salsa de tomate, mozzarella fresca y albahaca.",
                11000,
                Arrays.asList("Gluten", "Lácteos"),
                18
        );

        Plato plato5 = new Plato(
                "Pasta Alfredo",
                "Pasta con salsa cremosa de queso parmesano y mantequilla.",
                13000,
                Arrays.asList("Lácteos", "Gluten"),
                17
        );


        //creacion entradas
        Plato entrada1 = new Plato(
                "Bruschettas",
                "Pan tostado con tomate, albahaca, ajo y aceite de oliva.",
                5500,
                Arrays.asList("Gluten"),
                7
        );

        Plato entrada2 = new Plato(
                "Empanadas de Carne",
                "Empanadas horneadas rellenas de carne sazonada con especias.",
                6000,
                Arrays.asList("Gluten", "Huevo"),
                10
        );

        Plato entrada3 = new Plato(
                "Tabla de Quesos",
                "Selección de quesos artesanales con nueces y mermeladas.",
                9500,
                Arrays.asList("Lácteos", "Frutos secos"),
                12
        );


        //creacion postres
        Plato postre1 = new Plato(
                "Cheesecake de Frutos Rojos",
                "Tarta cremosa de queso con base de galleta y cobertura de frutos rojos.",
                7500,
                Arrays.asList("Lácteos", "Gluten", "Huevo"),
                12
        );

        Plato postre2 = new Plato(
                "Brownie con Helado",
                "Brownie de chocolate caliente acompañado con helado de vainilla.",
                8000,
                Arrays.asList("Gluten", "Lácteos", "Huevo", "Frutos secos"),
                10
        );

        Plato postre3 = new Plato(
                "Flan Casero",
                "Flan de huevo tradicional con caramelo y crema.",
                6500,
                Arrays.asList("Lácteos", "Huevo"),
                8
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

        metodoPedro.setCupon(cuponPedro);

        PedidoFactory pedidoFactory = new PedidoFactory();

        Cliente pedro = new Cliente("pedro",new Mail("pedro@gmail.com"), "1122662955");

        Mesero juan = new Mesero("juan");

        NotificadorMesero notificadorJuan = new NotificadorMesero(juan);

        Pedido pedido = pedidoFactory.createPedido(pedro, new Delivery(), new UserApp("Pedro"), resto1, metodoPedro, notificadorJuan);

        ModificadorPedido modificadorGaston = new ModificadorPedido(pedido);
        ModificadorPedido modificadorJuan = new ModificadorPedido(pedido);

        Chef gaston = new Chef("Gaston");


        pedido.agregarPlato(entrada1);
        pedido.agregarPlato(plato1);
        pedido.agregarPlato(postre1);

        juan.modificarPedido(modificadorGaston);   // En preparación
        gaston.modificarPedido(modificadorGaston);   // Listo para entregar + listo para recoger en cocina/no hace nada si es el mozo
        gaston.modificarPedido(modificadorGaston);// Entregado

        MetodoDePago metodoPedro2= new PagoTarjeta(tarjetaPedro, cuponPedro);

        Pedido pedido2 = pedidoFactory.createPedido(pedro, new TakeAway(), new Mail("Pedro"),resto1, metodoPedro2, LocalDateTime.of(2025, 6, 13, 20,30));

        pedido2.agregarPlato(entrada2);
        pedido2.agregarPlato(plato3);
        pedido2.agregarPlato(postre2);

        NotificadorMesero notificadorJuan2 = new NotificadorMesero(juan);
        ModificadorPedido modificadorGaston2 = new ModificadorPedido(pedido2);
        ModificadorPedido modificadorJuan2 = new ModificadorPedido(pedido2);

        juan.modificarPedido(modificadorGaston2);       // No es la hora programada
        juan.modificarPedidoIgual(modificadorGaston2);  // Ignoramos el horario con tal de testear, en espera
        pedido2.calcularTiempo();
        gaston.modificarPedido(modificadorGaston2);     // En preparaciónListo para entregar + listo para recoger en cocina/no hace nada si es el mozo
        gaston.modificarPedido(modificadorGaston2);     // Listo para entregar + listo para recoger en cocina/no hace nada si es el mozo
        gaston.modificarPedido(modificadorGaston2);     // Entregado

    }
}
