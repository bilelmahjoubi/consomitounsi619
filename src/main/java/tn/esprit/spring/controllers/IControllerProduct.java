package tn.esprit.spring.controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.services.IProductService;


@Scope(value = "session")
@ELBeanName(value = "iproductcontroller")
@Join(path = "/", to = "/login.jsf")
@Controller(value = "iproductcontroller")
public class IControllerProduct {
	@Autowired
	IProductService iproductservice; 
	private  List<Product> FOODproducts; 
	private  List<Product> CLOTHERSproducts; 
	private  List<Product> JEWLERYproducts; 
	private  List<Product> HOMEproducts;
	private  List<Product> ARTISANATproducts; 
	
	
	
	public List<Product> getAllDepartements(){
		return iproductservice.getAllProducts();
}
	
	public Product  ajouterProduct(Product product) {
		return 	iproductservice.ajouterProduct(product);
}
	
	public Product getProductById(int idprod) {
		return iproductservice.getProductById(idprod);
	}
	
	public List<Product> getProdByCategoryFood() {
		return iproductservice.getProdByCategoryFood();
	}
    
	public List<Product> getProdByCategoryClothers(){
		return iproductservice.getProdByCategoryClothers();
	}
	public List<Product> getProdByCategoryJEWLERY(){
		return iproductservice.getProdByCategoryJEWLERY();
	}
	public List<Product> getProdByCategoryHOMEELEMENTDECORATION(){
		return iproductservice.getProdByCategoryHOMEELEMENTDECORATION();
	}
	public List<Product> getProdByCategoryARTISANAT(){
		return iproductservice.getProdByCategoryARTISANAT();
	}

	public IProductService getIproductservice() {
		return iproductservice;
	}

	public void setIproductservice(IProductService iproductservice) {
		this.iproductservice = iproductservice;
	}

	public List<Product> getFOODproducts() {
		FOODproducts=iproductservice.getProdByCategoryFood();
		return FOODproducts;
	}

	public void setFOODproducts(List<Product> fOODproducts) {
		FOODproducts = fOODproducts;
	}
	
	
	public List<Product> getCLOTHERSproducts() {
		CLOTHERSproducts=iproductservice.getProdByCategoryClothers();
		return CLOTHERSproducts;
	}

	public void setCLOTHERSproducts(List<Product> cLOTHERSproducts) {
		CLOTHERSproducts = cLOTHERSproducts;
	}
	
	
	

	public List<Product> getJEWLERYproducts() {
		JEWLERYproducts=iproductservice.getProdByCategoryJEWLERY();
		return JEWLERYproducts;
	}

	public void setJEWLERYproducts(List<Product> jEWLERYproducts) {
		JEWLERYproducts = jEWLERYproducts;
	}

	public List<Product> getHOMEproducts() {
		HOMEproducts=iproductservice.getProdByCategoryHOMEELEMENTDECORATION();
		return HOMEproducts;
	}

	public void setHOMEproducts(List<Product> hOMEproducts) {
		HOMEproducts = hOMEproducts;
	}

	

	public List<Product> getARTISANATproducts() {
		ARTISANATproducts=iproductservice.getProdByCategoryARTISANAT();
		return ARTISANATproducts;
	}

	public void setARTISANATproducts(List<Product> aRTISANATproducts) {
		ARTISANATproducts = aRTISANATproducts;
	}

	public String image(int id) {
	       String image = null;
	       try {
	       Product  V=iproductservice.getProductById(id);
	       String str=V.getImage();
	        str.getBytes();
	        byte[] imageInByte= str.getBytes();
	       // InputStream in = new ByteArrayInputStream(imageInByte);
	       // BufferedImage bImageFromConvert = ImageIO.read(in);
	 
	 
	        InputStream in = new ByteArrayInputStream(imageInByte);
		BufferedInputStream bis=new BufferedInputStream(in);
	 
		Image bImageFromConvert=ImageIO.read(bis);
	 
	        if(bImageFromConvert!=null){
	 
			BufferedImage bImg=new BufferedImage(bImageFromConvert.getWidth(null),  bImageFromConvert.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics g=bImg.getGraphics();
			g.drawImage(bImageFromConvert, 0, 0, null);
			g.dispose();
	 
			File file=new File("C:/Users/emna/Documents/workspace-sts-3.9.4.RELEASE/spring-boot-data-jpa-pi-vente/src/main/webapp/resources/imageupload/"+id+".jpg");
			ImageIO.write(bImg, "jpg", file);
	 
		image=file.getName();    
	                    }
	        
	    }
	       
	    catch (Exception e) {
		// ecritureErreurDansFichierLog(e);
	}
	return ("/resources/imageupload/"+image);
	    }

	

	

	
	
	
		
		
	
    }
