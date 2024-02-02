import java.util.InputMismatchException;
import java.util.Scanner;

class Main extends RockPaperScissors {
    public static void main(String[] args) {

        RockPaperScissors RPS = new RockPaperScissors();
        NumberAddress NA = new NumberAddress();
        int level;
        

        //入力するためにスキャナークラスをインスタンス化
        Scanner stdIn = new Scanner(System.in);


        //入力させて遊ぶゲームを選んでもらう
        
        //選択したゲームに分岐するための変数の初期化
        int number = 0;

        while (true) {
            number = 0;
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("下の選択肢から選んでね！");
            System.out.println("じゃんけん：１");
            System.out.println("数当てゲーム：２");
            System.out.println("ドラゴン討伐！：３");
            System.out.println("終了：１００");
            System.out.print("数字を入力しよう！：");
            //例外処理で選択する際に整数以外のものが入力できないようにする
            
            //例外処理で選択する際に整数以外のものが入力できないようにする
            try {
                number = stdIn.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("指定してる数字が違うよ！馬鹿なのかな？");
                System.out.println("ちゃんとしてされている数字を入力してね？");
                stdIn.nextLine();
            }

            //じゃんけんの処理
            if (number == 1)  {
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("じゃんけんを始めるよ！");
                System.out.println("じゃんけんポン！");
                System.out.println("グー：1　パー：2　チョキ：3");
                int hand = 0;
                try {
                    hand = stdIn.nextInt();
                }
                catch (Exception e) {
                    stdIn.nextLine();
                }
                System.out.println("-----------------------------------------------------------------------------------");
                //じゃんけんの結果の処理
                RPS.jyankenresult(hand);
            }


            else if (number == 2) {
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("数当てゲームを始めるよ！");
                NA.number_guess();      
            }

            else if (number == 3) {
                System.out.println("ドラゴン討伐！");
                System.out.println("難易度を選んでね！");
                System.out.println("easy:1　normal:2　hard:3　extreme:4");
                System.out.print("難易度を選んでね！：");
                level = 0;
                try {
                    level = stdIn.nextInt();
                }
                catch (Exception e) {
                    System.out.println("指定してる数字が違うよ！馬鹿なのかな？");
                    stdIn.nextLine();
                }
                if (level == 1) {
                    Battle BT = new Battle(100, 10, 10, 10);
                    System.out.println("ドラゴンが現れた！");
                    while (true) {
                        BT.HeroActionStep();
                        if (BT.DragonHP <= 0) {
                            System.out.println("ドラゴンの死亡を確認！");
                            break;
                        }
                        BT.DragonActionStep();
                        if (BT.HeroHP <= 0) {
                            System.out.println("勇者の死亡を確認！");
                            break;
                        }
                        
                    }
                    

                }
            }
            else if (number == 100) {
                break;
            }     
        }
    }
}