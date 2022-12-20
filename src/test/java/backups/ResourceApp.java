package backups;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class ResourceApp {	
	ResourceDto rt = new ResourceDto();
	ResourceDao re = new ResourceDao();
	PreparedStatement pstmt = null;

	ResultSet rs = null;
	
	Scanner sc = new Scanner(System.in);
	
	
	//조회!
	public void retrieveReourceApp() {
		List<ResourceDto> list = re.retrieveResource();
		Iterator<ResourceDto> it = list.iterator();
		while(it.hasNext()){
			rt = (ResourceDto)it.next();
			System.out.print(rt.getCITIES() + " ");
			System.out.print(rt.getMulti_num() + " ");
			System.out.print(rt.getMulti_num_mem());
			System.out.print(rt.getMul_indi() + " ");
			System.out.print(rt.getMul_emi() + " ");
			System.out.print(rt.getMul_married() + " ");
			System.out.println(rt.getMul_etc() + " ");
		}
	}
	
	public void deleteResourceApp() {
		System.out.println("삭제할 구역 설정: ");	
		String CITIES = sc.next();
		int rsint = re.deleteResource(CITIES);
		if (rsint >0)
			System.out.println("삭제되었습니다.");
		
	}

	public void updateResourceApp() {
		System.out.println("수정할 장소 조회:");	
		String CITIES = sc.next();
		
		
		System.out.println(" now working ....  ");

		System.out.print("행1 : ");
		int Multi_num = sc.nextInt();
		
		System.out.print("행2 : ");
		int Multi_num_mem = sc.nextInt();
		
		System.out.print("행3 : ");
		int Mul_indi = sc.nextInt();
		
		System.out.print("행4 : ");
		int Mul_emi = sc.nextInt();
		
		System.out.print("행5 : ");
		int Mul_married = sc.nextInt();
		
		System.out.print("행(기타값) : ");
		int Mul_etc = sc.nextInt();
		
		rt.setCITIES(CITIES);
		rt.setMulti_num(Multi_num);
		rt.setMulti_num_mem(Multi_num_mem);
		rt.setMul_indi(Mul_indi);
		rt.setMul_emi(Mul_emi);
		rt.setMul_married(Mul_married);
		rt.setMul_etc(Mul_etc);
		
		
		int upg = re.updateResource(rt);
		if (upg >0)
			
			System.out.println("수정되었습니다.");
	}
	
	public void insertResourceApp() {
		System.out.print("행정구역 입력하시오. : (ex: XX시)");
		String CITIES = sc.next();
		
		System.out.print("행1 : ");
		int Multi_num = sc.nextInt();
		
		System.out.print("행2 : ");
		int Multi_num_mem = sc.nextInt();
		
		System.out.print("행3 : ");
		int Mul_indi = sc.nextInt();
		
		System.out.print("행4 : ");
		int Mul_emi = sc.nextInt();
		
		System.out.print("행5 : ");
		int Mul_married = sc.nextInt();
		
		System.out.print("행(기타값) : ");
		int Mul_etc = sc.nextInt();
		
		rt.setCITIES(CITIES);
		rt.setMulti_num(Multi_num);
		rt.setMulti_num_mem(Multi_num_mem);
		rt.setMul_indi(Mul_indi);
		rt.setMul_emi(Mul_emi);
		rt.setMul_married(Mul_married);
		rt.setMul_etc(Mul_etc);
		
		int insrt = re.insertResource(rt);
		if (insrt >0)
			System.out.println("입력되었습니다.");
	}
	
	public static void main(String[] args) {
		ResourceApp ra = new ResourceApp();
		ra.updateResourceApp();
		
	}

}
