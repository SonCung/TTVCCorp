/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b5;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Son Cung
 */
public class Maze {
    static int m,n;
    static int dauQ;
    static int cuoiQ;
    static Point dDau;
    static Point dCuoi;
    static boolean check[][]= new boolean[999][999];
    static Point queue[]=new Point[999];           //hang doi de loang
    static Point truoc[]=new Point[999];           //luu cac o di qua
    static Point path[]=new Point[999];            // luu duong di truy vet
    static int dx[] = {-1, 1, 0, 0};       
    static int dy[] = {0, 0, -1, 1};        
    
    public static void main(String[] args) {
		//
		JFrame framee = new JFrame();
		framee.setSize(650, 470);
		framee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MazePanel mp = new MazePanel();
		framee.add(mp);
                framee.setLocationRelativeTo(null);
		framee.setVisible(true);
	}

	public static class MazePanel extends JPanel {
		private static final long serialVersionUID = -566807999447681130L;
		private int[][] maze = { // khoi tao ma tran mang 2 chieu
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 2, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		private int sizeh, sizew, start, end;

		public MazePanel() {
			// Kich thuoc ma tran
			sizeh = 21;
			sizew = 31;
			start = 10;
			end = 0;
			solve();
			repaint();  // vẽ ma trận và lời giải
		}

		/**
                * Implement một phương pháp tìm đường nào đó.
                 <p>
                Yêu cầu : Vẽ đường đi từ điểm bắt đầu đến điểm kết thúc. Không hiện
                các phần thừa - là các phần đường cụt hoặc đường đi bị sai. Chỉ vẽ
                tuyến đường chính đi từ điểm đầu (màu vàng) đến màu đỏ.
                 <p>
                 Đường đi từ điểm đầu đến điểm cuối được tô màu xanh dương, để tô màu
                 xanh dương hãy set giá trị của điểm trên ma trận sang một số > 2
                 */
		public void solve() {
                    
			// Hàm này chứa phương pháp tìm đường từ điểm start đến vị
                        // trí màu đỏ trên ma trận
                        Init();
                        BFS();
                        Result();
		}
                
                public void Init() {
                    m = 21;
                    n = 31;
                    dDau = new Point(10, 1);
                    dCuoi = new Point(10, 15);
                    for (int i = 1; i <= m; i++) {
                        for (int j = 1; j <= n; j++) {              
                            check[i][j] =false;                 //danh dau tat ca cac o chua xet
                        }
                    }
                    queue[cuoiQ]=new Point(dDau.getX(),dDau.getY());
                    check[dDau.x][dDau.y] = true;               // danh dau diem dau da di qua
                }
                
                public boolean BFS() {
                    Point p;
                    queue[dauQ] = dDau;
                    while (dauQ <= cuoiQ) {                     //Queue chua rong
                        p = queue[dauQ];
                        dauQ++;
                        for (int i = 0; i < 4; i++) {
                            int t1 = p.x + dx[i];
                            int t2 = p.y + dy[i];
                            if (maze[t1][t2] == 1 || t1 < 1 || t1 > m || t2 < 1 || t2 > n) {    // Neu di duoc 4 o xung quanh
                                continue;
                            }
                            if (check[t1][t2] == false) {
                                cuoiQ=cuoiQ+1;
                                queue[cuoiQ]= new Point(t1,t2);
                                check[t1][t2] = true;
                                truoc[cuoiQ]= new Point(p.getX(),p.getY());
                                if (t1 == dCuoi.x && t2 == dCuoi.y) {           // Diem cuoi
                                    return true;
                                }
                            }
                        }
                    }   return false;
                }
                
                public int FindPath() {
                    int d = cuoiQ;
                    int dem = 2;
                    path[1] = dCuoi;
                    path[dem] = truoc[d];
                    while ((truoc[d].x != dDau.x) || (truoc[d].y != dDau.y)) {  // lap toi diem dau
                        for (int k = d - 1; k >= 1; k--) {
                            for (int l = 0; l < 4; l++) {
                                int t1 = truoc[d].x + dx[l];
                                int t2 = truoc[d].y + dy[l];
                                //System.out.println(path[dem]);
                                if ((t1 == truoc[k].x) && (t2 == truoc[k].y)) { 
                                    d = k;
                                    dem++;
                                    path[dem] = truoc[d];                       // Luu cac diem da truy hoi vao path
                                }
                            }
                        }
                    }
                    return dem;
                }
                
                public void Result() {
                int dem = FindPath();
                if (BFS()) {
                System.out.printf("Khong co duong di");
                }   else{
                            System.out.println("Co Duong Di");
                            for (int i = dem; i >= 1; i--) {
                            maze[path[i].x][path[i].y] = 10;
                        }
                    }
                }
		public void paintComponent(Graphics g) // ve ma tran + loi giai
		{
			super.paintComponent(g);
			for (int j = 0; j < sizew; j++)
				for (int i = 0; i < sizeh; i++) {
					if (i == start && j == end)
						g.setColor(Color.yellow);
					else if (maze[i][j] == 0)
						g.setColor(Color.white);
					else if (maze[i][j] == 1)
						g.setColor(Color.black);
					else if (maze[i][j] == 2)
						g.setColor(Color.red);
					else
						g.setColor(Color.blue); // blue la mau cua loi giai
					g.fillRect(j * 20, i * 20, 20, 20);
				}
		}
	}
}
