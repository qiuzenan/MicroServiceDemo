package message;

import org.apache.thrift.TException;

public class MessageServiceImp implements MesageService.Iface {
    @Override
    public boolean sendMobileMesage(String mobile, String message) throws TException {
        System.out.println("send "+message + " to " + mobile + "successful");
        return true;
    }

    @Override
    public boolean sendEmailMesaage(String email, String message) throws TException {
        System.out.println("send "+message + " to " + email + "successful");
        return true;
    }
}
