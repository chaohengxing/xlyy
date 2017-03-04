package com.aygxy.xlyy.user.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.aygxy.xlyy.user.entity.BaseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping(value = "/sendfile.action", method = RequestMethod.POST)
	@ResponseBody
	public BaseEntity sendfile(HttpServletRequest request) {
		MultipartResolver resolver = new CommonsMultipartResolver(request
				.getSession().getServletContext());
		MultipartHttpServletRequest multipartRequest = resolver
				.resolveMultipart(request);
		MultipartFile file = multipartRequest.getFile("file");
		if (!file.isEmpty()) {
			try {
				String time = Long.toString(new Date().getTime());
				String path = request.getSession().getServletContext()
						.getRealPath("upload/img");
				File ofiFile = new File(path + "/" + time + ".jpg");
				if (!ofiFile.isFile()) {
					ofiFile.createNewFile();

				}
				((CommonsMultipartFile) file).getFileItem().write(ofiFile);
				String url = request.getScheme() + "://"
						+ request.getServerName() + ":"
						+ request.getServerPort() + "/xlyy/upload/img/"
						+ ofiFile.getName();
				return new BaseEntity(200, "上传图片成功！", url);
			} catch (Exception e) {
				return new BaseEntity(-200, "上传图片失败！", null);
			}
		} else {
			return new BaseEntity(-200, "file参数为空", null);
		}

	}

	@RequestMapping(value = "/sendfiles.action", method = RequestMethod.POST)
	@ResponseBody
	public BaseEntity sendfiles(HttpServletRequest request) {
		MultipartResolver resolver = new CommonsMultipartResolver(request
				.getSession().getServletContext());
		MultipartHttpServletRequest multipartRequest = resolver
				.resolveMultipart(request);
		List<MultipartFile> files = multipartRequest.getFiles("files");
		List<String> paths = new ArrayList<String>();
		for (int i = 0; i < files.size(); ++i) {
			final CommonsMultipartFile file = (CommonsMultipartFile) files
					.get(i);
			String time = Long.toString(new Date().getTime());
			String path = request.getSession().getServletContext()
					.getRealPath("upload/img");
			File ofiFile = new File(path + "/" + time + ".jpg");
			if (!file.isEmpty()) {
				try {
					// if (!ofiFile.exists()) {
					// ofiFile.mkdirs();
					// }
					if (!ofiFile.isFile()) {
						ofiFile.createNewFile();

					}
					file.getFileItem().write(ofiFile);
					paths.add(request.getScheme() + "://"
							+ request.getServerName() + ":"
							+ request.getServerPort() + "/xlyy/upload/img/"
							+ ofiFile.getName());
				} catch (Exception e) {
					e.printStackTrace();
					return new BaseEntity(-200, "上传图片失败！try/catch", null);
				}
			}
		}
		try {
			return new BaseEntity(200, "上传图片成功！",
					new ObjectMapper().writeValueAsString(paths));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BaseEntity(-200, "上传图片失败！json try/catch", null);

		}
	}
}
