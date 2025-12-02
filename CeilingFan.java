public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    private int speed = OFF;
    
    public void high() { 
        speed = HIGH; 
        System.out.println("Fan speed set to HIGH"); 
    }
    
    public void medium() { 
        speed = MEDIUM; 
        System.out.println("Fan speed set to MEDIUM"); 
    }
    
    public void low() { 
        speed = LOW; 
        System.out.println("Fan set to LOW"); 
    }
    
    public void off() { 
        speed = OFF; 
        System.out.println("Fan set to OFF"); 
    }
    
    public int getSpeed() { 
        return speed; 
    }
}