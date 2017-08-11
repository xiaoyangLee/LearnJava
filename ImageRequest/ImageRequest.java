package imagerequest;
/**
 * ImageRequest�࣬��Ҫ���ڻ�ȡ�����ϵ�ͼƬ�������浽����
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
		
		//����url����
		URL url = new URL("https://pic2.zhimg.com/v2-2a29d0f0562c451b39724172b165c761_b.jpg");
		//������
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		//��������ķ�ʽΪGET
		connection.setRequestMethod("GET");
		//��������ʱ��Ӧʱ��:5��
		connection.setConnectTimeout(5*1000);
		//ͨ����������ȡͼƬ����
		InputStream inputStream =connection.getInputStream();
		//�õ�ͼƬ�Ķ��������ݣ��Զ����Ʒ�װ�õ����ݣ�����ͨ���� 
		byte[] data=readInputStream(inputStream);
		//newһ���ļ����󱣴浱ǰ��ͼƬ��Ŀ¼Ϊ��Ŀ¼
		File file=new File("girl.jpg");
		//���������
		FileOutputStream fileOutputStream=new FileOutputStream(file);
		//д������
		fileOutputStream.write(data);
		//�ر������
		fileOutputStream.close();
	}
	
	//readInputStream()������ȡ��������
	public static byte[] readInputStream(InputStream inputStream) throws Exception {
		ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
		//����һ��Buffer�ַ���
		byte[] buffer = new byte[1024];  
		//ÿ�ζ�ȡ���ַ�������,���Ϊ-1,����ȫ����ȡ���
		int len = 0;
		//ʹ����������buffer�������
		while((len=inputStream.read(buffer))!=-1){
			//ʹ���������Bufferд���ݣ��м����������ĸ�λ�ÿ�ʼ����len������ĳ���
			arrayOutputStream.write(buffer,0,len);
		}
		//�ر�������
		inputStream.close();
		//��outstream�������д���ڴ�
		return arrayOutputStream.toByteArray();
		
	}

}