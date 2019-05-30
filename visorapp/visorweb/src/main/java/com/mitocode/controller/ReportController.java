package com.mitocode.controller;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

//import com.hampcode.dto.ReportProductCategory;
//import com.hampcode.service.IProductService;


import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Named
@ViewScoped
public class ReportController implements Serializable {

	private static final long serialVersionUID = 1L;

//	@Inject
//	private IProductService productService;
//
//	private List<ReportProductCategory> reportProductCategorys;
	private PieChartModel pieModel1;
	

	@PostConstruct
	public void init() {
		this.listarProductCategories();
		this.createPieModel1();
	}

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

//		for (ReportProductCategory x : this.reportProductCategorys) {
//			pieModel1.set(x.getCategory(), x.getQuantity());
//		}

		pieModel1.setTitle("Cantidad Productos Por Categoria");
		pieModel1.setLegendPosition("w");
		pieModel1.setShowDataLabels(true);
	}

	
	public void listarProductCategories() {
		try {
//			reportProductCategorys = productService.reportQuantityProductByCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void generatedReport() {

		try {

			Map<String, Object> parametros = new HashMap<String, Object>();
			// parametros.put("", "");
			File jasper = new File(FacesContext.getCurrentInstance().getExternalContext()
					.getRealPath("/resources/reports/report_product_category.jasper"));
//			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros,
//					new JRBeanCollectionDataSource(this.reportProductCategorys));

			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			response.addHeader("Content-disposition", "attachment; filename=productcategorys.pdf");
			ServletOutputStream stream = response.getOutputStream();

//			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
//	public List<ReportProductCategory> getReportProductCategorys() {
//		return reportProductCategorys;
//	}
//
//	public void setReportProductCategorys(List<ReportProductCategory> reportProductCategorys) {
//		this.reportProductCategorys = reportProductCategorys;
//	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	
}
