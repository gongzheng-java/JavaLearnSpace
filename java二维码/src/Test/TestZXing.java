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
 * @Date: 2018年5月20日 上午12:23:43
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
	 * 产生二维码
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
			Path file = new File("D:/二维码/img.png").toPath();
			MatrixToImageWriter.writeToPath(bm, format, file);
			System.out.println("二维码图片生成成功!!!!");
		} catch (WriterException e) {
			System.err.println("生成二维码图片失败！");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("生成二维码图片失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 读取二维码
	 */
	public static void readQRCode() {
		try {
			MultiFormatReader reader = new MultiFormatReader();// 需要详细了解MultiFormatReader的小伙伴可以点我一下官方去看文档
			File f = new File("D:/二维码/img.png");
			BufferedImage image = ImageIO.read(f);
			BinaryBitmap bb = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			HashMap map = new HashMap();
			map.put(EncodeHintType.CHARACTER_SET, "utf-8");
			Result result = reader.decode(bb, map);
			System.out.println("解析结果：" + result.toString());
			System.out.println("二维码格式类型：" + result.getBarcodeFormat());
			System.out.println("二维码文本内容：" + result.getText());
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
