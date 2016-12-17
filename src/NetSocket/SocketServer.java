package NetSocket;

import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;  
import java.net.Socket;  
import java.net.SocketAddress;
import java.net.UnknownHostException;
  
public class SocketServer extends Thread{  
  
    //Size of receive buffer  
    private static final int BUFSIZE=32;  
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStream receiveData;
    private OutputStream sendData;
    /** 
     * @param args 
     */
    private String ip;
    public SocketServer() {
    	serverSocket = null;
    	receiveData = null;
    	sendData = null;
    	InetAddress inet;
		try {
			inet = InetAddress.getLocalHost();
			ip = inet.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    public void run() {
    	startServer();
    }
    
    public int getIp() {
    	return Integer.valueOf(ip).intValue();
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
    
    public void startServer() {  
        //Test for correct # of args  
    	 System.out.println("开始运行");
         //监听端口号
         int port = 1590;
         try {
                  //建立连接
                  serverSocket = new ServerSocket(port);
            	  clientSocket = serverSocket.accept();
            	  receiveData = clientSocket.getInputStream();
            	  sendData = clientSocket.getOutputStream();
            	  SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();  
                  System.out.println("开始与客户端沟通 "+ clientAddress);  
                  byte[] b = new byte[1024];
                  int n;
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
				          System.out.println(rece);
	                  }
	                  sleep(100);
                  }
                  //获得连接
         } catch (Exception e) {
                  e.printStackTrace();
                  System.out.println("出错");
         }
    }
    
    
}