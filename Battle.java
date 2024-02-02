import java.util.Random;
import java.util.Scanner;

class Battle {
    //フィールド
    int HeroHP;
    int HeroPower;
    int DragonHP;
    int DragonPower;
    int action = 0;
    Hero HR = new Hero(HeroHP, HeroPower);
    Dragon DG = new Dragon(DragonHP, DragonPower);
    Scanner stdIn = new Scanner(System.in);

    
    //コンストラクタ
    Battle(int HeroHP, int HeroPower, int DragonHP, int DragonPower) {
        this.HeroHP = HeroHP;
        this.HeroPower = HeroPower;
        this.DragonHP = DragonHP;
        this.DragonPower = DragonPower;
        
    }

    
    //メソッド
    
    void HeroActionStep() {
        
        LABEL: while (true) {
        
            System.out.println("攻撃する：１　回復する：２　何もしない：３　観察する：４");
            System.out.print("あなたはどうする？:");
            

            //勇者の行動
            while (true) {
                try {
                    action = stdIn.nextInt();
                }
                catch (Exception e) {
                    stdIn.nextLine();
                }

                if (action == 0) {
                    System.out.println("そんな行動は存在しない！");
                }

                else if (action == 1) {
                    int Herodamage = HR.attack();
                    System.out.println("ドラゴンに" + Herodamage + "のダメージ");
                    DragonHP = DragonHP - Herodamage;
                    System.out.println("ドラゴンの体力は残り" + DragonHP);
                    System.out.println("-----------------------------------------------------------------------------------");
                    break LABEL;
                }
                else if (action == 2) {
                    System.out.println("貴方はHPを回復した");
                    HeroHP = HeroHP + HR.recovery();
                    System.out.println("貴方の現在のHPは"+HeroHP+"だ！");
                    System.out.println("-----------------------------------------------------------------------------------");
                    break LABEL;
                }
                else if (action == 3) {
                    HR.nothing();
                    System.out.println("-----------------------------------------------------------------------------------");
                    break LABEL;
                }
                else if (action == 4) {
                    System.out.println("勇者の残りのＨＰは"+HeroHP);
                    System.out.println("ドラゴンの残りのＨＰは"+DragonHP);
                    System.out.println("-----------------------------------------------------------------------------------");
                    break LABEL;
                }
            }
        }
    }
    //ドラゴンの行動

    void DragonActionStep() {
        Random random = new Random();
        int randomValue = random.nextInt(3);
        while (true) {
            if (randomValue == 0) {
                System.out.println("ドラゴンの攻撃！");
                int Dragondamage = DG.attack();
                HeroHP = HeroHP - Dragondamage;
                System.out.println("勇者のＨＰは残り"+HeroHP);
                System.out.println("-----------------------------------------------------------------------------------");
                break;
            }
            else if (randomValue == 1) {
                System.out.println("ドラゴンの回復");
                DragonHP = DragonHP + DG.recovery();
                System.out.println("ドラゴンのＨＰは残り"+DragonHP);
                System.out.println("-----------------------------------------------------------------------------------");
                break;
            }
            else if (randomValue == 2) {
                DG.nothing();
                System.out.println("-----------------------------------------------------------------------------------");
                break;
            }

        }

    }



}