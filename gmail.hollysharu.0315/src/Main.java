import java.util.ArrayList;
import java.util.Comparator;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      //테이블 구조의 데이터를 저장할 자료구조를 생성
      List<Map<String, Object>> table = 
            new ArrayList<Map<String, Object>>();
            //데이터를 생성해서 저장 : 데이터베이스 연동이면 반복문을 이용해서 삽입
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("num", 1);
      map.put("name", "휘인");
      map.put("phone", "010-9999-2222");
      map.put("birth", new Date(95, 8, 5));
      table.add(map);
      
      map = new HashMap<String, Object>();
      map.put("num", 2);
      map.put("name", "솔라");
      map.put("phone", "010-3333-4444");
      map.put("birth", new Date(93, 3, 27));
      table.add(map);

      map = new HashMap<String, Object>();
      map.put("num", 3);
      map.put("name", "문별");
      map.put("phone", "010-5555-6666");
      map.put("birth", new Date(87, 3, 25));
      table.add(map);
      
      map = new HashMap<String, Object>();
      map.put("num", 4);
      map.put("name", "화사");
      map.put("phone", "010-7777-8888");
      map.put("birth", new Date(81, 12, 24));
      table.add(map);
   
      Comparator<Map<String, Object>> numAsc = new Comparator<Map<String, Object>>(){
         @Override
         public int compare(Map<String, Object> o1, Map<String, Object> o2) {
            int num1 = (Integer)o1.get("num");
            int num2 = (Integer)o2.get("num");
            return num1 - num2;
         }
      };
         table.sort(numAsc);
            
         Comparator<Map<String, Object>> numDesc = new Comparator<Map<String, Object>>(){
               @Override
               public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                  int num1 = (Integer)o1.get("num");
                  int num2 = (Integer)o2.get("num");
                  return num2 - num1;
               }
            };
               table.sort(numDesc);
               
      Comparator<Map<String, Object>> nameAsc = new Comparator<Map<String, Object>>(){
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
               String name1 = (String)o1.get("name");
               String name2 = (String)o2.get("name");
               return name1.compareTo(name2);
            }
         };
         table.sort(nameAsc);
         
            Comparator<Map<String, Object>> nameDesc = new Comparator<Map<String, Object>>(){
                  @Override
                  public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                     String name1 = (String)o1.get("name");
                     String name2 = (String)o2.get("name");
                     return name2.compareTo(name1);
                  }
               };
                     table.sort(numDesc);
            
                     Comparator<Map<String, Object>> birthAsc = new Comparator<Map<String, Object>>(){
                           @Override
                           public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                              Date birth1 = (Date)o1.get("birth");
                              Date birth2 = (Date)o2.get("birth");
                              return birth1.compareTo(birth2);
                           }
                        };
                        table.sort(birthAsc);
                        
                        Comparator<Map<String, Object>> birthDesc = new Comparator<Map<String, Object>>(){
                              @Override
                              public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                                 Date birth1 = (Date)o1.get("birth");
                                 Date birth2 = (Date)o2.get("birth");
                                 return birth2.compareTo(birth1);
                              }
                           };
                           table.sort(birthDesc);
               
               
      Scanner sc = new Scanner(System.in);
      final String  번호오름차순 = "1";
      final String  번호내림차순 = "2";
      final String  이름오름차순 = "3";
      final String  이름내림차순 = "4";
      final String  생일오름차순 = "5";
      final String  생일내림차순 = "6";
      final String  종료 = "7";
      
      System.out.printf("정렬 옵션을 선택하세요!!\n");
      System.out.printf("1.번호오름차순 2.번호내림차순 3.이름오름차순 4. 이름내림차순 5.생일오름차순 6.생일내림차순\n");
      String menu = sc.nextLine();
      switch(menu) {
      case 번호오름차순:
         table.sort(numAsc);
         break;
      case 번호내림차순:
         table.sort(numDesc);
         break;
      case 이름오름차순:
         table.sort(nameAsc);
         break;
      case 이름내림차순:
         table.sort(nameDesc);
         break;
      case 생일오름차순:
         table.sort(birthAsc);
         break;
      case 생일내림차순:
         table.sort(birthDesc);
         break;
      case 종료:
         System.exit(0);
         break;
         default:
            System.out.printf("번호는 1-6까지만 선택");
            return;
      }
            
      //헤더 출력
      System.out.printf("번호\t이름\t전화번호\t\t       생일\n"); //띄어쓰기 칸맞추려고
      
      //데이터 출력
      for(Map<String, Object> imsi: table) {
         System.out.printf("%s\t%s\t%s\t%s\n", imsi.get("num"),
         imsi.get("name"), imsi.get("phone"), imsi.get("birth"));
      }      
   }
}