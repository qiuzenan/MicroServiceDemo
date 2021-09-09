package user.thrift;

import UserInfo.UserService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import user.service.UserInfoService;

import javax.annotation.PostConstruct;

@Configuration
public class ThriftServer {

    @Autowired
    private UserService.Iface userService;
    @Value("${service.port}")
    private int m_service_port;

    @PostConstruct
    public void startThriftService() throws TTransportException {
        TProcessor tProcessor = new UserService.Processor<>(userService);
        TNonblockingServerSocket tNonblockingServerSocket = new TNonblockingServerSocket(m_service_port);
        TNonblockingServer.Args serverArgs = new TNonblockingServer.Args(tNonblockingServerSocket);
        serverArgs.processor(tProcessor);
        serverArgs.transportFactory(new TFramedTransport.Factory());
        serverArgs.protocolFactory(new org.apache.thrift.protocol.TBinaryProtocol.Factory());
        TServer m_server = new TNonblockingServer(serverArgs);
        m_server.serve();
    }
}
