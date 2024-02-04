//ランダムな数字を扱うためjava.util.Randomをインポートする
import java.util.Random;

//HeroクラスはCharacterインターフェイスを実装する
class Hero implements Character {
    /************************************************フィールド************************************************/
    //Randomクラスをインスタンス化する
    private Random random = new Random();

    //実装したCharacterのメソッドをオーバライドする

    /************************************************メソッド************************************************/

    //入力者の攻撃のメソッド
    @Override
    public int attack() {
        return random.nextInt(10);
    }

    //入力者の回復のメソッド
    @Override
    public int recovery() {
        return random.nextInt(20);
    }

    //入力者が何もしなかったことを表示するメソッド
    @Override
    public void nothing() {
        System.out.println("勇者は何もしなかった！");
    }    
}
