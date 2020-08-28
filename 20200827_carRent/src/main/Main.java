package main;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import dao.CarInfo_dao;
import dto.CarInfo_dto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<CarInfo_dto> CarInfoArr = new ArrayList<>();
		CarInfo_dao CarInfoDao = new CarInfo_dao();
		Scanner sc = new Scanner(System.in);
		int gubun = -1;

		do {
			try {
				// 메인 화면
				System.out.println("=====================================");
				System.out.println("\t\t메인 화면");
				System.out.println("=====================================");
				System.out.println("   조회-------[1]        등록------[2]");
				System.out.println("   수정-------[3]        삭제------[4]");
				System.out.println("   종료-------[0]");
				System.out.println("=====================================");
				System.out.print("입력 : ");
				gubun = sc.nextInt();

				// 조회 화면
				if (gubun == 1) {
					System.out.println("=========================================");
					System.out.println("\t\t조회 화면");
					System.out.println("=========================================");
					System.out.println("   전체 조회-------[1]    제조사별 조회------[2]");
					System.out.println("   모델명으로 조회--[3]     차번호로 조회------[4]");
					System.out.println("   메인 화면으로----[0]");
					System.out.println("=========================================");
					System.out.print("입력 : ");
					int showGubun = sc.nextInt();

					// 전체 조회
					if (showGubun == 1) {
						CarInfoArr = CarInfoDao.selectDB(1, "", "", "");

						// 제조사별로 조회 + 예외처리
					} else if (showGubun == 2) {
						String searchMade, searchMade_pass = "";
						do {
							System.out.println("================================================");
							System.out.println("\t\t제조사별로 조회");
							System.out.println("================================================");
							System.out.println("현대-------[10]   기아------[20]   르노삼성----[30]");
							System.out.println("쌍용------[40]    쉐보레------[50]  빤츠-------[60]");
							System.out.println("뱜떠블유----[70]   아우디-----[80]   테슬라------[90]");
							System.out.println("================================================");
							System.out.print("입력 : ");
							searchMade = sc.next();
							searchMade_pass = CarInfoDao.getCarMadeEx(searchMade);
						} while (!searchMade_pass.equals("ture"));
						CarInfoArr = CarInfoDao.selectDB(2, searchMade, "", "");

						// 모델명으로 조회 + 예외처리
					} else if (showGubun == 3) {
						String searchModelName, searchModelName_pass = "";
						do {
							System.out.println("================================================");
							System.out.println("\t\t모델명으로 조회");
							System.out.println("================================================");
							System.out.print("입력 : ");
							searchModelName = sc.next();
							searchModelName_pass = CarInfoDao.getStringLengthEx("모델명", searchModelName, 20);
						} while (!searchModelName_pass.equals("ture"));
						CarInfoArr = CarInfoDao.selectDB(3, "", searchModelName, "");

						// 차번호로 조회 + 예외처리
					} else if (showGubun == 4) {
						String searchCarNumber, searchCarNumber_pass = "";
						do {
							System.out.println("================================================");
							System.out.println("\t\t차번호로 조회");
							System.out.println("================================================");
							System.out.print("입력 : ");
							searchCarNumber = sc.next();
							searchCarNumber_pass = CarInfoDao.getStringLengthEx("차번호", searchCarNumber, 6);
						} while (!searchCarNumber_pass.equals("ture"));
						CarInfoArr = CarInfoDao.selectDB(4, "", "", searchCarNumber);

						// 메인화면으로 돌아가기
					} else if (showGubun == 0) {
						gubun = -1;
						continue;
					}

					// 조회 결과
					if (CarInfoArr.size() != 0) {
						System.out.println("================================================================================================================");
						System.out.println("번호\t모델명\t\t차번호\t제조사\t제조년월\t기어\t옵션유무\t사고유무\t연료\t입고일\t\t대여가능");
						System.out.println("================================================================================================================");
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
						System.out.println("================================================================================================================");
					}

					else if (CarInfoArr.size() == 0) {
						System.out.println("-----------조회 결과가 없습니다.-----------");
					}

					// 입력 화면
				} else if (gubun == 2) {
					// 입력 로직 변수
					String no, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn, accident_yn, fuel_type;
					// 입력 로직 do_whlie문 변수
					String model_name_pass = "", car_number_pass = "", car_made_pass = "", car_made_ym_pass = "", auto_yn_pass = "", option_yn_pass = "", accident_yn_pass = "", fuel_type_pass = "";

					// 번호 순서대로 자동으로 추가
					CarInfoArr = CarInfoDao.selectDB(1, "", "", "");
					if (CarInfoArr.size() == 0) {
						no = "C001";
					} else {
						no = CarInfoDao.insertDBNo();
						no = CarInfoDao.getNo(no);
					}

					// 모델명 입력 + 예외처리
					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 모델명 입력");
						System.out.println("================================================");
						System.out.print("입력 : ");
						model_name = sc.next();
						model_name_pass = CarInfoDao.getStringLengthEx("모델명", model_name, 20);
					} while (!model_name_pass.equals("ture"));

					// 차번호 입력 + 예외처리
					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 번호 입력");
						System.out.println("================================================");
						System.out.print("입력 : ");
						car_number = sc.next();
						car_number_pass = CarInfoDao.getStringLengthEx("차번호", car_number, 15);
					} while (!car_number_pass.equals("ture"));

					// 제조사 입력 + 예외처리
					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 제조사 입력");
						System.out.println("================================================");
						System.out.println("현대-------[10]   기아------[20]   르노삼성----[30]");
						System.out.println("쌍용------[40]    쉐보레------[50]  빤츠-------[60]");
						System.out.println("뱜떠블유----[70]   아우디-----[80]   테슬라------[90]");
						System.out.println("================================================");
						System.out.print("입력 : ");
						car_made = sc.next();
						car_made_pass = CarInfoDao.getCarMadeEx(car_made);
					} while (!car_made_pass.equals("ture"));

					// 차량 제조년월 입력 + 예외처리
					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 제조년월 입력");
						System.out.println("ex)199901");
						System.out.println("================================================");
						System.out.print("입력 : ");
						car_made_ym = sc.next();
						car_made_ym_pass = CarInfoDao.getStringLengthEx("차량 제조년월", car_made_ym, 6);
					} while (!car_made_ym_pass.equals("ture"));

					// 차량 기어 입력 + 예외처리
					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 기어종류 입력");
						System.out.println("자동[y]\t수동[n]");
						System.out.println("================================================");
						System.out.print("입력 : ");
						auto_yn = sc.next();
						auto_yn = CarInfoDao.getYNResult(auto_yn);
						if (auto_yn.equals("y") || auto_yn.equals("n"))
							auto_yn_pass = "ture";
						else
							auto_yn_pass = "false";
					} while (!auto_yn_pass.equals("ture"));

					// 옵션 유무 입력 + 예외처리
					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 옵션유무 입력");
						System.out.println("있음[y]\t없음[n]");
						System.out.println("================================================");
						System.out.print("입력 : ");
						option_yn = sc.next();
						option_yn = CarInfoDao.getYNResult(option_yn);
						if (option_yn.equals("y") || option_yn.equals("n"))
							option_yn_pass = "ture";
						else
							option_yn_pass = "false";
					} while (!option_yn_pass.equals("ture"));

					// 사고 유무 입력 + 예외처리
					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 사고유무 입력");
						System.out.println("있음[y]\t없음[n]");
						System.out.println("================================================");
						System.out.print("입력 : ");
						accident_yn = sc.next();
						accident_yn = CarInfoDao.getYNResult(accident_yn);
						if (accident_yn.equals("y") || accident_yn.equals("n"))
							accident_yn_pass = "ture";
						else
							accident_yn_pass = "false";
					} while (!accident_yn_pass.equals("ture"));

					// 유류 입력 + 예외처리
					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 유류 입력");
						System.out.println("가솔린[1]\t디젤[2]\tLPG[3]\t전기[4]");
						System.out.println("================================================");
						System.out.print("입력 : ");
						fuel_type = sc.next();
						if (fuel_type.equals("1") || fuel_type.equals("2") || fuel_type.equals("3") || fuel_type.equals("4")) {
							fuel_type_pass = "ture";
						} else {
							System.out.println("다시 입력해주세요");
							fuel_type_pass = "false";
							fuel_type = "";
						}
					} while (!fuel_type_pass.equals("ture"));

					// 입고일 입력
					System.out.println("================================================");
					System.out.println("\t\t차량 입고일 입력");
					System.out.println("ex)19990101");
					System.out.println("================================================");
					System.out.print("입력 : ");
					String import_date = sc.next();

					// 렌트 구분
					String rent_gubun = "y";

					int insertResult = CarInfoDao.insertDB(no, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn, accident_yn, fuel_type, import_date, rent_gubun);
					System.out.println("║===============" + insertResult + "행 등록되었습니다============║");

					// 수정
				} else if (gubun == 3) {

					// 삭제
				} else if (gubun == 4) {
					System.out.println("================================================");
					System.out.println("\t\t삭제할 번호 입력");
					System.out.println("================================================");
					System.out.print("입력 : ");
					String deleteNo = sc.next();
					deleteNo = deleteNo.toUpperCase();
					int deleteResult = CarInfoDao.deleteDB(deleteNo);
					System.out.println("║===============" + deleteResult + "행 삭제되었습니다============║");
					
					
					// 종료
				} else if (gubun == 0) {
					break;
				}

				// 진행 여부
				System.out.println("계속하려면 아무키나 누르세요  ---- 종료[0]");
				String shutdown = sc.next();
				if (shutdown.equals("0")) {
					gubun = 0;
				}

			} catch (Exception e) {
				System.out.println("입력 오류입니다.");
				gubun = 0;
			}
		} while (gubun != 0);
		System.out.println("시스템을 종료합니다.");
	}

}
