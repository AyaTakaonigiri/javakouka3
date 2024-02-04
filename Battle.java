import java.util.Random;
import java.util.Scanner;

class Battle {
    /************************************************フィールド************************************************/
    //Heroクラスをインスタンス化する
    private Hero HR = new Hero();
    //Dragonクラスをインスタンス化する
    private Dragon DG = new Dragon();
    //Scannerクラスをインスタンス化する
    private Scanner stdIn = new Scanner(System.in);
    //Randomクラスをインスタンス化する
    private Random random = new Random();

    private int HeroHP; //入力者のHPを表す変数
    private int HeroPower;  //入力者のパワー（攻撃倍率）を表す変数
    private int DragonHP;   //ドラゴンのHPを表す変数
    private int DragonPower;    //ドラゴンのパワー（攻撃倍率）を表す変数
    private int action;     //入力者の行動を決めるのに使う変数
    private int Herodamage; //ドラゴンに与えるダメージを表す変数
    private int Dragondamage;   //入力者に与えるダメージを表す変数
    private int randomValue;    //ドラゴンの行動を決めるのに使う変数
    
    /************************************************コンストラクタ************************************************/
    Battle(int HeroHP, int HeroPower, int DragonHP, int DragonPower) {
        //入力された引数をそれぞれの変数に入れる
        //入力者のHP
        this.HeroHP = HeroHP;
        //入力者のパワー（攻撃倍率）
        this.HeroPower = HeroPower;
        //ドラゴンのHP
        this.DragonHP = DragonHP;
        //ドラゴンのパワー（攻撃倍率）
        this.DragonPower = DragonPower;
        
    }

    
    /************************************************メソッド************************************************/

    //入力者側の行動メソッド
    void HeroActionStep() {
        
        //入力者の行動が終わるまでループする
        //4の観察は入力者のHPとドラゴンのHPを見るだけで行動として処理しない（4でbreakしないのは仕様）
        while (true) {
            //例外処理
            try {
                //行動の選択肢を表示する
                System.out.println("攻撃する:1　回復する:2　何もしない:3　観察する:4");
                //入力を促す
                System.out.print("あなたはどうする？:");
                //actionにそれぞれの行動を表す
                action = stdIn.nextInt();
            }
            //もし半角英数字でない数字を入力された場合
            catch (Exception e) {
                stdIn.nextLine();
                //actionを0として誤入力の場合の処理へ
                action = 0;
            }

            //半角英数字の0もしくは文字列だった場合はここの処理に移動する
            if (action == 0) {
                //行動せずに入力者の行動が終了する
                System.out.println("そんな行動は存在しない！\n半角で入力してる？");
                System.out.println("-----------------------------------------------------------------------------------");
                //breakでループを終了させる（行動の終了）
                break;
            }

            //actionが1の時（行動:攻撃）
            else if (action == 1) {
                //ドラゴンに与えるダメージを計算してHerodamageに入れる
                Herodamage = HR.attack() * HeroPower;
                //ドラゴンに与えるダメージを表示
                System.out.println("ドラゴンに" + Herodamage + "のダメージ");
                //ドラゴンに与えるダメージをドラゴンのHPから引いて、その値をドラゴンのHPとする
                DragonHP = DragonHP - Herodamage;
                //現在のドラゴンのHPを表示する（ダメージを与えた後のHP）
                System.out.println("ドラゴンの体力は残り" + DragonHP);
                System.out.println("-----------------------------------------------------------------------------------");
                //breakでループを終了させる（行動の終了）
                break;
            }

            //actionが2の時（行動:回復）
            else if (action == 2) {
                //回復したことを表示
                System.out.println("貴方はHPを回復した");
                //現在の入力者のHPに回復する値を足して現在のHPとする
                HeroHP = HeroHP + HR.recovery();
                //現在の入力者のHPを表示（回復した後の入力者のHP）
                System.out.println("貴方の現在のHPは"+HeroHP+"だ！");
                System.out.println("-----------------------------------------------------------------------------------");
                //breakでループを終了させる（行動の終了）
                break;
            }

            //actionが3の時（行動:何もしない）
            else if (action == 3) {
                //入力者が何もしない事を表示させるメソッドを呼び出す
                HR.nothing();
                System.out.println("-----------------------------------------------------------------------------------");
                //breakでループを終了させる（行動の終了）
                break;
            }

            //actionが4の時（行動:観察）
            else if (action == 4) {
                //入力者のHPを表示
                System.out.println("勇者の残りのＨＰは"+HeroHP);
                //ドラゴンのHPを表示
                System.out.println("ドラゴンの残りのＨＰは"+DragonHP);
                System.out.println("-----------------------------------------------------------------------------------");
                //観察は行動として処理しないのでbreakは必要ない
            }

            //0~4以外の整数値だった場合(マイナスも含む)
            else {
                //行動が実行されなかったことを表示する
                System.out.println("正しい数字じゃないと勇者は動かない！");
                System.out.println("-----------------------------------------------------------------------------------");
                //breakでループを終了させる（行動の終了）
                break;
            }
        }
    }
    //ドラゴンの行動メソッド
    void DragonActionStep() {
        //ランダムに生成された0~4でドラゴンの行動を決める
        randomValue = random.nextInt(4);
        
        //ランダムに生成された整数が1以下の時（行動:攻撃）
        if (randomValue <= 1) {
            //ドラゴンの行動が攻撃することを表示する
            System.out.println("ドラゴンの攻撃！");
            //入力者に与えるダメージを計算して、Dragondamageに入れる
            Dragondamage = (DG.attack()+1) * DragonPower;
            //入力者に与えるダメージを入力者のHPから引いて、その値を入力者のHPとする
            HeroHP = HeroHP - Dragondamage;
            //現在の入力者のHPを表示する（ダメージを与えた後のHP）
            System.out.println("勇者のＨＰは残り"+HeroHP);
            System.out.println("-----------------------------------------------------------------------------------");
        }
        //ランダムに生成された整数が2の時（行動:回復）
        else if (randomValue == 2) {
            //回復したことを表示
            System.out.println("ドラゴンは回復した");
            //現在のドラゴンのHPに回復する値を足して現在のHPとする
            DragonHP = DragonHP + DG.recovery();
            //現在のドラゴンのHPを表示（回復した後の入力者のHP）
            System.out.println("ドラゴンのＨＰは残り"+DragonHP);
            System.out.println("-----------------------------------------------------------------------------------");
        }
        //ランダムに生成された整数が3の時（行動:何もしない）
        else if (randomValue == 3) {
            //ドラゴンが何もしない事を表示させるメソッドを呼び出す
            DG.nothing();
            System.out.println("-----------------------------------------------------------------------------------");
        }

    }

    
    /************************************************ゲッタ************************************************/
    
    //現在のドラゴンのHPを返すゲッタ
    public int getDragonHP() {
        return DragonHP;
    }
    //現在の入力者のHPを返すゲッタ
    public int getHeroHP() {
        return HeroHP;
    }
}