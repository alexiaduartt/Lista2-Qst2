public class CeilingFanMediumCommand implements Command {
    private CeilingFan fan;
    private int prevSpeed;
    
    public CeilingFanMediumCommand(CeilingFan fan) { 
        this.fan = fan; 
    }
    
    public void execute() { 
        prevSpeed = fan.getSpeed(); // Guarda o estado anterior para o undo
        fan.medium(); 
    }
    
    public void undo() { 
        // Restaura o estado anterior (lógica de undo)
        if (prevSpeed == CeilingFan.HIGH) fan.high();
        else if (prevSpeed == CeilingFan.LOW) fan.low();
        else fan.off();
    }
    
    public String getLogData() { 
        return "FAN_MEDIUM"; 
    } 
}