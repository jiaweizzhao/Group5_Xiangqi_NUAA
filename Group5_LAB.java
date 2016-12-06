Xiangqi Project by Group5

Subsystem:
Permi:
   main
Clive:
   engine
   rules
QG:
   net
   shortage
Susan:
   livechat

Here are the details

package org.xiangqi.main

//The main function
class Xiangqi{
    
    public static void main(String s[]);
}

//Constructors  init
class XiangqiMainFrame extends JFrame {
    
    public XiangqiMainFrame();
    
    private void initialize();// init the data in XiangqiMainFrame
    
    public void createMenu();
    
    public void initChessBoard();
    
    public void initPieces();
    
    public void initLiveChat();
    
}


// Menu Action handle
class XiangqiActionHandle extends JFrame implements ActionListener{
    
    public XiangqiActionHandle();
    
    public void actionPerformed(ActionEvent e);
    
    public void actionMenu();
    
    public void actionStartGameAlone();
    
    public void actionStartGameOnline();
    
    public void actionStartGameFromSaving();
}

//ChessBoard

class ChessBoard extends JPanel implements MouseListener, MouseMotionListener{
    
    public ChessBoard(int width, int height, int axisX, int axisY);
    
    public void paintChessBoard();
    
    public void movePiece();
    
    public void mousePressed(MouseEvent e);
    
    public void mouseDragged(MouseEvent e);
    
    public void mouseReleased(MouseEvent e);
}

//ChessPiece

public class ChessPiece extends JLabel{
    
    public ChessPiece(String name,int width, int height,ChessBoard board);
    
    public paintChessPiece();
    
    public int getWidth();
    
    public int getHeight();
}

//The Point of Chess  (change the location of Chess)

public class ChessPoint{
    
    public ChessPoint(int x,int y,boolean allreadyHave);
    
    public void setPiece(ChessPiece piece, ChessBoard board);
    
    public void changePiece(ChessPiece piece, ChessBoard board);
    
    public int getX();
    
    public int getY();
}



package org.xiangqi.net



class server implements chatAble {
    public void startSocketServer();
    public void setMyDestop();
    public void beginGame();
    public void sendMessage();
}

class client implements chatAble {
    public void startSocketClient();
    public void joinDestop();
    public void sendMessage();
}

class mySocket extends socket {
    overwrite the function from java;
}


package org.xiangqi.shortage

class mysql {
    public void insertData();
    public void getData();
    public void connectDB();
    public void savePlay();
}

package org.xiangqi.livechat //optional

public class liveChatHandleClient extends JFrame{
    
    public liveChatHandleClient(Socket socket);
    
    public void run();
    
    private class TextFieldListener implements ActionListener
    {
        public void actionPerformed(ActionEvent actionEvent)
    }
    
     private class 	emojiListener implements ActionListener
     {
        public void actionPerformed(ActionEvent actionEvent);
        
        public void mouseEntered(MouseEvent  mouseEvent);
        
    }
    public class threadWindow_gitter implements Runnable
    {
        public threadWindow_gitter(JFrame frame);
        
        public void run();
    }
}



服务器


注册
登录     单人游戏  多人游戏（创建游戏 加入游戏）
两个函数  返回字符串

开始游戏触发函数

主操作函数  三个参数
返回操作  返回三个参数

存储 再说

游戏结束触发


聊天待定


rule







