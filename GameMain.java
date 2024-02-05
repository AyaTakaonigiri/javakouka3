 //入力を行うのでjava.util.Scannerをインポートする
import java.util.Scanner;

class GameMain {
    public static void main(String[] args) {

        //RockPaperScissorsクラスをインスタンス化する
        RockPaperScissors RPS = new RockPaperScissors();
        //NumberAddressクラスをインスタンス化する
        NumberAddress NA = new NumberAddress();
        //Interpersonalクラスをインスタンス化する
        Interpersonal IP = new Interpersonal();
        //入力するためにスキャナークラスをインスタンス化
        Scanner stdIn = new Scanner(System.in);

        int number; //選択したゲームに分岐するための変数
        int hand;   //じゃんけんの手を決める変数（グー：1　パー：2　チョキ：3）
        int playpartner; //じゃんけんの相手を決める変数（CPU:1　対人戦（二人プレイ）:2）

        //入力させて遊ぶゲームを選んでもらう
        while (true) {
            System.out.println("-----------------------------------------------------------------------------------");
            //選択肢の表示
            System.out.println("全て半角で入力して！じゃないと認識されないよ！\n下の選択肢から選んでね！\nじゃんけん:1\n数当てゲーム:2\nドラゴン討伐:3\n終了:100");
            System.out.print("数字を入力しよう！：");
            
            //例外処理で選択する際に整数以外のものが入力できないようにする
            try {
                number = stdIn.nextInt();
            }
            //文字を入力したときの処理
            catch (Exception e) {
                //ここでnumberを0にしなければ２回目にこの処理が入ると１回目に指定したゲームに入ってしまうの0にしておく
                number = 0;
                stdIn.nextLine();
            }

            //じゃんけんの処理
            if (number == 1)  {
                //一人プレイか二人プレイか決めるまでループする
                while (true) {
                    try {
                        System.out.println("CPU（一人プレイ）:1　対人戦（二人プレイ）:2");
                        System.out.print("どっちで遊ぶ？:");
                        playpartner = stdIn.nextInt();
                    }
                    //文字を入力された場合
                    catch (Exception e) {
                        stdIn.nextLine();
                        //じゃんけんの選択肢にない整数をhandに入れる
                        //これを入れないとエラーが無限に入りループする（playpartnerの初期化）
                        playpartner = 0;
                    }
                    //入力された整数が1,2だった場合ループを抜け出す
                    if (playpartner > 0 && playpartner < 3) {
                        break;
                    }
                    //それ以外の整数値だった場合
                    else {
                        System.out.println("指定された整数値じゃないよ！");
                    }
                }

                //CPU戦の場合
                if (playpartner == 1) {
                    //じゃんけんをすることを表示
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("じゃんけんを始めるよ！");
                    System.out.println("じゃんけんポン！");
                    //選択肢を表示させる
                    System.out.println("グー：1　パー：2　チョキ：3");
                    //例外処理で文字が入らないようにする
                    try {
                        hand = stdIn.nextInt();
                    }
                    //文字を入力された場合
                    catch (Exception e) {
                        stdIn.nextLine();
                        //じゃんけんの選択肢にない整数をhandに入れる
                        //jyankenresultで1,2,3以外の整数を引数として渡すとじゃんけんの結果が返ってこずにちゃんと入力されていない事を伝える文がでるため
                        hand = 0;
                    }
                    System.out.println("-----------------------------------------------------------------------------------");
                    //じゃんけんの結果の処理を表示
                    RPS.jyankenresult(hand);
                    //継続してやるかを聞くためにwhileでループさせる
                    while (true) {
                        System.out.println("もう一回する？");
                        //yes以外は継続しないようにする
                        System.out.print("yes/no：");
                        String onemore = stdIn.next();
                        //もし継続する場合の処理
                        if (onemore.equals("yes")) {
                            //もう一度じゃんけんの処理をする
                            //２回目以降はここでループが回る
                            try {
                                System.out.println("グー：1　パー：2　チョキ：3");
                                hand = stdIn.nextInt();
                            }
                            catch (Exception e) {
                                stdIn.nextLine();
                                //じゃんけんの選択肢にない整数をhandに入れる
                                //jyankenresultで1,2,3以外の整数を引数として渡すとじゃんけんの結果が返ってこずにちゃんと入力されていない事を伝える文がでるため
                                hand = 0;
                            }
                            //じゃんけんの処理
                            RPS.jyankenresult(hand);
                        }
                        //noの場合はループを抜け出す
                        else if (onemore.equals("no")) {
                            break;
                        }

                        //yesかno以外の場合はループを抜け出さない
                        else {
                            //yesかnoで答えるように表示
                            System.out.println("yesかnoで入力してね！");
                            System.out.println("-----------------------------------------------------------------------------------");
                        }

                    }
                }
                //対人戦の場合
                else if (playpartner == 2) {
                    //じゃんけんをすることを表示
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println("対人じゃんけんを始めるよ！");
                    IP.InterpersonalRockPaperScissors();
                    while (true) {
                        System.out.println("もう一回やる？");
                        System.out.print("yes/no:");
                        String AlreadyOnce = stdIn.next();
                        //yesと入力された場合の処理
                        if (AlreadyOnce.equals("yes")) {
                            IP.InterpersonalRockPaperScissors();
                        }
                        //noと入力されたらヒントを表示させない
                        else if (AlreadyOnce.equals("no")) {
                            break;
                        }
                        //それ以外の場合はyes,noで回答できていない事を表示する
                        else {
                            System.out.println("yesかnoで回答できていないよ！\n次から気を付けてね！");
                            System.out.println("-----------------------------------------------------------------------------------");
                        }
                    }
                }
            }

            

            


            //数当てゲームの処理
            else if (number == 2) {
                System.out.println("-----------------------------------------------------------------------------------");
                //数当てゲームをすることを表示
                System.out.println("数当てゲームを始めるよ！");
                //数当てゲームを行うメソッドを呼び出す
                NA.number_guess();      
            }
            
            //ドラゴン討伐の処理
            else if (number == 3) {
                //難易度を決める変数
                int level;
                System.out.println("-----------------------------------------------------------------------------------");
                //ドラゴン討伐をすることを表示
                System.out.println("ドラゴン討伐！");
                //難易度を表示
                System.out.println("easy:1　normal:2　hard:3　extreme:4");
                while (true) {
                    //例外処理で整数値以外が入らないようにする
                    try {
                        System.out.print("難易度を選んでね！：");
                        level = stdIn.nextInt();
                        //もし入力された値が1,2,3,4であればループを抜け出してそれぞれの難易度のドラゴンと戦う
                        if (level == 1 || level == 2 || level == 3 || level == 4) {
                            break;
                        }
                        //それ以外の場合指定してる整数値を入力されるまでループする
                        else {
                            System.out.println("指定してる整数じゃないよ！");
                        }
                    }
                    //もし文字が入力された場合
                    catch (Exception e) {
                        //指定された整数値を入力してもらう文を表示
                        System.out.println("半角の整数値で入力してね！");
                        stdIn.nextLine();
                    }
                }
                
                //levelが1の時（難易度イージー）
                if (level == 1) {
                    //Battleクラスをインスタンス化する
                    Battle BT = new Battle(50, 3, 30, 1);
                    //難易度別のドラゴンと戦うことを表示
                    System.out.println("イージードラゴンが現れた！");
                    //ドラゴンか入力者のどちらかのHPがなくなるまでループする
                    while (true) {
                        //入力者の行動メソッド
                        BT.HeroActionStep();
                        //もしドラゴンのHPが0以下の場合は即座にループを抜け出してゲームを終了する
                        if (BT.getDragonHP() <= 0) {
                            System.out.println("イージードラゴンの死亡を確認！");
                            break;
                        }
                        //ドラゴンの行動メソッド
                        BT.DragonActionStep();
                        //もし入力者のHPが0以下の場合は即座にループを抜け出してゲームを終了する
                        if (BT.getHeroHP() <= 0) {
                            System.out.println("勇者の死亡を確認！");
                            break;
                        }
                        
                    }
                }

                //levelが2の時（難易度ノーマル）
                else if (level == 2) {
                    //Battleクラスをインスタンス化する
                    Battle BT = new Battle(40, 4, 50, 3);
                    //難易度別のドラゴンと戦うことを表示
                    System.out.println("；ノーマルドラゴンが現れた！");
                    //ドラゴンか入力者のどちらかのHPがなくなるまでループする
                    while (true) {
                        //入力者の行動メソッド
                        BT.HeroActionStep();
                        //もしドラゴンのHPが0以下の場合は即座にループを抜け出してゲームを終了する
                        if (BT.getDragonHP() <= 0) {
                            System.out.println("ノーマルドラゴンの死亡を確認！");
                            break;
                        }
                        //ドラゴンの行動メソッド
                        BT.DragonActionStep();
                        //もし入力者のHPが0以下の場合は即座にループを抜け出してゲームを終了する
                        if (BT.getHeroHP() <= 0) {
                            System.out.println("勇者の死亡を確認！");
                            break;
                        }
                        
                    }
                }

                //levelが3の時（難易度ハード）
                else if (level == 3) {
                    //Battleクラスをインスタンス化する
                    Battle BT = new Battle(30, 4, 65, 4);
                    //難易度別のドラゴンと戦うことを表示
                    System.out.println("ハードドラゴンが現れた！");
                    //ドラゴンか入力者のどちらかのHPがなくなるまでループする
                    while (true) {
                        //入力者の行動メソッド
                        BT.HeroActionStep();
                        //もしドラゴンのHPが0以下の場合は即座にループを抜け出してゲームを終了する
                        if (BT.getDragonHP() <= 0) {
                            System.out.println("ハードドラゴンの死亡を確認！");
                            break;
                        }
                        //ドラゴンの行動メソッド
                        BT.DragonActionStep();
                        //もし入力者のHPが0以下の場合は即座にループを抜け出してゲームを終了する
                        if (BT.getHeroHP() <= 0) {
                            System.out.println("勇者の死亡を確認！");
                            break;
                        }
                        
                    }
                }

                //levelが4の時（難易度エクストリーム）
                else if (level == 4) {
                    //Battleクラスをインスタンス化する
                    Battle BT = new Battle(20, 5, 100, 5);
                    //難易度別のドラゴンと戦うことを表示
                    System.out.println("エクストリームドラゴンが現れた！");
                    //ドラゴンか入力者のどちらかのHPがなくなるまでループする
                    while (true) {
                        //入力者の行動メソッド
                        BT.HeroActionStep();
                        //もしドラゴンのHPが0以下の場合は即座にループを抜け出してゲームを終了する
                        if (BT.getDragonHP() <= 0) {
                            System.out.println("エクストリームドラゴンの死亡を確認！");
                            break;
                        }
                        //ドラゴンの行動メソッド
                        BT.DragonActionStep();
                        //もし入力者のHPが0以下の場合は即座にループを抜け出してゲームを終了する
                        if (BT.getHeroHP() <= 0) {
                            System.out.println("勇者の死亡を確認！");
                            break;
                        }
                        
                    }
                }
            }
            //入力された数値が100ならループを抜け出してメインの処理を終了する
            else if (number == 100) {
                break;
            }  

            //指定された数値以外の整数だった場合の処理
            else if (number >= 0 && number < 100) {
                //指定された整数値を入力してもらうように表示
                System.out.println("「指定された」数字を入力してね？");

            }
        }
    }
}