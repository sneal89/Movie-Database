package project1;
import java.io.Serializable;
import java.util.*;

public class Row implements Serializable{
    private Vector data = new Vector();

    //Creates a new row from the vector _data
    public Row(Vector _data) {
        //error check
        if(_data.isEmpty())
            System.out.println("Error:Row:Row:data passed is empty");

        //Creates row with given data
        data = _data;
    }

    //outputs the data in the rows
    public void show() {
        if(data.isEmpty()) {
            System.out.println("Error:Row:show:data empty, nothing to print");
            return;
        }
        for(Object d : data) {
            System.out.print(d);
            System.out.print("  |  ");
        }
    }

    public Vector getData() {
        //Returns data of row
        if(data.isEmpty()) {
            System.out.println("Error:Row:getData:data empty, nothing to return");
            return null;
        }
        return data;
    }

    public Object getDataAtIndex(int _index) {
        //returns data at given index
        if(data.size() > _index)
            return data.elementAt(_index);
        System.out.println("Error:Row:getDataAtIndex):index out of bounds");
        return null;
    }

    //Sets the data at index _index to be _newData
    public boolean setDataAtIndex(int _index, Object _newData) {
        //Inputs new data at index
        if(data.size() > _index) {
            data.set(_index, _newData);
            return true;
        }
        System.out.println("Error:Row:setDataAtIndex:index out of bounds");
        return false;
    }
}