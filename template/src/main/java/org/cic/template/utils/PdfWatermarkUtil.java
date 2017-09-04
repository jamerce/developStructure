package org.cic.template.utils;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class PdfWatermarkUtil {
	
	/**
	 * Add text water mark
	 * 
	 * @param inputStream - Input file path of the original pdf file.
	 * @param outputStream - Output file path of the target pdf file that water mark is added.
	 * @param watermark - Text of water mark.
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void addITextWatermark(String inputFilePath, String outputFilePath, String watermark) throws Exception {
		FileInputStream inputStream = new FileInputStream(inputFilePath);
		FileOutputStream outputStream = new FileOutputStream(outputFilePath);

		this.addITextWatermark(inputStream, outputStream, watermark);
	}

	/**
	 * Add text water mark
	 * 
	 * @param inputStream - InputStream of the original pdf file.
	 * @param outputStream - OutputStream of the target pdf file that water mark is added.
	 * @param waterMarkName - Text of water mark.
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void addITextWatermark(InputStream inputStream, OutputStream outputStream, String waterMarkName) throws Exception {
		Document document = new Document(PageSize.A4);

		// Read the existing PDF document
		PdfReader pdfReader = new PdfReader(inputStream);

		// Get the PdfStamper object
		PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);

		// Get the PdfContentByte type by pdfStamper.
		for (int i = 1, pdfPageSize = pdfReader.getNumberOfPages() + 1; i < pdfPageSize; i++) {
			PdfContentByte pageContent = pdfStamper.getOverContent(i);
			pageContent.setGState(this.getPdfGState());
			pageContent.beginText();
			pageContent.setFontAndSize(this.getBaseFont(), 30);
			pageContent.setColorFill(Color.LIGHT_GRAY);
			
			// 設置水印文字字體傾斜 開始
			int j = waterMarkName.length();
			char c = 0;  
            int rise = 0;  
            if (j >= 15) {  
            	float width = document.getPageSize().getWidth() / 10;
            	float height = document.getPageSize().getHeight() - 80;
            	pageContent.setTextMatrix(width, height);  
                for (int k = 0; k < j; k++) {  
                	pageContent.setTextRise(rise);  
                    c = waterMarkName.charAt(k);  
                    pageContent.showText(c + "");
                    rise -= 27;  
                }  
            } else {
            	float width = document.getPageSize().getWidth() / 10;
            	float height = document.getPageSize().getHeight() - 80;
            	pageContent.setTextMatrix(width, height);   
                for (int k = 0; k < j; k++) {  
                	pageContent.setTextRise(rise);
                    c = waterMarkName.charAt(k);  
                    pageContent.showText(c + "");
                
                    rise -= 18;  
                }  
            }  
            // 字體設置結束  
			
			/*
			float width = document.getPageSize().getWidth() / 2;
            float height = document.getPageSize().getHeight() / 2;
			pageContent.showTextAligned(Element.ALIGN_CENTER, waterMarkName, width, height, 0);
			*/
			pageContent.endText();
		}
		pdfStamper.close();
	}

	/**
	 * Get BaseFont
	 * 
	 * @return
	 * @throws Exception
	 */
	private BaseFont getBaseFont() throws Exception {
		//String fontpath = "D:/home/ICS/kaiu.ttf";
		String fontpath = SystemParam.get("font_path");
		return BaseFont.createFont(fontpath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED );
		//return BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
	}

	/**
	 * Get PdfGState
	 * 
	 * @return
	 */
	private PdfGState getPdfGState() {
		PdfGState graphicState = new PdfGState();
		graphicState.setFillOpacity(0.7f);
		graphicState.setStrokeOpacity(1f);

		return graphicState;
	}
	
	public static void main(String args[]){
		String srcPath = "D:/home/ICS/cic/adv.pdf";
		String descPath = "D:/home/ICS/cic/adv_water.pdf";
		
		String watermark = "120IC121212 FOR IC驗證鑑定 何垂穎 ";
		
		PdfWatermarkUtil pdf = new PdfWatermarkUtil();
		try {
	        pdf.addITextWatermark(srcPath, descPath, watermark);
	        
        } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
	}
	
}
