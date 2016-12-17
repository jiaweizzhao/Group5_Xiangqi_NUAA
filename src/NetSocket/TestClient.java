package NetSocket;

public class TestClient {
	static String ip = "127.0.0.1";
	private static SocketClient client = new SocketClient(ip);
	private static SocketServer server = new SocketServer();
	private static UserInfo user = new UserInfo();
	
	public static void test() {
		try {
			server.start();
			Thread.sleep(1000);
			System.out.println("休息");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("出错");
		}
		client.start();
		int begin = 0;
		while(true) {
			if(client.sendData != null && begin == 0) {
				System.out.println("2222");
				begin = 1;
				client.transferPoint(1,2,3,4,5);
				break;
			}
			System.out.println("111");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		//test();
		user.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//user.registerSave("wiwry", "8328219a");
	}
	
	public static int gameStarted() {
		server.start();
		int ip = 0;
		try {
			Thread.sleep(1000);
			ip = server.getIp();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ip;
	}
	
	public static int jionGame(String ip) {
		SocketClient client = new SocketClient(ip);
		client.start();//这个在加入房间前执行
		return 1;
	}
	
	public static void transferPoint(int chessType,int presentPointX,int presentPointY,int afterPointX,int afterPointY) {
		if(server != null) {
			server.transferPoint(chessType,presentPointX,presentPointY,afterPointX,afterPointY);
		}
		else if(client != null) {
			client.transferPoint(chessType,presentPointX,presentPointY,afterPointX,afterPointY);
		}
	}
}
