package cn.yyy.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import org.springframework.stereotype.Service;

import cn.yyy.pojo.ImgCheckCode;
import cn.yyy.pojo.User;

@Service
public class RegisterServiceImp {

	public boolean isExistUsername(String username) {
		UserServiceImp userServiceImp = new UserServiceImp();
		User user = userServiceImp.getUserByUsername(username);
		if (user != null)
			return true;
		return false;
	}

	public boolean isExistPhoneNumber(String phone) {
		UserServiceImp userServiceImp = new UserServiceImp();
		User user = userServiceImp.getUserByPhoneNumber(phone);
		if (user != null)
			return true;
		return false;
	}

	public ImgCheckCode getImgCheckCode(int width,int height) {
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics graphics = bufferedImage.getGraphics();
		
		graphics.setColor(getRandColor(200, 255));
		graphics.fillRect(0, 0, width, height);
		
		graphics.setColor(Color.WHITE);
		graphics.drawRect(0, 0, width-1, height-1);
		
		Graphics2D graphics2d = (Graphics2D) graphics;
		
		graphics2d.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		Random random = new Random();
		
		String word = "";
		for (int i = 0; i < 4;i++) {
			int type = random.nextInt(3);
			int offset = random.nextInt(1000);;
			if (type == 0) {	
				word += Integer.toString(offset%10);
			}else if (type == 1) {
				word += Character.toString((char) ('a' + offset%26));
			}else if (type == 2) {
				word += Character.toString((char) ('A'+offset%26));
			}
		}
		
		int x = 10;
		for (int i = 0;i < word.length();i++) {
			graphics2d.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110), 20 + random.nextInt(110)));
			int jiaodu = random.nextInt(60) - 30;
			double theta = jiaodu * Math.PI/180;
			
			char c = word.charAt(i);
			
			graphics2d.rotate(theta,x,20);
			graphics2d.drawString(String.valueOf(c), x, 20);
			graphics2d.rotate(theta, x, 20);
			x += 30;
		}
		ImgCheckCode imgCheckCode = new ImgCheckCode();
		imgCheckCode.setCheckCode(word);
		
		graphics.setColor(getRandColor(160, 200));
		
		int x1;
		int x2;
		int y1;
		int y2;
		for (int i = 0;i < 30;i++) {
			x1 = random.nextInt(width);
			x2 = random.nextInt(12);
			y1 = random.nextInt(height);
			y2 = random.nextInt(12);
			graphics.drawLine(x1, y1, x1 + x2, y1 + y2);
		}
		imgCheckCode.setCheckCodeImg(graphics);
		return imgCheckCode;
	}
	
	/**
	 * 获得随机颜色
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getRandColor(int fc,int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
