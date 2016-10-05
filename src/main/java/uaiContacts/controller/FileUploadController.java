package uaiContacts.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/fileupload")
public class FileUploadController {

	@PostConstruct
	private void loadOpenCv() {
		System.load("C:/opencv3/opencv/build/java/x64/opencv_java300.dll");
		System.out.println("opencv_java300 loaded!!");
	}

	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() throws IOException {
    	
        return new ModelAndView("public/fileupload.jsp");
    }
    
    @RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String uploadUserImage(HttpServletRequest request, HttpServletResponse response) {
		MultipartHttpServletRequest mRequest;
		String fileName = "";
		String parentBase64strWithRects = "";
		try {
			mRequest = (MultipartHttpServletRequest) request;
			mRequest.getParameterMap();

			Iterator<String> itr = mRequest.getFileNames();
			
			
			while (itr.hasNext()) {
				MultipartFile mFile = mRequest.getFile(itr.next());
				ByteArrayInputStream bais = new ByteArrayInputStream(mFile.getBytes());
				BufferedImage bufferedImage = ImageIO.read(bais);
				
				File outputfile = new File("buffimage.jpg");
				ImageIO.write(bufferedImage, "jpg", outputfile);
				
				Mat mat = Imgcodecs.imdecode(new MatOfByte(mFile.getBytes()), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
				
				String out = "ouput.png";
		        System.out.println(String.format("Writing %s", mat));
		        Imgcodecs.imwrite(out, mat);
		        
				
				CascadeClassifier faceDetector = new CascadeClassifier("/haarcascade_frontalface_alt.xml");
		 
		        MatOfRect faceDetections = new MatOfRect();
		        faceDetector.detectMultiScale(mat, faceDetections);
		        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
		        
		        for (Rect rect : faceDetections.toArray()) {
		        	Imgproc.rectangle(mat, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),new Scalar(0, 255, 0), 2);
		        }
		        
		        if (faceDetections.toArray().length >0) {
		        	MatOfByte matOfByte = new MatOfByte();
		        	Imgcodecs.imencode(".jpg", mat, matOfByte);
		        	byte[] parenByteArrWithRects = matOfByte.toArray();
		        	
		        	parentBase64strWithRects = Base64.getEncoder().encodeToString(parenByteArrWithRects);
				}
		        
				fileName = mFile.getOriginalFilename();
				System.out.println(fileName);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parentBase64strWithRects;
	}
    
    
}
