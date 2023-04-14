package proyecto.almacen.ana.luisa.benitez;

/**
 * This class is each passage for the record log
 * @author Leonardo Jesús Figueroa Valdivia
 */
public class Record_Passage {
    private final int idRecord;
    private final int idRepairer;
    private final int idDevice;
    private final String dateRegist;
    private final String dateRepair;

    public Record_Passage(int idRecord, int idRepairer, int idDevice, String dateRegist, String dateRepair) {
        this.idRecord = idRecord;
        this.idRepairer = idRepairer;
        this.idDevice = idDevice;
        this.dateRegist = dateRegist;
        this.dateRepair = dateRepair;
    }

    /**
     * Method created for compair two dates, made for regist date
     * @param date The date must be an integer with the format "YYYY" for years, "MM" for months, and "DD" for days, must be an Integer
     * @param target The target must be a Character, 'Y' if you want years, 'M' if you want months, and 'D' if you want days
     * @return True if the date of the passage is tha same year, month, or day
     * YYYY-MM-DD
     */
    public boolean checkRegistDate(int date, char target){
        switch(target){
            case 'Y' -> {
                return (Integer.parseInt(dateRegist.substring(0, 4)) == date);
            }
                
            case 'M' -> {
                return (Integer.parseInt(dateRegist.substring(5, 7)) == date);
            }
                
            case 'D' -> {
                return (Integer.parseInt(dateRegist.substring(8)) == date);
            }
        }
        throw new IllegalArgumentException("targeg param is incorrect");
    }
    
    /**
     * Method created for compair two dates, made for repair date
     * @param date The date must be an integer with the format "YYYY" for years, "MM" for months, and "DD" for days, must be an Integer
     * @param target The target must be a Character, 'Y' if you want years, 'M' if you want months, and 'D' if you want days
     * @return True if the date of the passage is tha same year, month, or day
     * YYYY-MM-DD
     */
    public boolean checkRepairDate(int date, char target){
        switch(target){
            case 'Y' -> {
                return (Integer.parseInt(dateRepair.substring(0, 4)) == date);
            }
                
            case 'M' -> {
                return (Integer.parseInt(dateRepair.substring(5, 7)) == date);
            }
                
            case 'D' -> {
                return (Integer.parseInt(dateRepair.substring(8)) == date);
            }
        }
        throw new IllegalArgumentException("targeg param is incorrect");
    }
    
    /**
     * This method is a override of the toString for this class
     * @return A string where appear all the information of the record
     */
    @Override
    public String toString(){
        return "Incident { incident Id: "+idRecord+", repairer Id: "+idRepairer+", device Id: "+idDevice+", registration date: "+dateRegist+", reparation date: "+dateRepair+", status: repaired}";
    }
}
