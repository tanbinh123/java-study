package main;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import dao.CarInfo_dao;
import dto.CarInfo_dto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<CarInfo_dto>CarInfoArr = new ArrayList<>();
		CarInfo_dao CarInfoDao = new CarInfo_dao();
		Scanner sc = new Scanner(System.in);
		int gubun = -1;
		
		
		
		do {
			try {
				//메인 화면
				System.out.println("조회[1] 등록[2] 수정[3] 삭제 [4] 종료[0]");
				gubun = sc.nextInt();
				
				
				//조회 화면
				if(gubun == 1) {
					System.out.println("전체조회[1] 제조사별[2] 모델명[3] 차번호[4]");
					int showGubun = sc.nextInt();
					
					
					//전체 조회
					if(showGubun == 1) {
						CarInfoArr = CarInfoDao.selectDB(1,"","","");
						
						
					//제조사별로 조회	
					}else if(showGubun == 2) {
						System.out.println("제조사로 검색 :현대[10] 기아[20] 르노삼성[30] 쌍용[40] 쉐보레[50] 빤츠[60] 뱜떠블유[70] 아우디[80] 테슬라[90]");
						String searchMade = sc.next();
						CarInfoArr = CarInfoDao.selectDB(2,searchMade,"","");
						
						
						
					//모델명으로 조회	
					}else if(showGubun == 3) {
						System.out.println("모델명으로 검색 :");
						String searchModelName = sc.next();
						CarInfoArr = CarInfoDao.selectDB(3,"",searchModelName,"");
						
						
					//차번호로 조회	
					}else if(showGubun == 4) {
						System.out.println("차번호로 검색 :");
						String searchCarNumber = sc.next();
						CarInfoArr = CarInfoDao.selectDB(4,"","",searchCarNumber);
					}
					
					//조회 결과
						if (CarInfoArr.size() != 0) {
							System.out.println("=======================================================================================================");
							System.out.println("번호\t모델명\t차번호\t제조사\t제조년월\t기어\t옵션유무\t사고유무\t연료\t입고일\t\t대여가능");
							System.out.println("=======================================================================================================");
							for (int i = 0; i < CarInfoArr.size(); i++) {
								System.out.print(CarInfoArr.get(i).getNo() + "\t");
								System.out.print(CarInfoArr.get(i).getModel_name() + "\t");
								System.out.print(CarInfoArr.get(i).getCar_number() + "\t");
								System.out.print(CarInfoArr.get(i).getCar_made() + "\t");
								System.out.print(CarInfoArr.get(i).getCar_made_ym() + "\t");
								System.out.print(CarInfoArr.get(i).getAuto_yn() + "\t");
								System.out.print(CarInfoArr.get(i).getOption_yn() + "\t");
								System.out.print(CarInfoArr.get(i).getAccident_yn() + "\t");
								System.out.print(CarInfoArr.get(i).getFuel_type() + "\t");
								System.out.print(CarInfoArr.get(i).getImport_date() + "\t");
								System.out.print(CarInfoArr.get(i).getRent_gubun() + "\n");
							}
							System.out.println("=======================================================================================================");
						}
						
						else if(CarInfoArr.size() == 0) {
							System.out.println("조회 결과가 없습니다.");
						}
						
						
				
				//입력 화면		
				}else if(gubun == 2) {
					//입력 로직 변수
					String no, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn, accident_yn, fuel_type;
					//입력 로직 do_whlie문 변수
					String model_name_value = "", car_number_value = "", car_made_value = "", car_made_ym_value = "", auto_yn_value = "", option_yn_value = "", accident_yn_value = "", fuel_type_value = "";
					
					
					//번호 순서대로 자동으로 추가
					CarInfoArr = CarInfoDao.selectDB(1, "", "", "");
					if (CarInfoArr.size() == 0) {
						no = "C001";
					} else {
						no = CarInfoDao.insertDBNo();
						no = CarInfoDao.getNo(no);
					}
					
					
					//모델명 입력  + 예외처리
					do {
						System.out.print("차량 모델명 입력 : ");
						model_name = sc.next();
							if (model_name.length() > 20) {
								System.out.println("모델명은 20글자까지만 입력해주세요.\n현재 글자수 : "+ model_name.length());
								model_name_value = "false";
								model_name = "";
							}
							else {
								model_name_value = "ture";
							}
					} while (!model_name_value.equals("ture"));
					
					
					//차번호 입력  + 예외처리
					do {
						System.out.print("차량 번호 입력 : ");
						car_number = sc.next();
							if (car_number.length() > 15) {
								System.out.println("차번호는 15글자까지만 입력해주세요.\n현재 글자수 : "+ car_number.length());
								car_number_value = "false";
								car_number = "";
							}
							else {
								car_number_value = "ture";
							}
					} while (!car_number_value.equals("ture"));
					
					
					//제조사 입력  + 예외처리
					do {
						System.out.print("============\n"
								+ "제조사 입력\n"
								+ "============\n"
								+ "[10] 현대\n"
								+ "[20] 기아\n"
								+ "[30] 르노삼성\n"
								+ "[40] 쌍용\n"
								+ "[50] 쉐보레\n"
								+ "[60] 빤츠\n"
								+ "[70] 뱜떠블유\n"
								+ "[80] 아우디\n"
								+ "[90] 테슬라\n"
								+ "============\n"
								+ "번호 입력 : ");
						car_made = sc.next();
							 if(car_made.equals("10") || car_made.equals("20") || car_made.equals("30") || car_made.equals("40") || car_made.equals("50") || car_made.equals("60") || car_made.equals("70") || car_made.equals("80") || car_made.equals("90")){
								car_made_value = "ture";
							}else {
								System.out.println("다시 입력해주세요");
								car_made_value = "false";
								car_made = "";
							}
					} while (!car_made_value.equals("ture"));
					
					
					//차량 제조년월 입력 + 예외처리
					do {
						System.out.println("차량 제조년월 입력");
						System.out.println("ex)199901");
						System.out.print("입력 : ");
						car_made_ym = sc.next();
							if (car_made_ym.length() > 6) {
								System.out.println("차량 제조년월은 6글자까지만 입력해주세요.\n현재 글자수 : "+ car_number.length());
								car_made_ym_value = "false";
								car_made_ym = "";
							}
							else {
								car_made_ym_value = "ture";
							}
					} while (!car_made_ym_value.equals("ture"));
					
					
					//차량 기어 입력 + 예외처리
					do {
						System.out.print("차량 기어 종류 입력 : 자동[a] 수동[m]");
						auto_yn = sc.next();
							if(auto_yn.equals("a") || auto_yn.equals("A") || auto_yn.equals("ㅁ") || auto_yn.equals("m") || auto_yn.equals("M") || auto_yn.equals("ㅡ")) {
								if(auto_yn.equals("a") || auto_yn.equals("A") || auto_yn.equals("ㅁ")) {
									auto_yn = "a";
								}
								else if(auto_yn.equals("m") || auto_yn.equals("M") || auto_yn.equals("ㅡ")) {
									auto_yn = "m";
								}
								auto_yn_value = "ture";
							}else {
								System.out.println("a 나 m 으로 입력해주세요");
								auto_yn = "";
								auto_yn_value = "false";
							}
					} while (!auto_yn_value.equals("ture"));
					
					
					//옵션 유무 입력 + 예외처리
					do {
						System.out.print("차량 옵션유무 입력 : 유[y] 무[n]");
						option_yn = sc.next();
							option_yn = CarInfoDao.getYNResult(option_yn);
							if(option_yn.equals("y") || option_yn.equals("n")) option_yn_value = "ture";
							else option_yn_value = "false";
					}while (!option_yn_value.equals("ture"));
					
					
					//사고 유무 입력 + 예외처리
					do {
						System.out.print("차량 사고유무 입력 : 유[y] 무[n]");
						accident_yn = sc.next();
							accident_yn = CarInfoDao.getYNResult(option_yn);
							if(accident_yn.equals("y") || accident_yn.equals("n")) accident_yn_value = "ture";
							else accident_yn_value = "false";
					}while (!accident_yn_value.equals("ture"));
					
						
					//유류 입력 + 예외처리
					do {
						System.out.print("차량 유류 입력\n"
								+ "[1]가솔린\n"
								+ "[2]디젤\n"
								+ "[3]LPG\n"
								+ "[4]전기\n"
								+ "번호 입력 : ");
						fuel_type = sc.next();
							if(fuel_type.equals("1") || fuel_type.equals("2") || fuel_type.equals("3") || fuel_type.equals("4")){
								fuel_type_value = "ture";
							}else {
								System.out.println("다시 입력해주세요");
								fuel_type_value = "false";
								fuel_type = "";
							}
					}while (!fuel_type_value.equals("ture"));
					
					
					//입고일 입력
					System.out.println("차량 입고일 입력");
					System.out.println("ex)19990101");
					System.out.print("입력 : ");
					String import_date = sc.next();
					
					
					//렌트 구분
					String rent_gubun = "y";
					
					
					int result = CarInfoDao.insertDB(no, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn, accident_yn, fuel_type, import_date, rent_gubun);
					System.out.println("║===============" + result + "행 등록되었습니다============║");
				
				}else if(gubun == 3) {
					
				
				}else if(gubun == 4) {
					
				}
			}catch(Exception e) {
				System.out.println("입력 오류입니다.");
				gubun = 0;
			}
		}while(gubun != 0);
		System.out.println("시스템을 종료합니다.");
	}

}
