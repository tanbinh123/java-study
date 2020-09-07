package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.CarInfo_dao;
import dao.CarRent_dao;
import dao.common_dao;
import dao.member_dao;
import dto.CarInfo_dto;
import dto.CarRent_dto;
import dto.member_dto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<CarInfo_dto> CarInfoArr = new ArrayList<>();
		ArrayList<CarRent_dto> CarRentArr = new ArrayList<>();
		ArrayList<member_dto> memberArr = new ArrayList<>();
		CarInfo_dao CarInfoDao = new CarInfo_dao();
		CarRent_dao CarRentDao = new CarRent_dao();
		common_dao commonDao = new common_dao();
		member_dao memberDao = new member_dao();
		Scanner sc = new Scanner(System.in);
		int gubun = -1, showGubun = -1, mgubun = -1;
		String ShutDown = "", backToMain = "";
		String showGubun_pass = "", update_pass = "";
		// 입력 로직 변수
		String no, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn, accident_yn, fuel_type;
		String updateYn;

		// 입력 로직 do_whlie문 변수
		String model_name_pass = "", car_number_pass = "", car_made_pass = "", car_made_ym_pass = "", auto_yn_pass = "", option_yn_pass = "", accident_yn_pass = "", fuel_type_pass = "";
		String updateYn_pass = "";
		
		int workGubun = 0, age = 0;
		String telValue = "", tel = "";

		do {
			try {
				// 메인 화면
				System.out.println("=====================================");
				System.out.println("\t\t메인 화면");
				System.out.println("=====================================");
				System.out.println("   조회-------[1]        등록------[2]");
				System.out.println("   수정-------[3]        삭제------[4]");
				System.out.println("   대여-------[5]        반납------[6]");
				System.out.println("   회원관리----[7]        대여내역---[8]");
				System.out.println("   종료-------[0]");
				System.out.println("=====================================");
				System.out.print("입력 : ");
				gubun = sc.nextInt();

				// 조회 화면

				if (gubun == 1) {
					do {
						System.out.println("=========================================");
						System.out.println("\t\t조회 화면");
						System.out.println("=========================================");
						System.out.println("   제조사별 조회------[1]     모델명으로 조회--[2]");
						System.out.println("   차번호로 조회------[3]     전체 조회------[9]");
						System.out.println("   메인 화면으로----[0]");
						System.out.println("=========================================");
						System.out.print("입력 : ");
						showGubun = sc.nextInt();

						// 전체 조회
						if (showGubun == 9) {
							CarInfoArr = CarInfoDao.selectDB(1, "");

							// 제조사별로 조회 + 예외처리
						} else if (showGubun == 1) {
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
								searchMade_pass = commonDao.getCarMadeEx(searchMade);
							} while (!searchMade_pass.equals("ture"));
							CarInfoArr = CarInfoDao.selectDB(2, searchMade);

							// 모델명으로 조회 + 예외처리
						} else if (showGubun == 2) {
							String searchModelName, searchModelName_pass = "";
							do {
								System.out.println("================================================");
								System.out.println("\t\t모델명으로 조회");
								System.out.println("================================================");
								System.out.print("입력 : ");
								searchModelName = sc.next();
								searchModelName_pass = commonDao.getStringLengthEx("모델명", searchModelName, 20);
							} while (!searchModelName_pass.equals("ture"));
							CarInfoArr = CarInfoDao.selectDB(3, searchModelName);

							// 차번호로 조회 + 예외처리
						} else if (showGubun == 3) {
							String searchCarNumber, searchCarNumber_pass = "";
							do {
								System.out.println("================================================");
								System.out.println("\t\t차번호로 조회");
								System.out.println("================================================");
								System.out.print("입력 : ");
								searchCarNumber = sc.next();
								searchCarNumber_pass = commonDao.getStringLengthEx("차번호", searchCarNumber, 6);
							} while (!searchCarNumber_pass.equals("ture"));
							CarInfoArr = CarInfoDao.selectDB(4, searchCarNumber);

							// 메인화면으로 돌아가기
						} else if (showGubun == 0) {
							gubun = -1;
							showGubun_pass = "true";
							backToMain = "true";
							continue;
						}

						// 조회 결과
						if (CarInfoArr.size() != 0) {
							System.out.println("================================================================================================================");
							System.out.println("등록 번호\t모델명\t차번호\t제조사\t제조년월\t기어\t옵션유무\t사고유무\t연료\t입고일\t\t대여가능여부");
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

						// 진행 여부
						System.out.println("조회를 계속하려면 아무거나 입력해주세요.  ---- 조회 계속하기[1] 메인메뉴로 가기[0]");
						ShutDown = sc.next();
						if (ShutDown.equals("0")) {
							showGubun_pass = "true";
							backToMain = "true";
							showGubun = 0;
						} else {
							showGubun_pass = "false";
						}

					} while (!showGubun_pass.equals("true"));

					// 입력 화면
				} else if (gubun == 2) {

					// 번호 순서대로 자동으로 추가
					CarInfoArr = CarInfoDao.selectDB(1, "");
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
						model_name_pass = commonDao.getStringLengthEx("모델명", model_name, 20);
					} while (!model_name_pass.equals("ture"));

					// 차번호 입력 + 예외처리
					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 번호 입력");
						System.out.println("================================================");
						System.out.print("입력 : ");
						car_number = sc.next();
						car_number_pass = commonDao.getStringLengthEx("차번호", car_number, 15);
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
						car_made_pass = commonDao.getCarMadeEx(car_made);
					} while (!car_made_pass.equals("ture"));

					// 차량 제조년월 입력 + 예외처리
					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 제조년월 입력");
						System.out.println("ex)199901");
						System.out.println("================================================");
						System.out.print("입력 : ");
						car_made_ym = sc.next();
						car_made_ym_pass = commonDao.getStringLengthEx("차량 제조년월", car_made_ym, 6);
					} while (!car_made_ym_pass.equals("ture"));

					// 차량 기어 입력 + 예외처리
					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 기어종류 입력");
						System.out.println("자동[y]\t수동[n]");
						System.out.println("================================================");
						System.out.print("입력 : ");
						auto_yn = sc.next();
						auto_yn = commonDao.getYNResult(auto_yn);
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
						option_yn = commonDao.getYNResult(option_yn);
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
						accident_yn = commonDao.getYNResult(accident_yn);
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
					do {
						System.out.println("================================================");
						System.out.println("\t\t수정할 등록 번호 입력");
						System.out.println("================================================");
						System.out.print("입력 : ");
						String updateNo = sc.next();
						updateNo = updateNo.toUpperCase();
						CarInfoArr = CarInfoDao.selectDB(5, updateNo);
						if (CarInfoArr.size() != 0) {
							System.out.println("================================================================================================================");
							System.out.println("등록 번호\t모델명\t차번호\t제조사\t제조년월\t기어\t옵션유무\t사고유무\t연료\t입고일\t\t대여가능여부");
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

							do {
								System.out.println("수정하시겠습니까? (Y/N)");// y면 진행 n면 메인화면
								updateYn = sc.next();
								updateYn = commonDao.getYNResult(updateYn);
								if (updateYn.equals("y") || updateYn.equals("n"))
									updateYn_pass = "ture";
								else
									updateYn_pass = "false";
							} while (updateYn_pass.equals("true"));
							if (updateYn.equals("y")) {
								// 모델명 입력 + 예외처리
								do {
									System.out.println("================================================");
									System.out.println("\t\t차량 모델명 입력");
									System.out.println("================================================");
									System.out.print("입력 : ");
									model_name = sc.next();
									model_name_pass = commonDao.getStringLengthEx("모델명", model_name, 20);
								} while (!model_name_pass.equals("ture"));

								// 차번호 입력 + 예외처리
								do {
									System.out.println("================================================");
									System.out.println("\t\t차량 번호 입력");
									System.out.println("================================================");
									System.out.print("입력 : ");
									car_number = sc.next();
									car_number_pass = commonDao.getStringLengthEx("차번호", car_number, 15);
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
									car_made_pass = commonDao.getCarMadeEx(car_made);
								} while (!car_made_pass.equals("ture"));

								// 차량 제조년월 입력 + 예외처리
								do {
									System.out.println("================================================");
									System.out.println("\t\t차량 제조년월 입력");
									System.out.println("ex)199901");
									System.out.println("================================================");
									System.out.print("입력 : ");
									car_made_ym = sc.next();
									car_made_ym_pass = commonDao.getStringLengthEx("차량 제조년월", car_made_ym, 6);
								} while (!car_made_ym_pass.equals("ture"));

								// 차량 기어 입력 + 예외처리
								do {
									System.out.println("================================================");
									System.out.println("\t\t차량 기어종류 입력");
									System.out.println("자동[y]\t수동[n]");
									System.out.println("================================================");
									System.out.print("입력 : ");
									auto_yn = sc.next();
									auto_yn = commonDao.getYNResult(auto_yn);
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
									option_yn = commonDao.getYNResult(option_yn);
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
									accident_yn = commonDao.getYNResult(accident_yn);
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

								int updateResult = CarInfoDao.updateDB(updateNo, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn, accident_yn, fuel_type, import_date);
								System.out.println("================================================");
								System.out.println("\t\t수정 결과");
								System.out.println("================================================");
								System.out.println("================================================================================================================");
								System.out.println("등록 번호\t모델명\t차번호\t제조사\t제조년월\t기어\t옵션유무\t사고유무\t연료\t입고일\t\t대여가능여부");
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
								CarInfoArr = CarInfoDao.selectDB(5, updateNo);
								System.out.println();
								System.out.println("\t↓\t\t↓\t\t↓\t\t↓\t\t↓\t\t↓\t\t↓");
								System.out.println();
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

								System.out.println("===============" + updateResult + "행 수정되었습니다============");

							} else if (updateYn.equals("n")) {
								update_pass = "true";
								backToMain = "true";
								continue;
							}

						} else if (CarInfoArr.size() == 0) {
							System.out.println("-----------조회 결과가 없습니다.-----------");
						}
						// 진행 여부
						System.out.println("수정를 계속하려면 아무거나 입력해주세요.  ---- 수정 계속하기[1] 메인메뉴로 가기[0]");
						ShutDown = sc.next();
						if (ShutDown.equals("0")) {
							update_pass = "true";
							backToMain = "true";
							showGubun = 0;
						} else {
							update_pass = "false";
						}
					} while (!update_pass.equals("true"));

					// 삭제
				} else if (gubun == 4) {
					do {
						System.out.println("================================================");
						System.out.println("\t\t삭제할 등록 번호 입력");
						System.out.println("================================================");
						System.out.print("입력 : ");
						String deleteNo = sc.next();
						deleteNo = deleteNo.toUpperCase();
						int deleteResult = CarInfoDao.deleteDB(deleteNo);
						if (deleteResult >= 1) {
							System.out.println("===============" + deleteResult + "행 삭제되었습니다============");
						} else {
							System.out.println("-----------삭제 결과가 없습니다.번호를 다시 확인해주세요.-----------");
						}

						// 진행 여부
						System.out.println("삭제를 계속하려면 아무거나 입력해주세요.  ---- or 삭제 계속하기[1] 메인메뉴로 가기[0]");
						ShutDown = sc.next();
						if (ShutDown.equals("0")) {
							update_pass = "true";
							backToMain = "true";
							showGubun = 0;
						} else {
							update_pass = "false";
						}
					} while (!update_pass.equals("true"));
					// 렌트
				} else if (gubun == 5) {
					String carNo, memberNo;
					String carNo_pass = "", memberNo_pass = "";
					int countResult = 0;

					// 번호 순서대로 자동으로 추가
					CarRentArr = CarRentDao.selectDB(1, "");
					if (CarRentArr.size() == 0) {
						no = "R001";
					} else {
						no = CarRentDao.selectDBNo();
						no = CarRentDao.getNo(no);
					}
					do {
						System.out.println("================================================");
						System.out.println("\t\t멤버 번호 입력");
						System.out.println("================================================");
						System.out.print("입력 : ");
						memberNo = sc.next();
						memberNo = memberNo.toUpperCase();
						memberNo_pass = commonDao.getStringLengthEx("멤버 번호", memberNo, 5);
						memberArr = memberDao.selectDBId(memberNo);
						System.out.println(memberArr.get(0).getName()+"님 맞으십니까?(y/n)");
						String checkMember = sc.next();
						checkMember = commonDao.getYNResult(checkMember);
						if(checkMember.equals("y"))memberNo_pass = "ture";
						else memberNo_pass = "false";
					} while (!memberNo_pass.equals("ture"));

					do {
						System.out.println("================================================");
						System.out.println("\t\t차량 번호 입력");
						System.out.println("================================================");
						System.out.print("입력 : ");
						carNo = sc.next();
						carNo = carNo.toUpperCase();
						// 글자 수 예외처리
						carNo_pass = commonDao.getStringLengthEx("차량 번호", carNo, 4);
						// 차량 유무 검증
						try {
							countResult = CarRentDao.selectCountDB(carNo); // 카운터 1이상이면 차량 있음
							if (countResult >= 1) {
								CarInfoArr = CarInfoDao.selectDB(5, carNo); // rent_gubun y,n 조회
								if (CarInfoArr.get(0).getRent_gubun().equals("가능")) {// y일때
									//차량 정보 확인
									System.out.println("대여차량 : "+CarInfoArr.get(0).getModel_name() + " 맞으십니까?(y/n)");
									String checkCar = sc.next();
									checkCar = commonDao.getYNResult(checkCar);
									if(checkCar.equals("y"))carNo_pass = "ture";
									else carNo_pass = "false";
								} else if (CarInfoArr.get(0).getRent_gubun().equals("불가능")) {// n일때
									System.out.println("이미 대여 중인 차량입니다. 다른 차량을 이용해주세요.");
									carNo_pass = "false";
								}
							} else if (countResult == 0) {// 카운터 0일때
								System.out.println("차량 번호를 확인하고 다시 입력해주세요.");
								carNo_pass = "false";
							}
						} catch (Exception e) {
							System.out.println("차량 번호를 확인하고 다시 입력해주세요.");
							carNo_pass = "false";
						}
					} while (!carNo_pass.equals("ture"));

					System.out.println("================================================");
					System.out.println("\t\t차량 대여일 입력");
					System.out.println("ex)19990101");
					System.out.println("================================================");
					System.out.print("입력 : ");
					String rentDate = sc.next();
					
					System.out.println("================================================");
					System.out.println("\t\t차량 예상 반납일 입력");
					System.out.println("ex)19990101");
					System.out.println("================================================");
					System.out.print("입력 : ");
					String returnExpectDate = sc.next();
					
					
					int rentResult = CarRentDao.insertDB(no, memberNo, carNo, rentDate, returnExpectDate); // rent table 데이터 입력
					
					if (rentResult != 0) {
						CarRentDao.updateDB(carNo,1); // 차량 테이블 rent_gubun 'n'으로 변경
						System.out.println("===============차량이 대여되었습니다.===========");
					}
						
					// 반납
				} else if (gubun == 6) {
					String returnNo = "", returnNo_pass = "";
					int countResult = 0;
					do {
						System.out.println("================================================");
						System.out.println("\t\t반납할 차량 번호 입력");
						System.out.println("================================================");
						System.out.print("입력 : ");
						returnNo = sc.next();
						returnNo = returnNo.toUpperCase();
						// 글자 수 예외처리
						returnNo_pass = commonDao.getStringLengthEx("차량 번호", returnNo, 4);
						// 차량 유무 검증
						try {
							countResult = CarRentDao.selectCountDB2(returnNo); // 카운터 1이상이면 차량 있음
							if (countResult >= 1) {
								CarInfoArr = CarInfoDao.selectDB(5, returnNo); // rent_gubun y,n 조회
								if (CarInfoArr.get(0).getRent_gubun().equals("불가능")) {// n일때
									returnNo_pass = "ture";
								} else if (CarInfoArr.get(0).getRent_gubun().equals("가능")) {// y일때
									System.out.println("이미 반납 완료된 차량입니다.");
									returnNo_pass = "false";
								}
							} else if (countResult == 0) {// 카운터 0일때
								System.out.println("차량 번호를 확인하고 다시 입력해주세요.");
								returnNo_pass = "false";
							}
						} catch (Exception e) {
							System.out.println("차량 번호를 확인하고 다시 입력해주세요e.");
							returnNo_pass = "false";
						}
					} while (!returnNo_pass.equals("ture"));
					
					System.out.println("================================================");
					System.out.println("\t\t차량 반납일 입력");
					System.out.println("ex)19990101");
					System.out.println("================================================");
					System.out.print("입력 : ");
					String returnDate = sc.next();
					
					int returnResult = CarRentDao.updateReturnDB(returnNo, returnDate); // rent table 데이터 업데이트
					int returnDayResult = CarRentDao.updateGetReturnDay(returnNo); // rent day 구해서 업데이트
					if (returnResult != 0 && returnDayResult != 0)
						CarRentDao.updateDB(returnNo,2); // 차량 테이블 rent_gubun 'y'으로 변경
						System.out.println("===============차량이 반납되었습니다.===========");
				}else if(gubun == 7) {
					System.out.println("║============================================║");
					System.out.println("║___  ___                  _                 ║\r\n"
							+ "║|  \\/  |                 | |                ║\r\n"
							+ "║| .  . |  ___  _ __ ___  | |__    ___  _ __ ║\r\n"
							+ "║| |\\/| | / _ \\| '_ ` _ \\ | '_ \\  / _ \\| '__|║\r\n"
							+ "║| |  | ||  __/| | | | | || |_) ||  __/| |   ║\r\n"
							+ "║\\_|  |_/ \\___||_| |_| |_||_.__/  \\___||_|   ║");
					System.out.println("║============================================║");
					System.out.println("║회원 조회--------[1]     회원 등록--------[2] ║");
					System.out.println("║회원 수정--------[3]     회원 삭제--------[4] ║");
					System.out.println("║이전 화면--------[0]                         ║");
					System.out.println("║============================================║");
					System.out.print("입력 : ");
					mgubun = sc.nextInt();
					if (mgubun == 1) {//회원관리/회원조회
						System.out.println("║===========================================║");
						System.out.println("" + "║           _   _  _                        ║\r\n"
								+ "║          | | | |(_)                       ║\r\n"
								+ "║          | | | | _   ___ __      __       ║\r\n"
								+ "║          | | | || | / _ \\\\ \\ /\\ / /       ║\r\n"
								+ "║          \\ \\_/ /| ||  __/ \\ V  V /        ║\r\n"
								+ "║           \\___/ |_| \\___|  \\_/\\_/         ║");
						System.out.println("║===========================================║");
						System.out.println("║전체 조회--------[1]    아이디로 조회-----[2]║");
						System.out.println("║이름으로 조회-----[3]    이전 화면--------[0]║");
						System.out.println("║===========================================║");
						System.out.print("입력 : ");
						showGubun = sc.nextInt();
						if (showGubun == 1) {//회원관리/회원조회/전체조회
							memberArr = memberDao.selectDB(showGubun, "", "");
						} else if (showGubun == 2) {//회원관리/회원조회/아이디로조회
							System.out.println("║===========================================║");
							System.out.println("║             아이디로 회원 조회                     ║");
							System.out.println("║===========================================║");
							System.out.print("조회할 아이디 입력 : ");
							String id = sc.next();
							id = id.toUpperCase();
							memberArr = memberDao.selectDB(showGubun, id, "");
						} else if (showGubun == 3) {//회원관리/회원조회/이름으로조회
							System.out.println("║===========================================║");
							System.out.println("║             이름으로 회원 조회                     ║");
							System.out.println("║===========================================║");
							System.out.print("조회할 이름 입력 : ");
							String name = sc.next();
							memberArr = memberDao.selectDB(showGubun, "", name);
						}
						if (memberArr.size() != 0) {//조회 결과

							System.out.println("║=========================================================║");
							System.out.println("" + "║          ______                    _  _                 ║\r\n"
									+ "║          | ___ \\                  | || |                ║\r\n"
									+ "║          | |_/ /  ___  ___  _   _ | || |_               ║\r\n"
									+ "║          |    /  / _ \\/ __|| | | || || __|              ║\r\n"
									+ "║          | |\\ \\ |  __/\\__ \\| |_| || || |_               ║\r\n"
									+ "║          \\_| \\_| \\___||___/ \\__,_||_| \\__|              ║");
							System.out.println("║=========================================================║");
							System.out.println("║아이디\t이름\t주소\t전화 번호\t나이\t가입일\t  ║");
							System.out.println("║=========================================================║");
							for (int i = 0; i < memberArr.size(); i++) {
								System.out.print("║" + memberArr.get(i).getId() + "\t");
								System.out.print(memberArr.get(i).getName() + "\t");
								System.out.print(memberArr.get(i).getAddress() + "\t");
								System.out.print(memberArr.get(i).getTel() + "\t");
								System.out.print(memberArr.get(i).getAge() + "\t");
								System.out.print(memberArr.get(i).getReg_date() + "║\n");
							}
							System.out.println("║=========================================================║");
						}
					} else if (mgubun == 2) {//회원관리/회원등록
						String id = "";
						memberArr = memberDao.selectDB(1, "", "");
						if (memberArr.size() == 0) {
							id = "B0001";
						} else {
							id = memberDao.insertDBNo();
							id = memberDao.getNo(id);
						}
						System.out.println("║===========================================║");
						System.out.println("║                  회원 등록                          ║");
						System.out.println("║===========================================║");
						System.out.print("이름 입력 : ");
						String name = sc.next();
						System.out.print("주소 입력 : ");
						String address = sc.next();

						do {
							System.out.print("전화번호 입력 : ");
							tel = sc.next();
							for (int i = 0; i < tel.length(); i++) {
								char c = tel.charAt(i);
								if (c < 48 || c > 57) {
									System.out.println("전화 번호를 다시 입력해주세요");
									telValue = "false";
									tel = "";
								} else if (c > 48 || c < 57) {
									telValue = "ture";
								}
							}
							if (tel.length() > 13) {
								System.out.println("전화번호는 13자리까지만 입력해주세요");
								telValue = "false";
								tel = "";
							}
						} while (!telValue.equals("ture"));
						String Tel = memberDao.phone(tel);

						do {
							System.out.print("나이 입력 : ");
							age = sc.nextInt();
							if (age > 200) {
								System.out.println("나이를 다시 입력해주세요");
							}
						} while (age > 200);

						int result = memberDao.insertDB(id, name, address, Tel, age);
						System.out.println("║===============" + result + "행 등록되었습니다============║");

					} else if (mgubun == 3) {//회원관리/회원수정
						System.out.println("║===========================================║");
						System.out.println("║                회원 정보 수정                      ║");
						System.out.println("║===========================================║");
						System.out.print("수정할 아이디 검색 : ");
						String id = sc.next();
						id = id.toUpperCase();
						memberArr = memberDao.selectDB(2, id, "");
						System.out.print("기존 이름 : " + memberArr.get(0).getName() + "\n수정 할 이름 : ");
						String name = sc.next();
						System.out.print("기존 주소 : " + memberArr.get(0).getAddress() + "\n수정 할 주소 : ");
						String address = sc.next();

						do {
							System.out.print("기존 전화번호 : " + memberArr.get(0).getTel() + "\n수정 할 전화번호 : ");
							tel = sc.next();
							for (int i = 0; i < tel.length(); i++) {
								char c = tel.charAt(i);
								if (c < 48 || c > 57) {
									System.out.println("전화 번호를 다시 입력해주세요");
									telValue = "false";
									tel = "";
								} else if (c > 48 || c < 57) {
									telValue = "ture";
								}
							}
							if (tel.length() > 13) {
								System.out.println("전화번호는 13자리까지만 입력해주세요");
								telValue = "false";
								tel = "";
							}
						} while (!telValue.equals("ture"));
						String Tel = memberDao.phone(tel);

						do {
							System.out.print("기존 나이 : " + memberArr.get(0).getAge() + "\n수정 할 나이 : ");
							age = sc.nextInt();
							if (age > 200) {
								System.out.println("나이를 다시 입력해주세요");
							}
						} while (age > 200);

						int result = memberDao.updateDB(id, name, address, tel, age);
						System.out.println("║===============" + result + "행 수정되었습니다============║");

					} else if (mgubun == 4) {//회원관리/회원삭제
						System.out.println("║===========================================║");
						System.out.println("║                 회원 삭제                           ║");
						System.out.println("║===========================================║");
						System.out.print("삭제 할 아이디 검색 : ");
						String id = sc.next();
						id = id.toUpperCase();
						int result = memberDao.deleteDB(id);
						System.out.println("║===============" + result + "행 삭제되었습니다============║");
					}else if (mgubun == 0) {
						continue;
				}else if(gubun == 8) {
					
				}
					// 종료
				} else if (gubun == 0) {
					break;
				}

				// 진행 여부
				if (!showGubun_pass.equals("true") && !backToMain.equals("true") || !update_pass.equals("true") && !backToMain.equals("true")) {
					System.out.println("계속하려면 아무거나 입력해주세요.  ---- 계속하기[1] 종료[0]");
					String shutdown = sc.next();
					if (shutdown.equals("0")) {
						gubun = 0;
					} else {

					}
				}
			} catch (Exception e) {
				System.out.println("입력 오류입니다.");
				gubun = 0;
			}
		} while (gubun != 0);
		System.out.println("시스템을 종료합니다.");
	}

}
