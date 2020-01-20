package project1;
import java.io.Serializable;
import java.util.*;

public class Table implements Serializable{
    private Hashtable<String, Row> rows = new Hashtable<String, Row>();
    private String name;
    private Vector<String> heading = new Vector<String>();
    private Vector <String> primKeyHeadings = new Vector<String>();
    private Vector <Integer> primKeyIndexes = new Vector<Integer>();

    public Table() {
    }
    //getters
    public String getName() { return name; }
    public Vector<String> getHeading() { return heading; }
    public Vector<String> getPrimKeyHeading() { return primKeyHeadings; }
    public Hashtable<String, Row> getTableData() {
        return rows;
    }

    //setters
    public void setName(String _name) {
        //Error check
        if(_name.isEmpty()) {
            System.out.println("Error:Table:setName:String passed is empty, failed to set");
            return;
        }
        //changes name of table
        name = _name;
    }

    public Row getRow(String _key){
        return rows.get(_key);
    }

    public Row getRowWith(String _header, String _value){
        int index = -1;
        for(int i = 0; i < heading.size(); i++){
            if(_header.contentEquals(heading.get(i))){
                index = i;
                i = heading.size();
            }
        }
        if(index == -1){
            System.out.println("Error:Table:getRowWith: passed header not in table");
            return  null;
        }
        Set<String> keys = rows.keySet();
        for(String k : keys) {
            if(rows.get(k).getDataAtIndex(index).equals(_value))
                return rows.get(k);
        }
        return null;
    }

    public void setHeading(Vector<String> _heading) {
        if(_heading.isEmpty()) {
            System.out.println("Error:Table:setHeading:vector passed is empty, failed to set");
            return;
        }
        //Changes heading of table
        if(!heading.isEmpty() && (heading.size() != _heading.size())) {
            System.out.println("Error:Table:setHeading: incompatible heading sizes, heading not set");
            return;
        }
        if(!rows.isEmpty() && (rows.get(rows.keySet().iterator().next()).getData().size() != _heading.size())) {
            System.out.println("Error:Table:setHeading: new heading size does not match table width, heading not set");
            return;
        }
        heading = _heading;
    }

    //Used to reset the hash table after combining rows or doing other functions that might upset the hash function
    public void resetPrimKey(){
        //Gets headings and resets them
        if(!validTable()){
            System.out.println("Error:Table:resetPrimKey: table is invalid, primary keys not reset");
            return;
        }
        Vector<String> tempPrimKeyHeading = new Vector<String>();
        for(int i : primKeyIndexes){
            tempPrimKeyHeading.add(heading.elementAt(i));
        }
        setPrimKey(tempPrimKeyHeading);
    }

    //Takes passed vector and sets those headings as the primary key columns
    public void setPrimKey(Vector<String> _primKeyHeadings) {
        if(_primKeyHeadings.isEmpty()) {
            System.out.println("Error:Table:setPrimKey:empty vector passed, failed to set");
            return;
        }
        //Changes headings
        primKeyHeadings = _primKeyHeadings;
        Vector<Integer> tempPrimKeyIndexes = new Vector<Integer>();
        for(String s : primKeyHeadings) {
            for(int i = 0; i < heading.size(); i++) {
                if(s.contentEquals(heading.elementAt(i))) {
                    tempPrimKeyIndexes.add(i);
                    i = heading.size();
                }
            }
        }
        if(tempPrimKeyIndexes.isEmpty()) {
            System.out.println("Error:Table:setPrimKey:no heading matched primKeyHeading, failed to set");
            return;
        }
        primKeyIndexes.clear();
        primKeyIndexes = tempPrimKeyIndexes;
        if(!rows.isEmpty()) {
            Hashtable<String, Row> tempRows = new Hashtable<String, Row>();
            Set<String> keys = rows.keySet();
            for(String k : keys) {
                String key = "";
                for(int i : primKeyIndexes)
                    key = key + rows.get(k).getDataAtIndex(i);
                tempRows.put(key, rows.get(k));
            }
            rows = tempRows;
        }
    }

    //Deletes the row _deleteThis from this table
    public void deleteRow(Row _deleteThis){
        if(!validTable()){
            System.out.println("Error:Table:deleteRow: table invalid, nothing done");
            return;
        }
        Set<String> keys = rows.keySet();
        //Searches for row to delete and then removes it
        for(String k : keys) {
            if(_deleteThis.getData() == rows.get(k).getData()){
                rows.remove(k);
                return;
            }
        }
        System.out.println("Error:Table:deleteRow: Unable to find passed row, no row deleted");
    }

    public void show() { //Print function for table
        if(heading.isEmpty()) {
            System.out.println("Error:Table:show:no data in heading, nothing to show");
            return;
        }
        if(rows.isEmpty()) {
            System.out.println("Error:Table:show:no data in rows, nothing to show");
            return;
        }
        for(String h : heading) {
            System.out.print(h + "  |  ");
        }
        System.out.println("");
        Set<String> keys = rows.keySet();
        for(String k : keys) {
            rows.get(k).show();
            System.out.println("");
        }
        System.out.println("");
    }

    // inserts the rows from the vector _data into the table
    public void insertRow(Vector<Row> _data) {
        if(!validTable()){
            System.out.println("Error:Table:insertRow: table invalid, nothing done");
            return;
        }
        //inserts a row and updates indexes
        if(_data.size() == 0){
            System.out.println("Error:Table:insertRow: data to be inserted is empty, no data inserted");
            return;
        }
        if(!rows.isEmpty() && _data.elementAt(0).getData().size() != rows.get(rows.keySet().iterator().next()).getData().size()){
            System.out.println("Error:Table:insertRow: data to be inserted is a mismatched size to existing data, no data inserted");
            return;
        }
        for(Row r : _data) {
            String key = "";
            for(int i : primKeyIndexes)
                key = key + r.getDataAtIndex(i);
            rows.put(key, r);
        }
    }

    //inserts a row into the table with the data from the vector _data
    public void insert(Vector _data) {
        //Error check
        if(!validTable()){
            System.out.println("Error:Table:insert: table invalid, nothing done");
            return;
        }
        if(_data.size() == 0) {
            System.out.println("Error:Table:insert:data passed is empty, no data added");
            return;
        }
        if(_data.size() != heading.size()) {
            System.out.println("Error:Table:insert:mismatch of data size no data added");
            return;
        }

        //Inserts data into new row
        String key = "";
        Row newRow = new Row(_data);
        for(int i : primKeyIndexes)
            key = key + newRow.getDataAtIndex(i);
        rows.put(key, newRow);
    }

    boolean validTable(){
        if(heading.isEmpty() || primKeyIndexes.isEmpty() || primKeyHeadings.isEmpty())
            return false;
        else
            return true;
    }
}