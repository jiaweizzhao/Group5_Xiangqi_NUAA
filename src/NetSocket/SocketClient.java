package NetSocket;

import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.net.Socket;  
import java.net.SocketException;  
import java.net.UnknownHostException;  
import java.net.InetAddress;  
  
public class SocketClient extends Thread{  
  
    /** 
     * @param args 
     */
	private Socket clientSocket;
	private String ip;
	InputStream receiveData;
    OutputStream sendData;
	public SocketClient(String ipAddress) {
		clientSocket = null;
		ip = ipAddress;
		receiveData = null;
        sendData = null;
	}
	
	public void run() {
		startClient(ip);
	}
	
	public void transferPoint(int chessType,int presentPointX,int presentPointY,int afterPointX,int afterPointY) {
    	String data = Integer.toString(chessType) + " " + Integer.toString(presentPointX) + " " 
    			+ Integer.toString(presentPointY) + " " +Integer.toString(afterPointX) + " " + Integer.toString(afterPointY);
    	try {
			sendData.write(data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void sendDatas() {
    	String data[] ={"First","Second","Third"};
    	byte[] b = new byte[1024];
    	for(int i = 0;i < data.length;i++){
             //发送数据
    		 try{
    		 } catch(Exception e) {
    			 e.printStackTrace(); //打印异常信息
    		 }
    	}
    }
	
    public void startClient(String serverIp) {
    	Socket socket = null;
        //服务器端IP地址
        //服务器端端口号
        int port = 1590;
        //发送内容
        try {
                 //建立连接
        		 clientSocket = new Socket(serverIp,port);
                 System.out.println("开始客户端");
                 //初始化流
                 sendData = clientSocket.getOutputStream();
                 receiveData = clientSocket.getInputStream();
                 int n;
                 byte[] b = new byte[1024];
	    	     while(true) {
	    	    	 n = receiveData.read(b);
	    	    	 if(n != 0) {
	    	    		 String rece = new String(b,0,n);
			             String reces[] = rece.split(" ");
			             int chessType = Integer.parseInt(reces[0]);
			             int presentPointX = Integer.parseInt(reces[1]);
			             int presentPointY = Integer.parseInt(reces[2]);
			             int afterPointX = Integer.parseInt(reces[3]);
			             int afterPointY = Integer.parseInt(reces[1]);
	    	    	 }
	    	    	 sleep(100);
		             //接收数据
		             //输出反馈数据
	    	     }
        } catch (Exception e) {
                 e.printStackTrace(); //打印异常信息
        } finally{
            try {
                //关闭流和连接
            	if(socket != null) {
            		sendData.close();
                    receiveData.close();
                    socket.close();
            	} 	
            } catch (Exception e2) {}
        }
    }
}  