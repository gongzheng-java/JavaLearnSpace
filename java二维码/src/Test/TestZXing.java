package Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 *
 * @Author: gongZheng
 * @Date: 2018��5��20�� ����12:23:43
 * @Description:
 */
public class TestZXing {
	public static void main(String[] args) {
		File f1 = new File("D:\\hello\\12");
		if (!f1.exists()) {
			f1.mkdirs();

		}
	}

	/**
	 * ������ά��
	 */
	public static void createQRCode() {
		int width = 300;
		int height = 300;
		String format = "png";
		String contents = "https://www.baidu.com/";
		HashMap map = new HashMap();
		map.put(EncodeHintType.CHARACTER_SET, "utf-8");
		map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		map.put(EncodeHintType.MARGIN, 0);
		try {
			BitMatrix bm = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height);
			Path file = new File("D:/��ά��/img.png").toPath();
			MatrixToImageWriter.writeToPath(bm, format, file);
			System.out.println("��ά��ͼƬ���ɳɹ�!!!!");
		} catch (WriterException e) {
			System.err.println("���ɶ�ά��ͼƬʧ�ܣ�");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("���ɶ�ά��ͼƬʧ�ܣ�");
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ��ά��
	 */
	public static void readQRCode() {
		try {
			MultiFormatReader reader = new MultiFormatReader();// ��Ҫ��ϸ�˽�MultiFormatReader��С�����Ե���һ�¹ٷ�ȥ���ĵ�
			File f = new File("D:/��ά��/img.png");
			BufferedImage image = ImageIO.read(f);
			BinaryBitmap bb = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			HashMap map = new HashMap();
			map.put(EncodeHintType.CHARACTER_SET, "utf-8");
			Result result = reader.decode(bb, map);
			System.out.println("���������" + result.toString());
			System.out.println("��ά���ʽ���ͣ�" + result.getBarcodeFormat());
			System.out.println("��ά���ı����ݣ�" + result.getText());
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
