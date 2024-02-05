//ランダムな数字を扱うためjava.util.Randomをインポートする
import java.util.Random;
//入力した文字列や数字を扱うためjava.util.Scannerをインポートする
import java.util.Scanner;

public class NumberAddress{
    
    /************************************************フィールド************************************************/

    //Randomクラスをインスタンス化する
    private Random random = new Random();
    //Scannerクラスをインスタンス化する
    private Scanner stdIn = new Scanner(System.in);
    
    private int num;    //入力側の整数を入れる変数
    private int count = 0;  //数当てに対して何回答えたかのカウントをする変数
    private String help;    //ヒントがいるか要らないかの判別に使う変数
    private int helpcount;  //ヒントを使ったか使ってないかを０と１であらわす変数

    /************************************************メソッド************************************************/
    public void number_guess() {

        //メソッドが実行されるたびに０～９９のランダムの数を作る
        int randomValue = random.nextInt(100);
        System.out.println(randomValue);
        
        //0~99までの整数を当てることを目的としていることを表示する
        System.out.println("０～９９までのランダムな整数を作ったよ！頑張って当ててみてね！");

        //数を当てるまで無限ループする
        while (true) {
            System.out.println("-----------------------------------------------------------------------------------");
            //０～９９までの整数の入力を促す
            System.out.print("０～９９の整数を入力してね！");

            //try catchで例外処理を入れる（半角英数字の整数が入力されているか）
            try {
                //numに入力された整数を入れる
                num = stdIn.nextInt();
                //入力回数を１増やす
                count += 1;
                //マイナスではない場合（本来マイナスは指定された範囲ではないが入力はできるため）
                if (num >= 0){
                    //ランダムに生成された整数と入力された整数が同じ場合
                    if (num == randomValue) {
                        //何回目で当てれたかを表示させる
                        System.out.println("すごい！よく当てたね！\n貴方が入力した回数は"+count+"回だよ！");
                        //ヒントをもらってない状態に戻す
                        helpcount = 0;
                        //入力回数を０に戻す
                        count = 0;
                        //ループから抜け出す
                        break;
                    }
                    //９９（指定された整数）より大きい場合
                    else if (num > 99) {
                        //入力された数が指定範囲より大きいことを表示する
                        System.out.println("指定範囲は守ろうね！");
                    }
                    //それ以外（ランダムに生成された整数と違った場合）
                    else {
                        //同じではない事を表示
                        System.out.println("当たりじゃないよ～");
                        //入力回数が２回以上でヒントをもらっていない（helpcountが0）の時にヒントが必要か聞く
                        if (count > 2 && helpcount == 0) {
                            System.out.println("ヒントが必要なんじゃない？");
                            //yes,noでの入力を促す
                            System.out.print("yes/no:");
                            //入力された文字列を変数helpに入れる
                            help = stdIn.next();
                            //yesと入力された場合の処理
                            if (help.equals("yes")) {
                                //ランダムに生成された整数が５０以上の場合の処理
                                if (randomValue >= 50) {
                                    //正解が５０以上である事を表示
                                    System.out.println("50以上の数字らしいよ！");
                                }
                                //ランダムに生成された整数が５０未満の場合の処理
                                else {
                                    //正解が５０未満である事を表示
                                    System.out.println("50未満の数字らしいよ！"); 
                                }
                                //ヒントを使ったのでhelpcountを１にする
                                helpcount = 1;
                            }
                            //noと入力されたらヒントを表示させない
                            else if (help.equals("no")) {
                                System.out.println("頑張って当ててみてね～！");
                            }
                            //それ以外の場合はyes,noで回答できていない事を表示する
                            else {
                                System.out.println("yesかnoで回答できていないよ！\n次から気を付けてね！");
                            }
                        }
                    }
                }
                //マイナス数値の場合の処理
                else if (num < 0) {
                    //マイナス数値を入れていることを表示
                    System.out.println("マイナスを入れていいと思ったんか？頭おかしいんか？");
                }
            }
            //入力されたものが文字、あるいは全角だった処理
            catch (Exception e) {
                //半角英数字で入力するようにする文を表示させる
                System.out.println("文字とか入力してない？\n半角英数字の整数値で入力してね！");
                stdIn.nextLine();
            }   
        }
    }
}
