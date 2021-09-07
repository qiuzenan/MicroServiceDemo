namespace java message

service message.message.MesageService{
    bool sendMobileMesage(1:string mobile,2:string message);
    bool sendEmailMesaage(1:string email,2:string message);
}
