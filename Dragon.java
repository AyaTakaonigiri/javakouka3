import java.util.Random;
class Dragon extends character {
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
        return random.nextInt(5);
    }

    @Override
    public void nothing() {
        System.out.println("ドラゴンは何もしなかった！");
    }

    //コンストラクタ
    public Dragon(int hp, int power) {
        this.hp = hp;
        this.power = power;
    }

    public int getPower() {
        return power;
    }
    public int getHp() {
        return hp;
    }

    
}
