package tn.esprit.spring.controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.omg.CORBA.portable.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itextpdf.html2pdf.HtmlConverter;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.Facture;

import tn.esprit.spring.services.IFactureService;

@Scope(value = "session")
@ELBeanName(value = "icontrollerfacture")
@Join(path = "/", to = "/login.jsf")
@Controller(value = "icontrollerfacture")
public class IControllerFacture {
	
	@Autowired
	IFactureService ifactureservice; 
	private String typefacture;
	private String name;
	private String surname;
	private String tel;
	private String adresse;
	private float total;
	private Date datefac;
	private Integer factureIdToBeUpdated;
	
	
	
	private  List<Facture> factures; 
	
	public List<Facture> getAllfactures(){
		return ifactureservice.getAllfactures();
	}
	
	public Facture ajouterFacture(Facture facture) {
	return 	 ifactureservice.ajouterFacture(facture);
		 
		
	}
	public void affecterFactureAuCommande( int idcommande) {
		 ifactureservice.affecterFactureAuCommande( idcommande);
	}
	public void deleteFactureById(int factureId) {
		 ifactureservice.deleteFactureById(factureId);
	}
	
	
	
	public void mettreAjourTypeFacture(String newtypefac,int idfacture) {
		ifactureservice.mettreAjourTypeFacture(newtypefac, idfacture);
	}
	
	public Facture getFactureById(int idfacture) {
		return ifactureservice.getFactureById(idfacture);
	}
	
	public List<Facture> getFactureByClient(int idclient){
		return ifactureservice.getFactureByClient(idclient);
	}

	public IFactureService getIfactureservice() {
		return ifactureservice;
	}

	public void setIfactureservice(IFactureService ifactureservice) {
		this.ifactureservice = ifactureservice;
	}

	public String getTypefacture() {
		return typefacture;
	}

	public void setTypefacture(String typefacture) {
		this.typefacture = typefacture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getDatefac() {
		return datefac;
	}

	public void setDatefac(Date datefac) {
		this.datefac = datefac;
	}
	
	
	public Integer getFactureIdToBeUpdated() {
		return factureIdToBeUpdated;
	}

	public void setFactureIdToBeUpdated(Integer factureIdToBeUpdated) {
		this.factureIdToBeUpdated = factureIdToBeUpdated;
	}

	public void AddManuelFacture() {
		
	 ifactureservice.ajouterFacture(new Facture (typefacture,name,surname,tel,adresse,total,datefac));
	
	}
	

	public List<Facture> getFactures() {
		 factures=ifactureservice.getAllfactures();
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	public void modifier( Facture facture)
	{this.setAdresse(facture.getAdresse());
	this.setDatefac(facture.getDatefac());
	this.setName(facture.getName());
	this.setSurname(facture.getSurname());
	this.setTel(facture.getTel());
	this.setTotal(facture.getTotal());
	this.setTypefacture(facture.getTypefacture());
	this.setFactureIdToBeUpdated(facture.getIdfacture());
	}
	
	public void mettreAjourFacture(){
Facture f=new Facture(typefacture, name,surname, tel, adresse,total,datefac,factureIdToBeUpdated);
        ifactureservice.updateFacture(f);
		}
	
	
	 public void converttopdf() throws FileNotFoundException, IOException  
	    {
	    	String HTML = 
	    			"<h1><center>BILL n°  </center></h1>"+
	    			"<table>" + 
	    			" <tr>" + 
	    			" <td>id bill</td>" + 
	    			  "<td>2</td>" + 
	    			 " </tr>"+
	    			 " <tr>" +
	    			 "<td>Type bill</td>" + 
	    			  "<td>Automatique</td>" + 
	    			  " </tr>"+
			    			" <td>date</td>" + 
			    			  "<td>2020-06-05 11:08:17.0</td>" + 
			    			 " </tr>"+
			    			 " <tr>" + 
				    			" <td>Commande</td>" + 
				    			  "<td>Commande [idcommande=2, datecmd=2020-06-05 11:08:17.0, total=1100.0]</td>" + 
				    			 " </tr>"+
	    			"</table>";
	    	
	    	HtmlConverter.convertToPdf(HTML, new FileOutputStream("facture.pdf"));
	    	
	        System.out.println( "PDF Created!" );
	    }
	

	
	
	
	
	  
}


