package ca.mcmaster.estore.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import ca.mcmaster.estore.domain.Products;
import ca.mcmaster.estore.service.ProductManageFactory;
import ca.mcmaster.estore.service.ProductManageService;
import ca.mcmaster.estore.utils.PicUtils;
import ca.mcmaster.estore.utils.SaveFiletoLocalUtils;

public class ProductsManageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File repository = new File("F:\\JavaEE_Project\\Estore\\tmp");
		DiskFileItemFactory factory = new DiskFileItemFactory(1024*10, repository);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			Products p = new Products();
			
			Map<String, String[]> map = new HashMap<String, String[]>();
			for(FileItem item : items){
				if(!item.isFormField()){
					String fileName = item.getName();
					String randomName = SaveFiletoLocalUtils.getRandomName(fileName);
					String path = SaveFiletoLocalUtils.getSavePath(randomName);
					File savePath = new File(this.getServletContext().getRealPath("/upload" + path));
					if(!savePath.exists()){
						savePath.mkdirs();
					}
					
					File dest = new File(savePath, randomName);
					IOUtils.copy(item.getInputStream(), new FileOutputStream(dest));
					item.delete();
					PicUtils picUtils = new PicUtils(dest.getCanonicalPath());
					picUtils.resize(200, 200);
					map.put("imgurl", new String[]{dest.toString()});
				}else{
					map.put(item.getFieldName(), new String[]{item.getString("utf-8")});
				}
			}
			String productId = UUID.randomUUID().toString();
			map.put("id", new String[]{productId});
			try {
				BeanUtils.populate(p, map);
				ProductManageFactory pmFactory = new ProductManageFactory();
				ProductManageService service = pmFactory.newInstance();
				service.addProduct(p);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
