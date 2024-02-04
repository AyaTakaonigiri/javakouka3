//インターフェイスでDragonクラスとHeroクラスに共通するメソッドを作る
public interface Character {
    //攻撃する時のメソッド
    abstract int attack();
    //HPを回復する時のメソッド
    abstract int recovery();
    //何も行動をしない時のメソッド
    abstract void nothing();
}
