import Notificaciones.Mail;
import Notificaciones.NotificacionEmailCliente;
import Notificaciones.NotificadorMesero;
import TiposPedido.TakeAway;
import Usuarios.Chef;
import Usuarios.Cliente;
import Usuarios.Mesero;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Mail pedroMail= new Mail("pedro@gmail.com");
        Cliente pedro=new Cliente("pedro",pedroMail,"1122662955");
        Pedido pedido = new Pedido(pedro,new TakeAway());
        Mesero juan=new Mesero("juan");
        NotificadorMesero notificador = new NotificadorMesero(juan);
        ModificadorPedido modificador = new ModificadorPedido(pedido, notificador);

        Chef gaston = new Chef("Marcos");
        NotificacionEmailCliente pedroNotificacion=new NotificacionEmailCliente(pedido);


        gaston.modificarPedido(modificador);   // En preparación
        gaston.modificarPedido(modificador);   // Listo para entregar + listo para recoger en cocina
        juan.modificarPedido(modificador);// EstadosPedido.Entregado
        gaston.modificarPedido(modificador);

       pedroNotificacion.notificarCliente();

        }


    }
