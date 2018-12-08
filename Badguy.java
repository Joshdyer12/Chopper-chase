package GamePackage;

import java.awt.Image;
import java.awt.Toolkit;

public class Badguy {

		private int xCoord = 0;
		private int yCoord = 0;
		private int width = 20;
		private int height = 20;
		private Image img;
		
		public Badguy() {
			setxCoord(10);
			setyCoord(10);
			setWidth(30);
			setHeight(30);
			setImg("../Files/helil");
		}
		
		public Badguy(int x, int y, int w, int h, String imgpath) {
				setxCoord(x);
				setyCoord(y);
				setWidth(w);
				setHeight(h);
				setImg(imgpath);
			}
		
			
		public void setImg(String imgpath) {
			this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
		}

		public int getxCoord() {
			return xCoord;
		}

		public void setxCoord(int xCoord) {
			if (xCoord>1400) {
				xCoord = 1400;
				}
			if (xCoord<0) {
				xCoord = 0;
			}
			this.xCoord = xCoord;
		}

		public int getyCoord() {
			return yCoord;
		}

		public void setyCoord(int yCoord) {
			if (yCoord>560) {
				yCoord = 560;
			}
			if (yCoord<0) {
				yCoord = 0;
			}
			this.yCoord = yCoord;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public Image getImg() {
			return img;
		}

		public void setImg(Image img) {
			this.img = img;
		}
		
		
			// TODO Auto-generated constructor stub

}
