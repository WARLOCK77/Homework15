package ua.levelup.Homework15;

public class IntegerGenerator extends AbstractGenerator<Integer>{

    @Override
    public Integer getNextRand() {
        return random.nextInt(100);
    }


    @Override
    public Class<Integer> getType() {
        return Integer.class;
    }


}
