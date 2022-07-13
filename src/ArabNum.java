public class ArabNum {
    private final String [] numbers = new String [11];

    public ArabNum(){
        this.fill();
    }

    private void fill(){
        for (int i = 0; i< this.numbers.length; i++) this.numbers[i] = Integer.toString(i);
    }
    public boolean isArab(String find){
        for(int i = 1; i < numbers.length; i++)
            if(numbers[i].equals(find)) return true;
        return false;
    }
/*
    public int getInt(String find){
        int retVal = 0;
        for(int i = 1; i < this.numbers.length; i++)
            if (numbers[i].equals(find)) retVal = i;
        return retVal;
    }
*/
}


