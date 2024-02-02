import java.util.Random;

public class RockPaperScissors implements RockPaperScissorsInterface {

    int randomValue = 0;
    @Override
    public void rock(int num) {
        if (num == 1) {
            System.out.println("僕はグーを出したよ！");
            System.out.println("あいこ！");
        }
        else if (num == 2) {
            System.out.println("僕はグーを出したよ！");
            System.out.println("貴方の勝ち！");
        }
        else if (num == 3) {
            System.out.println("僕はグーを出したよ！");
            System.out.println("貴方の負け！");
        }
    }
    @Override
    public void paper(int num) {
        if (num == 1) {
            System.out.println("僕はパーを出したよ！");
            System.out.println("貴方の負け！");
        }
        else if (num == 2) {
            System.out.println("僕はパーを出したよ！");
            System.out.println("あいこ！");
        }
        else if (num == 3) {
            System.out.println("僕はパーを出したよ！");
            System.out.println("貴方の勝ち！");
        }
    }
    @Override
    public void scissors(int num) {
        if (num == 1) {
            System.out.println("僕はチョキを出したよ！");
            System.out.println("貴方の勝ち！");
        }
        else if (num == 2) {
            System.out.println("僕はチョキを出したよ！");
            System.out.println("貴方の負け！");
        }
        else if (num == 3) {
            System.out.println("僕はチョキを出したよ！");
            System.out.println("あいこ！");
        }
    }
    
    
    //コンストラクタ
    public RockPaperScissors() {    
    }

    
    Random random = new Random();

    String jyankentehuda[] = {"グー", "パー", "チョキ"};
    

    //入力者が何を出したか（1，2，3で区別している）を引数として受け取る
    public void jyankenresult(int num) {
        
        //ランダムに生成される０～２までの数字を入れる変数
        int randomValue = random.nextInt(3);

        if (num == 1 || num == 2 || num == 3) {
            if (randomValue == 0) {
                rock(num);
            }
            
            else if (randomValue == 1) {
                paper(num);
                
            }
            else if (randomValue == 2) {
                scissors(num);
            }
        }
        else {
            System.out.println("まともに数字も選択できない猿め");
        }
    }
}
