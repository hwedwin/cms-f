package zlin.clothing.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import zlin.clothing.po.ClothingPO;
import zlin.clothing.service.*;
import zlin.clothing.vo.PageBean;

public class ClothingAction extends ActionSupport{
private String huangjinhao = "shuaiguo";
	private ClothingService clothingservice;
	private ArrayList clothinglist;//ҳ���в�ѯ�Ľ��
	
	private String clothnum;
	private String type;
	private String color;
	private String size;
	private String fabric;
	private String clothingMaterial;
	private String factoryPrice;
	private String retailPrice;
	private String id;
	
	private PageBean pageBean;
	
	private String clothingPageFunc;//�ж�clothing1001.jspҳ����ͨ���Ǹ���ѯ���Ĺ���
	
	public ClothingService getClothingservice() {
		return clothingservice;
	}
	public void setClothingservice(ClothingService clothingservice) {
		this.clothingservice = clothingservice;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}


	private ClothingPO clothingpo;
	private int page;//���ڷ�ҳ
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public ClothingPO getClothingpo() {
		return clothingpo;
	}
	public void setClothingpo(ClothingPO clothingpo) {
		this.clothingpo = clothingpo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList getClothinglist() {
		return clothinglist;
	}
	public void setClothinglist(ArrayList clothinglist) {
		this.clothinglist = clothinglist;
	}
	
	
	public String findAllClothing()
	{
		//clothingservice=new ClothingService();
		
		//��ʾÿҳ��ʾ5����¼��page��ʾ��ǰ��ҳ
        pageBean = clothingservice.findAllClothing(10, page);
        clothinglist=pageBean.getList();
       // HttpServletRequest request = ServletActionContext.getRequest();
        
        ActionContext.getContext().getSession().put("pageBean",pageBean);
       // request.setAttribute("pageBean", pageBean);
        
        clothingPageFunc="findallclothing";
        ActionContext.getContext().getSession().put("clothingPageFunc",clothingPageFunc);
        
        return "success";
		
	}
	
	
	/*
	//��ѯȫ����clothing
	public String findAllClothing()
	{	
		//System.out.println("this is findallclothing action");
		clothingservice=new ClothingService();
		try{
			clothinglist=clothingservice.findAllClothing(); //����ȫ��clothing
			if(!clothinglist.isEmpty())//���clothinglist��Ϊ��
			{
				//System.out.println("clothinglist not null");
				return "success";
			}
			
			else
			{
				System.out.println("clothinglist is Empty");
				return "error";				
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return "input";//�����쳣
		}
		
	}
	*/
	
	
	//��������ѯclothing
	public String findClothing()
	{
		//ActionContext ctx=ActionContext.getContext();
		//System.out.println("thit is findClothing Action");
		
		HttpServletRequest request=null;
		request=ServletActionContext.getRequest();
		clothnum=request.getParameter("clothnum");
		type=request.getParameter("type");
		color=request.getParameter("color");
		size=request.getParameter("size");
		
		
		
		try { 
			color = java.net.URLDecoder.decode(color,"UTF-8"); 
			//color = java.net.URLDecoder.decode(color,"UTF-8"); 
			
			type = java.net.URLDecoder.decode(type,"UTF-8");
			//type = java.net.URLDecoder.decode(type,"UTF-8");
			} catch (UnsupportedEncodingException e1) { 
			e1.printStackTrace(); 
			} 
		

		//System.out.println("clothnum="+clothnum+",color="+color+",type="+type+",size="+size+"\n");
		
		//clothingservice=new ClothingService();
		
		//try
		//{
			clothingPageFunc="findclothing";
			 ActionContext.getContext().getSession().put("clothingPageFunc",clothingPageFunc);
			
			 
			 pageBean=clothingservice.findClothing(clothnum, type, color, size, 10, page);
			 ActionContext.getContext().getSession().put("pageBean",pageBean);
			 
			clothinglist=pageBean.getList();
			return "success";
			/*
			if(!clothinglist.isEmpty())
			{
				return "success";
				
			}
			else{
				return "error";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return "input";
			
		}*/
		
	}
	
	
	
	
	/*
	//��������ѯclothing
	public String findClothing()
	{
		//ActionContext ctx=ActionContext.getContext();
		//System.out.println("thit is findClothing Action");
		
		HttpServletRequest request=null;
		request=ServletActionContext.getRequest();
		clothnum=request.getParameter("clothnum");
		type=request.getParameter("type");
		color=request.getParameter("color");
		size=request.getParameter("size");
		

		
		try { 
			color = java.net.URLDecoder.decode(color,"UTF-8"); 
			//color = java.net.URLDecoder.decode(color,"UTF-8"); 
			
			type = java.net.URLDecoder.decode(type,"UTF-8");
			//type = java.net.URLDecoder.decode(type,"UTF-8");
			} catch (UnsupportedEncodingException e1) { 
			e1.printStackTrace(); 
			} 
		

		//System.out.println("clothnum="+clothnum+",color="+color+",type="+type+",size="+size+"\n");
		
		clothingservice=new ClothingService();
		
		try
		{
			clothinglist=clothingservice.findClothing(clothnum, type, color, size);
			if(!clothinglist.isEmpty())
			{
				return "success";
				
			}
			else{
				return "error";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return "input";
			
		}
		
	}
	*/
	
	//�½�һ������
	public String newClothing()
	{
		System.out.println("this is new clothing action");
	//	clothingservice=new ClothingService();
		//ClothingPO clothingpo=new ClothingPO();
	//	clothingpo=new ClothingPO();
		
		HttpServletRequest request=null;
		request=ServletActionContext.getRequest();
		clothnum=request.getParameter("clothnum");
		type=request.getParameter("type");
		color=request.getParameter("color");
		size=request.getParameter("size");
		fabric=request.getParameter("fabric");
		clothingMaterial=request.getParameter("clothingMaterial");	
		factoryPrice=request.getParameter("factoryPrice");	
		retailPrice=request.getParameter("retailPrice");	
		
		System.out.println("clothnum="+clothnum+",color="+color+",type="+type+",size="+size+",clothingMaterial="+clothingMaterial+",factoryPrice="+factoryPrice+"\n");
		
		try { 
			clothnum= java.net.URLDecoder.decode(clothnum,"UTF-8");
			
			color = java.net.URLDecoder.decode(color,"UTF-8"); 
			//color = java.net.URLDecoder.decode(color,"UTF-8"); 
			
			type = java.net.URLDecoder.decode(type,"UTF-8");
			//type = java.net.URLDecoder.decode(type,"UTF-8");
			
			size=java.net.URLDecoder.decode(size,"UTF-8");
					
			fabric=java.net.URLDecoder.decode(fabric,"UTF-8");
			
			clothingMaterial=java.net.URLDecoder.decode(clothingMaterial,"UTF-8");
			
			factoryPrice=java.net.URLDecoder.decode(factoryPrice,"UTF-8");
			
			retailPrice=java.net.URLDecoder.decode(retailPrice,"UTF-8");
			
			} catch (UnsupportedEncodingException e1) { 
			e1.printStackTrace(); 
			} 
		
		clothingpo.setClothnum(clothnum);
		clothingpo.setClothingMaterial(clothingMaterial);
		clothingpo.setColor(color);
		clothingpo.setFabric(fabric);
		clothingpo.setFactoryPrice(factoryPrice);
		clothingpo.setRetailPrice(retailPrice);
		clothingpo.setSize(size);
		clothingpo.setType(type);
		
		try{
			Long id=clothingservice.newClothing(clothingpo);//�����½����ŵ�ID
			if(id!=null)//���clothinglist��Ϊ��
			{
				return "success";
			}
			
			else
			{
				return "error";				
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return "input";//�����쳣
		}
		
	}
	
	
	//ɾ��һ������
	public String deleteClothing()
	{
		HttpServletRequest request=null;
		request=ServletActionContext.getRequest();
		id=request.getParameter("id");
		Long storeid=Long.parseLong(id);
		clothingservice.deleteClothing(storeid);
		return "success";		
		
	}
	
	//����ID�����ҵ�һ������
	public String findAClothing()
	{
		HttpServletRequest request=null;
		request=ServletActionContext.getRequest();		
		Long clothingid;
		id=request.getParameter("id");	
		clothingid=Long.parseLong(id);
		
		clothingpo=clothingservice.findAClothing(clothingid);
		ActionContext.getContext().getSession().put("clothingpo",clothingpo);	
		
		return "success";
	}
	
	
	
	//����һ��������Ϣ
	public String updateClothing()
	{
		//clothingservice=new ClothingService();
		clothingpo=new ClothingPO();
		
		HttpServletRequest request=null;
		request=ServletActionContext.getRequest();
		clothnum=request.getParameter("clothnum");
		type=request.getParameter("type");
		color=request.getParameter("color");
		size=request.getParameter("size");
		fabric=request.getParameter("fabric");
		clothingMaterial=request.getParameter("clothingMaterial");	
		factoryPrice=request.getParameter("factoryPrice");	
		retailPrice=request.getParameter("retailPrice");	
			
		try { 
			clothnum= java.net.URLDecoder.decode(clothnum,"UTF-8");
			
			color = java.net.URLDecoder.decode(color,"UTF-8"); 
			//color = java.net.URLDecoder.decode(color,"UTF-8"); 
			
			type = java.net.URLDecoder.decode(type,"UTF-8");
			//type = java.net.URLDecoder.decode(type,"UTF-8");
			
			size=java.net.URLDecoder.decode(size,"UTF-8");
					
			fabric=java.net.URLDecoder.decode(fabric,"UTF-8");
			
			clothingMaterial=java.net.URLDecoder.decode(clothingMaterial,"UTF-8");
			
			factoryPrice=java.net.URLDecoder.decode(factoryPrice,"UTF-8");
			
			retailPrice=java.net.URLDecoder.decode(retailPrice,"UTF-8");
			
			} catch (UnsupportedEncodingException e1) { 
					e1.printStackTrace(); 
			} 
		
		//��session������ȡ����Ҫ�����Ϣ��clothingpo�����IDֵ��
		ClothingPO c=new ClothingPO();
		c=(ClothingPO)ActionContext.getContext().getSession().get("clothingpo");		
		clothingpo.setId(c.getId());
		
		
		clothingpo.setClothnum(clothnum);
		clothingpo.setClothingMaterial(clothingMaterial);
		clothingpo.setColor(color);
		clothingpo.setFabric(fabric);
		clothingpo.setFactoryPrice(factoryPrice);
		clothingpo.setRetailPrice(retailPrice);
		clothingpo.setSize(size);
		clothingpo.setType(type);
		
		clothingservice.updateClothing(clothingpo);
		ActionContext.getContext().getSession().remove("clothingpo");
		return "success";
						
	}
	
	
	/*
	 * ����clothing��ʱ�򣬴�ǰ̨����һ��ID�ŵ���̨�����в�ѯ��Ҫ���µ�clothingpo����
	 * �Ѳ�ѯ���Ľ�����session�У�Ȼ����ǰ̨����clothingpo����ÿ���������и�ֵ
	 * ���ԣ������������ѯ���Ķ���֮�󣬾���Ҫ�����session���Ƴ�(����updateClothing����Ƴ�)
	 * ���ԣ�����ɹ����Ƴ�һ�Σ��ڷ��ص�ʱ��Ҳ��Ҫ�Ƴ�һ��
	 * 
	 * 
	 * ���ص�ʱ�򣬵��ô˺������session�е�clothingpo�Ķ���
	 * */
	
	public String cleanDataInSession()
	{
		ActionContext.getContext().getSession().remove("clothingpo");
		return "success";
		
	}
	
	
	
	/*
	//模糊查询
	public String criterialClothing()
	{
		HttpServletRequest request=null;
		request=ServletActionContext.getRequest();
		clothnum=request.getParameter("clothnum");
		type=request.getParameter("type");
		color=request.getParameter("color");
		size=request.getParameter("size");
		
		
	
		try { 
			color = java.net.URLDecoder.decode(color,"UTF-8"); 
			//color = java.net.URLDecoder.decode(color,"UTF-8"); 
			
			type = java.net.URLDecoder.decode(type,"UTF-8");
			//type = java.net.URLDecoder.decode(type,"UTF-8");
			} catch (UnsupportedEncodingException e1) { 
			e1.printStackTrace(); 
			} 
		System.out.println("criterial action clothnum="+clothnum+",type="+type+",color="+color+",size="+size);
			
			clothingPageFunc="findclothing";
			 ActionContext.getContext().getSession().put("clothingPageFunc",clothingPageFunc);
			
			 
			// pageBean=clothingservice.findClothing(clothnum, type, color, size, 10, page);
			 ClothingPO clothingPO=new ClothingPO();
			 clothingpo.setClothnum(clothnum);
			 clothingpo.setColor(color);
			 clothingpo.setType(type);
			 clothingpo.setSize(size);
			 pageBean=clothingservice.criteriaClothing(10, page, clothingpo);
			 
			 ActionContext.getContext().getSession().put("pageBean",pageBean);
			 
			clothinglist=pageBean.getList();
			return "success";
		
	}*/
	
	//模糊查询
	public String criterialClothing()
	{
		/*
		HttpServletRequest request=null;
		request=ServletActionContext.getRequest();
		clothnum=request.getParameter("clothnum");
		type=request.getParameter("type");
		color=request.getParameter("color");
		size=request.getParameter("size");
		
		try { 
			color = java.net.URLDecoder.decode(color,"UTF-8"); 
			//color = java.net.URLDecoder.decode(color,"UTF-8"); 
			
			type = java.net.URLDecoder.decode(type,"UTF-8");
			//type = java.net.URLDecoder.decode(type,"UTF-8");
			} catch (UnsupportedEncodingException e1) { 
			e1.printStackTrace(); 
			} 
		
		
		
		clothingpo.setClothnum(clothnum);
		clothingpo.setColor(color);
		clothingpo.setSize(size);
		clothingpo.setType(type);
		*/
		
		if(clothingpo.getColor().equals("请选择"))
		{
			clothingpo.setColor("");
			
		}
		
		if(clothingpo.getSize().equals("请选择"))
		{
			
			clothingpo.setSize("");
		}
		
		
		System.out.println("color="+clothingpo.getColor());
			
			clothingPageFunc="criterialclothing";
			 ActionContext.getContext().getSession().put("clothingPageFunc",clothingPageFunc);
			
			 
			// pageBean=clothingservice.findClothing(clothnum, type, color, size, 10, page);
			 
			 pageBean=clothingservice.criteriaClothing(clothingpo, 10, page);
			 
			 ActionContext.getContext().getSession().put("pageBean",pageBean);
			 
			clothinglist=pageBean.getList();
			return "success";
		
	}
	
	
}
