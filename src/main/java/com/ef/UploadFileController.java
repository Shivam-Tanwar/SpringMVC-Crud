package com.ef;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadFileController {

	@RequestMapping(value="uploadfile", method=RequestMethod.POST)
	public ModelAndView fileupload(@RequestParam CommonsMultipartFile file, HttpSession session) {
		String path = session.getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();
		try {
			byte barray[] = file.getBytes();
			OutputStream fout = new FileOutputStream(path + "/" + filename);
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			bout.write(barray);
			bout.flush();
			bout.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView("File upload success", "filename", path + "/" + filename);

	}
	@RequestMapping("fileupload")
	public String fileupload() {
		return "fileupload";
		
	}
}
