package user.thrift;


import UserInfo.UserService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

public class ServiceProvider {

    //serverIp
    public   getUserService(String serverIp,int serverPort) throws TTransportException {
        TTransport transport = new TFramedTransport(new TSocket(serverIp,serverPort));
        TProtocol protocol =new TBinaryProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);

        try{
            transport.open();
        }catch(TException e){
            e.printStackTrace();
        }


    }
}

