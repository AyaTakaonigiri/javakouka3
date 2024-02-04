//行動をランダムに決めるためjava.util.Randomをインポートする
import java.util.Random;

//DragonクラスはCharacterインターフェイスを実装する
class Dragon implements Character {
    /************************************************フィールド************************************************/
    //Randomクラスをインスタンス化する
    private Random random = new Random();

    //実装したCharacterのメソッドをオーバライドする

    /************************************************メソッド************************************************/

    //ドラゴンの攻撃のメソッド
    @Override
    public int attack() {
        return random.nextInt(10);
    }

    //ドラゴンの回復のメソッド
    @Override
    public int recovery() {
        return random.nextInt(15);
    }

    //ドラゴンが何もしない事を表示するメソッド
    @Override
    public void nothing() {
        System.out.println("ドラゴンは何もしなかった！");
    }

    
}
