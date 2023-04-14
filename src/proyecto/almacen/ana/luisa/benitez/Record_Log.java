package proyecto.almacen.ana.luisa.benitez;

import java.util.ArrayList;

/**
 * This class is made to keep a record of the fixes made by the repairers from I.E.S. Ana Luisa Benítez
 * @author Loenardo Jesús Figueroa Valdivia
 */
public class Record_Log {
    @SuppressWarnings("FieldMayBeFinal")
    private static ArrayList<Record_Passage> records= new ArrayList<>();
    
    /**
     * This method show all the reccords in the system
     * @return An arrayList with every record object
     */
    public static ArrayList<Record_Passage> showRecords(){
        return records;
    }
    
    /**
     * This method show the records which match wit the regist date
     * @param dateRegist Must be an Integer with the format "YYYY" for years, "MM" for months, and "DD" for days
     * @param target This referes the filter, use 'Y' for years, 'M' for months, and 'D' for days
     * @return An arrayList which every object that match with the date
     */
    public static ArrayList<Record_Passage> showRecords(int dateRegist, char target){
        ArrayList<Record_Passage> recordsFragment= new ArrayList<>();
        for (Record_Passage r : records) {
            if(r.checkRegistDate(dateRegist, target)){
                recordsFragment.add(r);
            }
        }
        return recordsFragment;
    }
    
    /**
     * This method show the records which match wit the repair date
     * @param dateRepair Must be an Integer with the format "YYYY" for years, "MM" for months, and "DD" for days
     * @param target This referes the filter, use 'Y' for years, 'M' for months, and 'D' for days
     * @return An arrayList which every object that match with the date
     */
    public static ArrayList<Record_Passage> checkRepairDate(int dateRepair, char target){
        ArrayList<Record_Passage> recordsFragment= new ArrayList<>();
        for (Record_Passage r : records) {
            if(r.checkRepairDate(dateRepair, target)){
                recordsFragment.add(r);
            }
        }
        return recordsFragment;
    }
    
    /**
     * This method create a new passage in the log
     * @param idRecord Is the id of the incident
     * @param idRepairer Is the id of the repairer who repair de incident
     * @param idDevice Is the id of the device where ocur the incident
     * @param dateRegist Is the date when the incident was registed, must be in "YYYY-MM-DD" format
     * @param dateRepair Is the date when the incident was repaired, mus be in "YYYY-MM-DD" format
     */
    public static void createPassage(int idRecord, int idRepairer, int idDevice, String dateRegist, String dateRepair){
        String dateFormat = "\\d{4}-\\d{2}-\\d{2}";
        if (!dateRegist.matches(dateFormat) || !dateRepair.matches(dateFormat)) {
            throw new IllegalArgumentException("The date must be in \"YYYY-MM-DD\" format");
        }
        
        Record_Passage newPassage= new Record_Passage(idRecord, idRepairer, idDevice, dateRegist, dateRepair);
        records.add(newPassage);
    }
}