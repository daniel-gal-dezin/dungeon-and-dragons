package Project;

public abstract class Unit extends Tile {

    private String name;
    private Health health;
    private int attack;
    private int defense;

    protected Unit(char tile, String name, int healthCapacity, int attack, int defense) {
        super(tile);
        this.name = name;
        this.health = new Health(healthCapacity);
        this.attack = attack;
        this.defense = defense;
    }

    protected void initialize(Position position){
        this.setPosition(position);
    }

    protected int attack(){

        return (int)Math.floor(this.attack * Math.random());
    }

    public int defend(){
        return (int)Math.floor(this.defense * Math.random());
    }



    // What happens when the unit dies
    public abstract void onDeath();

    // This unit attempts to interact with another tile.
    public void interact(Tile tile){
        tile.accept(this);
    }

    public  abstract  void accept(Unit u);

    public void visit(Empty e){
        Position temp = this.getPosition();
        this.setPosition(e.getPosition());
        e.setPosition(temp);
    }
    public void visit(Wall w){
        return;
        //nothing change
    }

    public abstract void visit(Player p);
    public abstract void visit(Enemy e);





    public boolean isDead(){
        return this.getHealth().getCurrentHealth() <= 0;
    }

    // Combat against another unit.
    protected void getAttacked(int attackDamage){
        int defense = this.defend();
        MassageCallback.send("Attack roll - " + attackDamage + " Defense roll - " + defense);
        if(attackDamage > defense) {
            health.getDamaged(attackDamage - defense);
            MassageCallback.send(attackDamage - defense + " damage was taken");
        }
        if(health.isDead())
            this.onDeath();
    }




    public String describe() {
        return String.format("%s\t\tProject.Health: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth().getCurrentHealth(), getAttack(), getDefense());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Health getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
