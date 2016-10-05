package uaiContacts.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfByte;
//import org.opencv.core.MatOfRect;
//import org.opencv.core.Point;
//import org.opencv.core.Rect;
//import org.opencv.core.Scalar;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//import org.opencv.objdetect.CascadeClassifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import uaiContacts.model.User;

@Controller
@RequestMapping(value = "/hellojasperreport")
public class HelloJasperReportController {
	
	// Report created and download client side:

	@RequestMapping(value = "pdf", method = RequestMethod.GET)
	@ResponseBody
	public void getPdfReport(HttpServletResponse response) throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/HelloWorldJasperReport.jasper");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("testKey", "testString or valud");
		
		  List<User> userList = new ArrayList<User>();
		  
		  for (int i = 0; i <100; i++) {
			  User user = new User();
			  user.setName("name"+i);
			  user.setEmail("email"+i);
			  userList.add(user);
		}
		  
		  JRBeanCollectionDataSource ds1 = new  JRBeanCollectionDataSource(userList);
		  params.put("ds1", ds1);
		
		
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	
	@Autowired @Qualifier("pdf2")
	private JasperReportsPdfView helloReport;
	
	// Report opened in browser
	@Bean @Qualifier("pdf2")
	public JasperReportsPdfView getHelloWorldReport() {
	  JasperReportsPdfView v = new JasperReportsPdfView();
	  v.setUrl("classpath:/HelloWorldJasperReport.jasper");
	  v.setReportDataKey("datasource");
	  return v;
	}
	
	@RequestMapping(value = "pdf2", method = RequestMethod.GET)
	public ModelAndView getRpt2(ModelAndView modelAndView) {
	  Map<String, Object> parameterMap = new HashMap<String, Object>();
	  parameterMap.put("testKey", "testString or valud");
	  
	  List<User> userList = new ArrayList<User>();
	  
	  for (int i = 0; i <100; i++) {
		  User user = new User();
		  user.setName("name"+i);
		  user.setEmail("email"+i);
		  userList.add(user);
	}
	  
	  JRBeanCollectionDataSource ds1 = new  JRBeanCollectionDataSource(userList);
	  parameterMap.put("ds1", ds1);
		
	  parameterMap.put("datasource", new JREmptyDataSource());
	  modelAndView = new ModelAndView(helloReport, parameterMap);
	  return modelAndView;
	}

}
