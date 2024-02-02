import java.util.Random;
import java.util.Scanner;

public class NumberAddress{
    
    //フィールド
    Random random = new Random();
    Scanner stdIn = new Scanner(System.in);
    int num;
    int count = 0;
    String help;
    int helpcount;
    

    //コンストラクタ
    public NumberAddress() {
    }


    //メソッド
    public void number_guess() {
        //メソッドが実行されるたびに０～９９のランダムの数を作る
        int randomValue = random.nextInt(100);
        System.out.println(randomValue);
        
        System.out.println("０～９９までのランダムな数字を作ったよ！頑張って当ててみてね！");
        
        

        while (true) {

            count += 1;
            num = 100;
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.print("０～９９の数字を入力してね！");
            try {
                num = stdIn.nextInt();
            }
            catch (Exception e) {
                stdIn.nextLine();
            }

            if (num >= 0){
                if (num == randomValue) {
                    System.out.println("すごい！よく当てたね！");
                    helpcount = 0;
                    count = 0;
                    break;
                }
                else if (num > 99) {
                    System.out.println("文章読めるか？頭おかしいんか？");
                }
                else {
                    System.out.println("当たりじゃないよ～");
                    if (count > 2 && helpcount == 0) {
                        System.out.println("ヒントが必要なんじゃない？");
                        System.out.print("yes/no:");
                        help = stdIn.next();
                        if (help.equals("yes")) {
                            if (randomValue >= 50) {
                                System.out.println("50以上の数字らしいよ！");
                            }
                            else {
                                System.out.println("50未満の数字らしいよ！"); 
                            }
                            helpcount = 1;
                        }
                        else if (help.equals("no")) {
                            System.out.println("頑張って当ててみてね～！");
                        }
                        else {
                            System.out.println("まともに返答もできないんか？");
                            System.out.println("ヒント欲しくないんか？");
                        }
                    }
                }
            }
            else if (num < 0) {
                System.out.println("マイナスを入れていいと思ったんか？頭おかしいんか？");
            }
        }

    }
}
