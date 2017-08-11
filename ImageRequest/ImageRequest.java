package imagerequest;
/**
 * ImageRequest类，主要用于获取网络上的图片，并保存到本地
 * @author xiaoyang
 *
 */

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class ImageRequest {
	public static void main(String[] args) throws Exception {
		
		//设置url对象
		URL url = new URL("https://pic2.zhimg.com/v2-2a29d0f0562c451b39724172b165c761_b.jpg");
		//打开链接
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		//设置请求的方式为GET
		connection.setRequestMethod("GET");
		//设置请求超时响应时间:5秒
		connection.setConnectTimeout(5*1000);
		//通过输入流获取图片数据
		InputStream inputStream =connection.getInputStream();
		//得到图片的二进制数据，以二进制封装得到数据，具有通用性 
		byte[] data=readInputStream(inputStream);
		//new一个文件对象保存当前的图片，目录为根目录
		File file=new File("girl.jpg");
		//创建输出流
		FileOutputStream fileOutputStream=new FileOutputStream(file);
		//写入数据
		fileOutputStream.write(data);
		//关闭输出流
		fileOutputStream.close();
	}
	
	//readInputStream()函数读取二进制流
	public static byte[] readInputStream(InputStream inputStream) throws Exception {
		ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
		//创建一个Buffer字符串
		byte[] buffer = new byte[1024];  
		//每次读取的字符串长度,如果为-1,代表全部读取完毕
		int len = 0;
		//使用输入流从buffer里把数据
		while((len=inputStream.read(buffer))!=-1){
			//使用输出流往Buffer写数据，中间参数代表从哪个位置开始读，len代表读的长度
			arrayOutputStream.write(buffer,0,len);
		}
		//关闭输入流
		inputStream.close();
		//把outstream里的数据写入内存
		return arrayOutputStream.toByteArray();
		
	}

}