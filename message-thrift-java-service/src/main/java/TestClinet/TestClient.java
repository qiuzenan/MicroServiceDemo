package TestClinet;

import message.MesageService;
import message.MessageServiceImp;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

public class TestClient {
    private static TTransport transport = null;
    private static String host = "localhost";
    private static int port = 12356;
    private static TProtocol TProtocolprotocol;

    private static void clentReq() throws TTransportException {
        transport = new TFramedTransport(new TSocket(host,port));
        TProtocolprotocol =new TBinaryProtocol(transport);
        MesageService.Client client = new MesageService.Client(TProtocolprotocol);

        try{
            transport.open();
            client.sendEmailMesaage("qqemail","hello world");
            client.sendMobileMesage("110","hello world");
            transport.close();
        }catch(TException e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws TTransportException {
        clentReq();
    }
}
