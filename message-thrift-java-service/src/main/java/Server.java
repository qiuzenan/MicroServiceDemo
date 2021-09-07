import message.MesageService;
import message.MessageServiceImp;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

public class Server {
    private static MessageServiceImp m_service = new MessageServiceImp();
    private static int m_service_port = 12356;
    private static TServer m_server = null;

    private static void createNonblockingServer() throws TTransportException {
        TProcessor tProcessor= new MesageService.Processor<MesageService.Iface>(m_service);
        TNonblockingServerSocket tNonblockingServerSocket = new TNonblockingServerSocket(m_service_port);
        TNonblockingServer.Args serverArgs = new TNonblockingServer.Args(tNonblockingServerSocket);
        serverArgs.processor(tProcessor);
        serverArgs.transportFactory(new TFramedTransport.Factory());
        serverArgs.protocolFactory(new TBinaryProtocol.Factory());
        m_server = new TNonblockingServer(serverArgs);
    }

    private static boolean start(){
        try {
            createNonblockingServer();
        } catch (TTransportException e) {
            e.printStackTrace();
            System.out.println("server start  error");
            return false;
        }
        System.out.println("m_server start");
        m_server.serve();
        return true;
    }

    public static void main(String args[]){
        if(!start()){
            System.exit(0);
        }
    }
}
