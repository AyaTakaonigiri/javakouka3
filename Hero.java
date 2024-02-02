import java.util.Random;

class Hero extends character {
    //フィールド
    int hp;
    int power;
    Random random = new Random();
    @Override
    public int attack() {
        return random.nextInt(10);
    }
    @Override
    public int recovery() {
        return random.nextInt(10);
    }
    @Override
    public void nothing() {
        System.out.println("勇者は何もしなかった！");
    }

    public int getPower() {
        return power;
    }
    public int getHp() {
        return hp;
    }

    //コンストラクタ
    public Hero(int hp, int power) {
        this.hp = hp;
        this.power = power;
    }

    //メソッド
    
    
}
