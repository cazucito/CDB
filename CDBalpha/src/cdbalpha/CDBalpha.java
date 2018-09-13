package cdbalpha;

import com.gs.cdb.model.CasaDeBolsa;
import com.gs.cdb.model.NoExisteClienteException;
import com.gs.cdb.model.ServicioAClienteImpl;
import com.gs.cdb.model.ServicioAClientes;
import com.gs.cdb.model.data.Cliente;
import com.gs.cdb.model.data.Domicilio;
import com.gs.cdb.model.data.GestorLlaves;
import com.gs.cdb.model.data.Portafolio;
import com.gs.cdb.test.ClienteDAOTest;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CDBalpha {
    
    public static void main(String[] args) {
        // BIENVENIDA
        CasaDeBolsa cdb = CasaDeBolsa.getSingleton();
        cdb.imprimeBienvenida();
        // ALTA CLIENTE
        ServicioAClientes servicioCliente = new ServicioAClienteImpl();
        int llaveCliente = GestorLlaves.obtenSigLlave("cliente", "clavecliente");
        int llaveDomicilio = GestorLlaves.obtenSigLlave("domicilio", "iddomicilio");
        Cliente c = new Cliente(
                llaveCliente, "NombreAlta" + llaveCliente, "APaternoAlta" + llaveCliente,
                "AMaternoAlta" + llaveCliente, "RFCAlta" + llaveCliente, LocalDate.of(1999, Month.JUNE, 15),
                new Domicilio(
                        llaveDomicilio,
                        "calleALta" + llaveDomicilio, llaveDomicilio + "Alta",
                        "ColAlta" + llaveDomicilio, "LocalidadAlta" + llaveDomicilio,
                        "EstadoAlta" + llaveDomicilio, llaveDomicilio), new Portafolio());
        
        servicioCliente.altaCliente(c);
        // MOSTRAR CLIENTE
        servicioCliente.consultaCliente(c.getIdCliente()).imprimeResumen();
        // CAMBIAR CLIENTE
        System.out.println("||||| CAMBIO CLIENTE");
        c.setApellidoPaterno("APELLIDO MATERNO CAMBIADO");
        servicioCliente.cambioDatosCliente(c);
        servicioCliente.consultaCliente(c.getIdCliente()).imprimeResumen();
        // BORRAR UN CLIENTE
        System.out.println("||||| BAJA CLIENTE");
        servicioCliente.bajaCliente(c.getIdCliente());
        servicioCliente.consultaCliente(c.getIdCliente());
        // LISTAR ACCIONES
        
        // COMPRAR 3 ACCIONES
        // HISTORICO DE MOVIMIENTOS
        // LISTAR ACCIONES DEL CLIENTE
        // VENDER 1 ACCIÓN
        // HISTORICO DE MOVIMIENTOS
        // DETERMINAR UTILIDAD DE LAS ACCIONES
        // DESPEDIDA
    }
    
}
