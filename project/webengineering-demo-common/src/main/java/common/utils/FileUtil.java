package common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

public class FileUtil {
	public static String getDocumentByURL(String urlString) {
		StringBuffer document = document = new StringBuffer();
		try {
			
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while((line = reader.readLine())!= null) {
				document.append(line+"/n");
			}
			reader.close();
		}catch (MalformedURLException e) {
			System.out.println("Unable to connect to URL:" + urlString);
		} catch (IOException e) {
			System.out.println("IOException when connecting to URL:" + urlString);
		}
		return document.toString();
	}
	/**	
	 *  文件上传	
	 *   @param is	
	 *   @param fileName	
	 *   @param folderPath	
	 *   @return	*/	
	public static String uploadFile(InputStream is, String fileName, String folderPath)
	{	//上传物理文件到服务器硬盘	
		BufferedInputStream bis = null;	FileOutputStream fos = null;	
		BufferedOutputStream bos = null;	
		String uploadFileName = null;	
		try {	
			// 构建输入缓冲区，提高读取文件的速度	
			bis = new BufferedInputStream(is);	
			// 自动建立文件夹	
			File folder = new File(folderPath);	
			if (!folder.exists()) {
				System.out.println("创建文件夹："+folderPath);
				folder.mkdirs();	
				}	
			// 为了避免中文乱码问题则新生成的文件名 
			uploadFileName = getSuffix(fileName);	
			System.out.println("新生产的文件名："+uploadFileName);
			// 构建写文件的流即输出流	
			fos = new FileOutputStream(new File(folderPath+"/"+uploadFileName));	
			// 构建输出缓冲区，提高写文件的性能
			bos = new BufferedOutputStream(fos);	
			//通过输入流读取数据并将数据通过输出流写到硬盘文件中	
			byte[] buffer = new byte[4096];
			//构建缓冲区	
			int s = 0; 
			while ((s=bis.read(buffer)) != -1) {	
				bos.write(buffer, 0, s);	bos.flush();	
				}	
			} 
		catch (FileNotFoundException e){	
			e.printStackTrace();	
			} 
		catch (IOException e){ 
			e.printStackTrace();	
			} 
		finally {	
			if (bos != null) {	
				try {
					bos.close();	bos = null;
					} 
				catch (IOException e) {
					e.printStackTrace();	
					}	
				}	if (fos != null) {
					try {
						fos.close(); fos = null;	
						} 
					catch (IOException e) {	
						e.printStackTrace();	
						}	
					}	
				if (bis != null) {	
					try { 
						bis.close();	
						bis = null;	
						} 
					catch (IOException e) {
						e.printStackTrace();	
						}	
					}	
				if (is != null) {
					try {	
						is.close();	is = null;
						} 
					catch (IOException e) {	
						e.printStackTrace();	
						}	
					}	
				} 
		return uploadFileName;	
		}	
	private static String getSuffix(String fileName) { 
		String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);	
		//新的图片文件名 = UUID(前8位) + 获取时间戳 (后6位) + fileName后缀	
		String substring = UUID.randomUUID().toString().substring(0, 8);	
		String valueOf = String.valueOf(System.currentTimeMillis());	
		String substring2 = valueOf.substring(valueOf.length()-6, valueOf.length());	
		String suffix = substring + substring2 + "." + extensionName;	
		return suffix;	
		}
}
