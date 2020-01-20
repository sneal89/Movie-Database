package project1;

import csce315.project1.*;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Vector;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;

import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
* =====================================================================================================================================================================================================
* Note - make sure to add the MovieDatabaseParser.jar to your "Project Structure" or there will probably be errors
* Changes since last upload->
*       added functions-> Dbms:loadImdb(), Dbms:typecasting(), Dbms:createUnsafe(), Dbms:mode(), Dbms:bodWod(), Dbms:coverRoles(), Table:getRowWith()
*       modified functions-> create() <minor update>, I don't think I changed any more but I'm not 100%
* =====================================================================================================================================================================================================
*/

public class Dbms {
    private Vector<Table> tables = new Vector<Table>();
    private Stack<Table> tableStack = new Stack<Table>();
    private int movieIndex; private int crewIndex; private int castIndex; private int endImdb;

    public Dbms() {
        loadImdb();
        //System.out.println("typecasting(Tom Hanks): " + typecasting("Tom Hanks"));
        //System.out.println("bodWod(Tom Hanks):      " + bodWod("Tom Hanks"));
        //System.out.println("coverRoles(Hellboy):    " + coverRoles("Hellboy"));
        //Application.launch();
    }


    //Loads data from imdb database into tables
    public void loadImdb() {
        Boolean displayLoad = false;    //Set true to display loading info

        if(displayLoad)
            System.out.println("Loading data from imdb");
        MovieDatabaseParser parser = new MovieDatabaseParser();
        List<Movie> moviesList = null;
        List<Credits> creditsList = null;
        try{
            moviesList = parser.deserializeMovies("src/project1/json/movies.json");
            creditsList = parser.deserializeCredits("src/project1/json/credits.json");
        } catch(Exception e) {
            System.out.println("Unable to load moviesList and creditsList");
            exit();
        }

        //Movie table
        movieIndex = tables.size();
        Vector movieHeading = new Vector();
        movieHeading.add("title"); movieHeading.add("id"); movieHeading.add("adult"); movieHeading.add("belongsToCollection"); movieHeading.add("budget"); movieHeading.add("genres"); movieHeading.add("homepage"); movieHeading.add("imdbId"); movieHeading.add("originalLanguage");  //indexes 0-8
        movieHeading.add("originalTitle"); movieHeading.add("overview"); movieHeading.add("popularity"); movieHeading.add("posterPath"); movieHeading.add("productionCompany"); movieHeading.add("productionCountries"); movieHeading.add("releaseDate"); movieHeading.add("revenue");  //indexes 9-16
        movieHeading.add("runtime"); movieHeading.add("spokenLanguage"); movieHeading.add("status"); movieHeading.add("tagline"); movieHeading.add("video"); movieHeading.add("voteAverage"); movieHeading.add("voteCount"); movieHeading.add("hasCredits");                            //indexes 17-24
        Vector moviePrimKeys = new Vector();
        moviePrimKeys.add("title"); moviePrimKeys.add("id");
        createUnsafe("Movies", movieHeading, moviePrimKeys);
        if(displayLoad)
            System.out.print("Loading movies:       ");
        for(int i = 0; i < moviesList.size(); i++) {
            Movie m = moviesList.get(i);
            Vector insertData = new Vector();
            insertData.add(m.getTitle()); insertData.add(m.getId()); insertData.add(m.getAdult()); insertData.add(m.getBelongs_to_collection()); insertData.add(m.getBudget()); insertData.add(m.getGenres()); insertData.add(m.getHomepage()); insertData.add(m.getImdb_id()); insertData.add(m.getOriginal_language());
            insertData.add(m.getOriginal_title()); insertData.add(m.getOverview()); insertData.add(m.getPopularity()); insertData.add(m.getPoster_path()); insertData.add(m.getProduction_companies()); insertData.add(m.getProduction_countries()); insertData.add(m.getRelease_date()); insertData.add(m.getRevenue());
            insertData.add(m.getRuntime()); insertData.add(m.getSpoken_languages()); insertData.add(m.getStatus()); insertData.add(m.getTagline()); insertData.add(m.getVideo()); insertData.add(m.getVote_average()); insertData.add(m.getVote_count()); insertData.add(m.getHasCredits());
            tables.lastElement().insert(insertData);
            if(displayLoad && i > 10 && i % (moviesList.size() / 4) == 0) System.out.print((i / (moviesList.size() / 100)) + "% ");
        }
        if(displayLoad) {
            System.out.print("100% - Movies loaded");
            System.out.println();
        }

        //Crew member tables
        crewIndex = tables.size();
        Vector crewHeading = new Vector();
        crewHeading.add("name"); crewHeading.add("id");crewHeading.add("gender");crewHeading.add("department");crewHeading.add("job");crewHeading.add("creditId");crewHeading.add("profilePath");
        Vector crewPrimKeys = new Vector();
        crewPrimKeys.add("name"); crewPrimKeys.add("id"); crewPrimKeys.add("job");
        if(displayLoad)
            System.out.print("Loading crew members: ");
        for(int i = 0; i < creditsList.size(); i++){
            createUnsafe("crew" + moviesList.get(i).getTitle() + moviesList.get(i).getId(), crewHeading, crewPrimKeys);
            for(int j = 0; j < creditsList.get(i).getCrewMember().size(); j++){
                Vector insertData = new Vector();
                Credits.CrewMember c = creditsList.get(i).getCrewMember().get(j);
                insertData.add(c.getName()); insertData.add(c.getId());insertData.add(c.getGender());insertData.add(c.getDepartment());insertData.add(c.getJob());insertData.add(c.getCredit_id());insertData.add(c.getProfile_path());
                tables.lastElement().insert(insertData);
            }
            if(displayLoad && i > 10 && i % (creditsList.size() / 4) == 0) System.out.print((i / (creditsList.size() / 100)) + "% ");
        }
        if(displayLoad) {
            System.out.print("100% - Crew members loaded");
            System.out.println();
        }

        //Cast member tables
        castIndex = tables.size();
        Vector castHeading = new Vector();
        castHeading.add("name"); castHeading.add("id");castHeading.add("gender");castHeading.add("character");castHeading.add("order");castHeading.add("creditId");castHeading.add("castId");castHeading.add("profilePath");
        Vector castPrimKeys = new Vector();
        castPrimKeys.add("name"); castPrimKeys.add("id"); crewPrimKeys.add("character");
        if(displayLoad)
            System.out.print("Loading cast members: ");
        for(int i = 0; i < creditsList.size(); i++){
            createUnsafe("cast" + moviesList.get(i).getTitle() + moviesList.get(i).getId(), castHeading, castPrimKeys);
            for(int j = 0; j < creditsList.get(i).getCastMember().size(); j++){
                Vector insertData = new Vector();
                Credits.CastMember c = creditsList.get(i).getCastMember().get(j);
                insertData.add(c.getName()); insertData.add(c.getId());insertData.add(c.getGender());insertData.add(c.getCharacter());insertData.add(c.getOrder());insertData.add(c.getCredit_id());insertData.add(c.getCast_id());insertData.add(c.getProfile_path());
                tables.lastElement().insert(insertData);
            }
            if(displayLoad && i > 10 && i % (creditsList.size() / 4) == 0) System.out.print((i / (creditsList.size() / 100)) + "% ");
        }
        endImdb = tables.size();
        if(displayLoad) {
            System.out.print("100% - Cast members loaded");
            System.out.println();
            System.out.println("Finished loading data from imdb");
            System.out.println("");
        }
    }

    //Typecasting query
    public String typecasting(String _name){
        Vector<String> actorAppearances = new Vector<String>();
        for(int i = castIndex; i < endImdb; i++){
            if(tables.get(i).getRowWith("name", _name) != null)
                actorAppearances.add(tables.get(i).getName().substring(4));
        }
        Vector genres = new Vector();
        for(String s : actorAppearances){
            for(Movie.Genre g : (List<Movie.Genre>)tables.get(movieIndex).getRow(s).getDataAtIndex(5)){
                genres.add(g.getName());
            }
        }
        return mode(genres);
    }

    //Best of Days, Worst of Days query
    public String bodWod(String _name){
        //get list of movies the actor has appeared in
        Vector<String> actorAppearances = new Vector<String>();
        for(int i = castIndex; i < endImdb; i++){
            if(tables.get(i).getRowWith("name", _name) != null)
                actorAppearances.add(tables.get(i).getName().substring(4));
        }
        //get director of the best ranked movie for the actor
        Vector genres = new Vector();
        String bestRanked = "";
        Double bestRankedRanking = -1.0;
        for(String s : actorAppearances) {
            if((Double)tables.get(movieIndex).getRow(s).getDataAtIndex(22) > bestRankedRanking && getTable("crew" + s).getRowWith("job", "Director") != null) {
                bestRanked = s;
                bestRankedRanking = (Double)tables.get(movieIndex).getRow(s).getDataAtIndex(22);
            }
        }
        String director = (String) getTable("crew" + bestRanked).getRowWith("job", "Director").getDataAtIndex(0);
        if(director == null){
            System.out.println("Error:Dbms:bodWod: no director listed for movie, returning null");
            return null;
        }
        //get list of movies director has directed
        Vector<String> directorAppearances = new Vector<String>();
        for(int i = crewIndex; i < castIndex; i++){
            if(tables.get(i).getRowWith("name", director) != null && tables.get(i).getRowWith("name", director).getDataAtIndex(4).equals("Director"))
                directorAppearances.add(tables.get(i).getName().substring(4));
        }
        //find worst movie director has directed
        String worstRanked = "";
        Double worstRankedRanking = 101.0;
        for(String s : directorAppearances){
            if((Double)tables.get(movieIndex).getRow(s).getDataAtIndex(22) < worstRankedRanking) {
                worstRanked = (String)tables.get(movieIndex).getRow(s).getDataAtIndex(0);
                worstRankedRanking = (Double)tables.get(movieIndex).getRow(s).getDataAtIndex(22);
            }
        }
        return worstRanked;
    }

    //Cover Roles query
    public Vector<String> coverRoles(String _cName){
        Vector<String> actors = new Vector<String>();
        for(int i = castIndex; i < endImdb; i++) {
            if (tables.get(i).getRowWith("character", _cName) != null)
                actors.add((String) tables.get(i).getRowWith("character", _cName).getDataAtIndex(0));
        }
        Set<String> tempSet = new HashSet<String>();
        tempSet.addAll(actors);
        actors.clear();
        actors.addAll(tempSet);
        return actors;
    }

    //Constellation of costars
    public Vector<String> conOfCoStars(String _name, int _appear) {
        //Get list of movies named actor is in
        Vector<String> actorAppearances = new Vector<String>();
        for(int i = castIndex; i < endImdb; i++){
            if(tables.get(i).getRowWith("name", _name) != null)
                actorAppearances.add(tables.get(i).getName().substring(4));
        }
        Vector<String> costars = new Vector<String>();
        Vector<Integer> costarAppearances = new Vector<Integer>();
        Table temp;
        for(String s : actorAppearances) {  //iterate through every movie
            temp = getTable("cast" + s);    //set temp to current movie cast table
            Hashtable ht = temp.getTableData();
            Set<String> keys = ht.keySet();
            for(String k : keys) {  //go through all the rows of cast
                if(costars.contains(temp.getRow(k).getDataAtIndex(0))) {
                    for(int i = 0; i < costars.size(); i++){
                        if(costars.elementAt(i).equals(temp.getRow(k).getDataAtIndex(0))) {
                            costarAppearances.set(i, costarAppearances.elementAt(i) + 1);
                            i = costars.size();
                        }
                    }
                }
                else {
                    costars.add((String) temp.getRow(k).getDataAtIndex(0));
                    costarAppearances.add(1);
                }
            }
        }
        if(costars.size() != costarAppearances.size()){
            System.out.println("Error:Dbms:conOfCoStars: Something has gone very wrong");
            return null;
        }
        Vector<String> toReturn = new Vector<String>();
        for(int i = 0; i < costars.size(); i++){
            if(costarAppearances.elementAt(i).equals(_appear))
                toReturn.add(costars.elementAt(i));
        }
        toReturn.remove(_name);
        return toReturn;
    }

    //Commands (open, close, write, exit, show, create, update, insert, delete)

    //Opens file named _fileName and creates a table from the information stored in the file
    public void open(String _fileName) {
        //Error check in case file name is empty
        if(_fileName.isEmpty()) {
            System.out.println("Error:Dbms:open:file name passed is blank, no file opened");
            return;
        }
        try {
            //Get table from file
            FileInputStream fis = new FileInputStream(new File("./" +_fileName+".db"));
            ObjectInputStream objIn = new ObjectInputStream(fis);
            Table tempTable = (Table)objIn.readObject();//(Table)decoder.readObject();

            objIn.close();
            fis.close();
            tempTable.setName(_fileName);
            tables.add(tempTable);
        }
        catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    //Wrties table to the file named _name and removes the table from the active vector of tables
    public void close(String _name) {
        if(_name.isEmpty()) {
            System.out.println("Error:Dbms:close:name passed is blank, no table removed");
            return;
        }
        //Writes table and then closes it
        if(!tables.contains(getTable(_name))){
            System.out.println("Error:Dbms:close:table " + _name + " not in tables vector, nothing done");
            return;
        }
        write(_name);
        tables.remove(getTableIndex(_name));
    }

    //Writres table to the file named _fileName and checks to make sure relevant information is valid
    public void write(String _name) {
        //Error check to see if table exists
        if(!tables.contains(getTable(_name))) {
            System.out.println("Error:Dbms:write:table " + _name + " not in tables vector, no table to write to file with");
            return;
        }

        String filename = "./" + _name + ".db";
        try {
            //Write table object into file
            FileOutputStream fIn = new FileOutputStream(new File(filename));
            ObjectOutputStream objOut = new ObjectOutputStream(fIn);

            objOut.writeObject(getTable(_name));

            objOut.close();
            fIn.close();
        }
        //Error checks
        catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File Not Found.");
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Error with file stream.");
        }
    }

    //Basic exit function
    public void exit() {
        System.out.println("Goodbye, World!");
        System.exit(0);
    }

    //Outputs table in terminal with " | " between entities
    public void show(String _name) {
        //Error check to see if table exists
        if(!tables.contains(getTable(_name))) {
            System.out.println("Error:Dbms:show:table " + _name + " not in tables vector, no table to show");
            return;
        }
        //Outputs table in terminal
        int i = getTableIndex(_name);
        System.out.println("Table name : " + tables.elementAt(i).getName());
        tables.elementAt(i).show();
    }

    //Creates a new table called _name and sets the column headings from the vector _heading and sets the primary keys to be from _primKeyHeadings
    public void create(String _name, Vector<String> _heading, Vector<String> _primKeyHeadings) {
        //Error check
        if(_name.isEmpty() || _heading.isEmpty() || _primKeyHeadings.isEmpty()) {
            System.out.println("Error:Dbms:create:One or more of the passed arguments is empty, no table created");
            return;
        }
        if(tables.size() > 5000)
            System.out.println("Warning:Dbms:create: tables vector is very large, recommend use of createUnsafe method to increase speed");
        if(tables.contains(getTable(_name))){
            System.out.print("Warning:Dbms:create:Table already exists with the same name, naming new table ");
            int i = 0;
            String tempName = _name;
            while(tables.contains(getTable(tempName))){
                i++;
                tempName = _name;
                tempName = tempName + i;
            }
            _name = tempName;
            System.out.println(_name);
        }

        //Generates new table and adds to table list
        Table newTable = new Table();
        newTable.setName(_name);
        newTable.setHeading(_heading);
        newTable.setPrimKey(_primKeyHeadings);
        tables.add(newTable);
    }

    //Used for importing imdb database, increases efficiency and removes checks
    public void createUnsafe(String _name, Vector<String> _heading, Vector<String> _primKeyHeadings) {
        //Generates new table and adds to table list
        Table newTable = new Table();
        newTable.setName(_name);
        newTable.setHeading(_heading);
        newTable.setPrimKey(_primKeyHeadings);
        tables.add(newTable);
    }

    //Takes the Table _parent table and adjusts the rows in that table from _rowsToAdj(ust) by taking the data in those rows in the column _toChangeHeading and sets the values to the value of Object _o
    public void update(String _toChangeHeading, Object _o, Table _parentTable, Table _rowsToAdj) {
        if(_toChangeHeading.isEmpty() || _o == null || _parentTable == null || _rowsToAdj == null) {
            System.out.println("Error:Dbms:update: one or more arguments passed is null, nothing done");
            return;
        }

        //Gets index of heading to change
        int index = -1;
        for(int i = 0; i < _parentTable.getHeading().size(); i++) {
            if(_toChangeHeading.contentEquals(_parentTable.getHeading().get(i))){
                index = i;
                i = _parentTable.getHeading().size();
            }
        }

        if(index < 0) {
            System.out.println("Error:update: heading passed is not in table");
            return;
        }

        //removes row from parent table
        delete(_parentTable, _rowsToAdj);
        Vector<Row> toAdd = new Vector<Row>();

        //Modifies parent table from given requirements
        Hashtable ht = _rowsToAdj.getTableData();
        Set<String> keys = ht.keySet();
        for(String k : keys) {
            ((Row) ht.get(k)).setDataAtIndex(index, _o);
            toAdd.add((Row) ht.get(k));
        }
        if(toAdd.isEmpty()) {
            System.out.println("Warning:Dbms:update:no rows were able to be updated, you should probably never see this warning, nothing done");
            return;
        }
        _parentTable.insertRow(toAdd);
    }

    //Inserts a row (from _data) into the table named _name
    public void insert(String _name, Vector _data) {
        //Error checks
        if(_name.isEmpty() || _data.isEmpty()) {
            System.out.println("Error:Dbms:insert:One or more of the passed arguments is empty, no rows inserted into table " + _name);
            return;
        }
        if(!tables.contains(getTable(_name))) {
            System.out.println("Error:Dbms:insert:table " + _name + " not in tables vector, no table to insert into");
            return;
        }

        //Inserts element
        tables.elementAt(getTableIndex(_name)).insert(_data);
    }

    //Deletes any rows in the table _deleteFrom that are in the table _deleteThis
    public void delete(Table _deleteFrom, Table _deleteThis) {
        if(_deleteFrom == null || _deleteThis == null){
            System.out.println("Error:Dbms:delete: one or more passed tables is null, nothing done");
            return;
        }
        Hashtable ht = _deleteThis.getTableData();
        Set<String> keys = ht.keySet();
        for(String k : keys) {
            _deleteFrom.deleteRow((Row) ht.get(k));
        }
    }


    //Queries (selection, projection, renaming, union(+), difference(ta-tb), product(* ?)
    /*Select is a very powerful function that handles many other functions. It is a general function used by the visitor to handle any comparison or operation
    * (such as == or ||) and sends them to the appropriate function. Since so many of these functions had similar arguments and all output a new table, this
    * one function was designed to handle them all and make it easier on the visitor. It takes two objects (usually Table and Table, or String and Int),
    * a String (which is the comparator or condition) and a table (which is optional in some functions therefore null can be passed by certain visitor
    * functions). Select simply decides which function the passed data should be sent to which was done to reduce the stress on the listener (since the
    * database was ready much sooner than the listener was). A visitor was eventually due to issues writing the listener and this function was kept since
    * it was already implemented
    */
    public Table select(Object _a, Object _b, String _condition, Table _table) {	//Object can be Vector or Table
        Table newTable = new Table();
        if(_a == null || _b == null || _condition.isEmpty()){
            System.out.println("Error:Dbms:select: _a and or _b and or _condition is/are null, nothing done");
            return null;
        }
        //Switch case for all operations which then calculates based on condition
        switch(_condition) {
            //OP
            case "==":
                newTable = equals((String)_a, (String)_b, _table);
                break;
            case "!=":
                newTable = notEquals((String)_a, (String)_b, _table);
                break;
            case ">":
                newTable = comparator((String)_a, Integer.valueOf((String)_b), _table, _condition);
                break;
            case "<":
                newTable = comparator((String)_a, Integer.valueOf((String)_b), _table, _condition);
                break;
            case ">=":
                newTable = comparator((String)_a, Integer.valueOf((String)_b), _table, _condition);
                break;
            case "<=":
                newTable = comparator((String)_a, Integer.valueOf((String)_b), _table, _condition);
                break;
            //Table combining
            case "||":
                newTable = union((Table) _a, (Table) _b);
                break;
            case "&&":
                newTable = and((Table) _a, (Table) _b);
                break;
            case "+":
                newTable = union((Table) _a, (Table) _b);
                break;
            case "-":
                newTable = difference((Table) _a, (Table) _b);
                break;
            case "*":
                newTable = product((Table) _a, (Table) _b);
                break;
            //misc
            case "=":
                //update((String)_a, (String)_b, _table);
                break;
            default:
                System.out.println("Error:Dbms:Select: incompatible condition: " + _condition);
                return null;
        }
        if(newTable == null)
            System.out.println("Error:Dbms:Select: something is very wrong, you shouldn't see this, newTable is null, returning null");
        return newTable;
    }

    //Returns a table that contains just the columns from _table under the headings _heading
    public Table project(Vector<String> _heading, Table _table) {
        if(_heading.isEmpty() || _table == null) {
            System.out.println("Error:Dbms:project: one or more passed arguments is null, nothing done");
            return null;
        }
        //Gets new heading index
        Vector<Integer> newHeadingIndex = new Vector<Integer>();
        for(String h : _heading) {
            for(int i = 0; i < _table.getHeading().size(); i++) {
                if(h.contentEquals(_table.getHeading().elementAt(i))) {
                    newHeadingIndex.add(i);
                    i = _table.getHeading().size();
                }
            }
        }
        if(newHeadingIndex.isEmpty()){
            System.out.println("Error:Dbms:project: passed heading not in passed table, nothing done");
            return null;
        }

        //Projects values into new table and returns it
        Table newTable = new Table();
        Vector<String> toAddHeading = new Vector<String>();
        for(int i : newHeadingIndex) {
            toAddHeading.add(_table.getHeading().elementAt(i));
        }
        newTable.setHeading(toAddHeading);
        newTable.setPrimKey(toAddHeading);
        Vector<Row> toAddRow = new Vector<Row>();
        Hashtable ht = _table.getTableData();
        Set<String> keys = ht.keySet();
        for(String k : keys) {
            Vector toAdd = new Vector();
            for(int i : newHeadingIndex) {
                toAdd.add(((Row) ht.get(k)).getDataAtIndex(i));
            }
            Row newRow = new Row(toAdd);
            toAddRow.add(newRow);
        }
        newTable.insertRow(toAddRow);
        return newTable;
    }

    //renames the headings from _table into the headings from _heading
    public Table rename(Vector<String> _heading, Table _table) {
        //error check
        if(_heading.isEmpty()) {
            System.out.println("Error:Dbms:rename:arg name is empty, no table saved");
            return null;
        }

        //Renames table
        _table.setHeading(_heading);
        _table.resetPrimKey();
        return _table;
    }

    //Combines the data from table _a and table _b and removes duplicates
    public Table union(Table _a, Table _b) {
        if(_a == null && _b == null){
            System.out.println("Error:Dbms:union: both tables passed are null, nothing done");
            return null;
        }
        if(_a == null){
            System.out.println("Warning:Dbms:union: first table argument is null, returning second table unmodified");
            return _b;
        }
        if(_b == null){
            System.out.println("Warning:Dbms:union: second table argument is null, returning first table unmodified");
            return _a;
        }
        //Gets items to add from both tables
        Vector<Row> toInsert = new Vector<Row>();
        Hashtable tableA = _a.getTableData();
        Set<String> keysa = tableA.keySet();
        for(String k : keysa) {
            toInsert.add((Row) tableA.get(k));
        }
        Hashtable tableB = _b.getTableData();
        Set<String> keys = tableB.keySet();
        for(String k : keys) {
            toInsert.add((Row) tableB.get(k));
        }
        //completes the union
        Table newTable = new Table();
        newTable.setHeading(_a.getHeading());
        newTable.setPrimKey(_a.getPrimKeyHeading());
        newTable.insertRow(toInsert);
        return newTable;
    }

    //Removes the elements from table _a that are in table _b
    public Table difference(Table _a, Table _b) {
        if(_a == null && _b == null){
            System.out.println("Error:Dbms:difference: both tables passed are null, nothing done");
            return null;
        }
        if(_a == null){
            System.out.println("Error:Dbms:difference: first table argument is null, returning null");
            return null;
        }
        if(_b == null){
            System.out.println("Warning:Dbms:difference: second table argument is null, returning first table unmodified");
            return _a;
        }
        //gets duplicates
        Hashtable tableA = _a.getTableData();
        Hashtable tableB = _b.getTableData();
        Set<String> keysA = tableA.keySet();
        Set<String> keysB = tableB.keySet();
        Vector<String> duplicates = new Vector<String>();
        for(String ka : keysA) {
            for(String kb : keysB) {
                if(ka.contentEquals(kb)) {
                    duplicates.add(ka);
                    break;
                }
            }
        }
        if(duplicates.isEmpty()){
            System.out.println("Warning:Dbms:difference: no matching rows in tables passed, returning first table unmodified");
            return _a;
        }

        //Calculates difference
        Table newTable = new Table();
        newTable.setHeading(_a.getHeading());
        newTable.setPrimKey(_a.getPrimKeyHeading());
        Vector<Row> toInsert = new Vector<Row>();
        for(String ka : keysA) {
            if(!duplicates.contains(ka))
                toInsert.add((Row) tableA.get(ka));
        }
        if(toInsert.isEmpty())
            System.out.println("Warning:Dbms:difference: all rows removed from _a, returning empty table");
        newTable.insertRow(toInsert);
        return newTable;
    }

    //Creates a table that is product of table _a and table _b
    public Table product(Table _a, Table _b) {
        if(_a == null || _b == null){
            System.out.println("Error:Dbms:product: one or both tables passed is/are null, returning null");
            return null;
        }
        //Creates variables
        Hashtable tableA = _a.getTableData();
        Hashtable tableB = _b.getTableData();
        Set<String> keysa = tableA.keySet();
        Set<String> keysb = tableB.keySet();
        if(keysa.isEmpty() && keysb.isEmpty()){
            System.out.println("Error:Dbms:product: both tables passed are empty, returning null");
            return null;
        }
        if(keysa.isEmpty()){
            System.out.println("Warning:Dbms:product: first table passed is empty, returning second table unmodified");
            return _b;
        }
        if(keysb.isEmpty()){
            System.out.println("Warning:Dbms:product: second table passed is empty, returning first table unmodified");
            return _a;
        }
        Table newTable = new Table();
        Vector<String> newHeading = new Vector<String>();
        Vector<String> newPrimKeyHeading = new Vector<String>();
        newHeading.addAll(_a.getHeading());
        newHeading.addAll(_b.getHeading());
        newTable.setHeading(newHeading);
        newPrimKeyHeading.addAll(_a.getPrimKeyHeading());
        newPrimKeyHeading.addAll(_b.getPrimKeyHeading());
        newTable.setPrimKey(newPrimKeyHeading);
        Vector<Row> toInsert = new Vector<Row>();

        //Completes product and returns table
        for(String ka : keysa) {
            for (String kb : keysb) {
                toInsert.add(combineRows((Row) tableA.get(ka), (Row) tableB.get(kb)));
            }
        }
        if(toInsert.isEmpty()){
            System.out.println("Error:Dbms:product: something is very wrong, you should NOT see this error, table to be returned is empty, returning null");
            return null;
        }
        newTable.insertRow(toInsert);
        return newTable;
    }

    //Stack control functions below
    public Table popStack(){
        //Error check
        if(tableStack.isEmpty()){
            System.out.println("Error:Dbms:popStack: stack currently empty, unable to return Table");
            return null;
        }
        //pop table off stack
        return tableStack.pop();
    }
    public Table peekStack(){
        if(tableStack.isEmpty()){
            System.out.println("Error:Dbms:peekStack: stack currently empty, unable to return Table");
            return null;
        }
        //returns peek of table stack
        return tableStack.peek();
    }
    public void pushStack(Table _t){
        if(_t == null){
            System.out.println("Error:Dbms:pushStack: Table passed is null, no table added");
            return;
        }
        if(_t.getTableData().isEmpty())
            System.out.println("Warning:Dbms:pushStack: Table passed is empty, table added");
        //Pushes table onto stack
        tableStack.push(_t);
    }
    public void clearStack(){
        //Empties stack, removed safe check because it is only called before parsing a new line of input so the stack SHOULD already be empty
        //if(tableStack.isEmpty()){
        //    System.out.println("Warning:Dbms:clearStack:stack already empty, nothing done");
        //}
        if(!tableStack.isEmpty())
            tableStack.empty();
    }

    //Misc
    //Best used for tables created after calling product(), checks to see if the values under heading _s1 and _s2 are equal and returns the rows where this is true as a table (used for common_names in the sample input)
    private Table equals(String _s1, String _s2, Table _t) {
        if(_s1.isEmpty() || _s2.isEmpty() || _t == null){
            System.out.println("Error:Dbms:equals: one or more of the passed arguments is/are null, returning null");
            return null;
        }
        //compares if headings are equal, calculates comparison and returns table
        if(_t.getHeading().contains(_s1) && _t.getHeading().contains(_s2)) {
            Vector<Integer> compareHeaders = new Vector<Integer>();
            for(int i = 0; i < _t.getHeading().size(); i++) {
                if(_t.getHeading().elementAt(i).contentEquals(_s1))
                    compareHeaders.add(i);
                else if(_t.getHeading().elementAt(i).contentEquals(_s2))
                    compareHeaders.add(i);
            }
            if(compareHeaders.size() != 2){
                System.out.println("Error:Dbms:equals: expected two headers, got " + compareHeaders.size() + ", returning null");
                return null;
            }
            Hashtable hs = _t.getTableData();
            Set<String> keys = hs.keySet();
            Vector<Row> toAdd = new Vector<Row>();
            String h1, h2;
            for(String k : keys) {
                h1 = (String)((Row) hs.get(k)).getDataAtIndex(compareHeaders.firstElement());
                h2 = (String)((Row) hs.get(k)).getDataAtIndex(compareHeaders.lastElement());
                if(h1.contentEquals(h2))
                    toAdd.add((Row) hs.get(k));
            }
            Table newTable = new Table();
            newTable.setHeading(_t.getHeading());
            newTable.setPrimKey(_t.getPrimKeyHeading());
            newTable.insertRow(toAdd);
            return newTable;
        }
        else {
            int index = -1;
            for(int i = 0; i < _t.getHeading().size(); i++) {
                if(_t.getHeading().elementAt(i).contentEquals(_s1)) {
                    index = i;
                    i = _t.getHeading().size();
                }
            }
            if(index < 0){
                System.out.println("Error:Dbms:equals: no heading matching " + _s1 + " found, returning null");
                return null;
            }
            Hashtable hs = _t.getTableData();
            Set<String> keys = hs.keySet();
            Vector<Row> toAdd = new Vector<Row>();
            for(String k : keys) {
                if(((Row) hs.get(k)).getDataAtIndex(index).equals(_s2))
                    toAdd.add((Row) hs.get(k));
            }
            if(toAdd.isEmpty())
                System.out.println("Warning:Dbms:equals: table to be returned is empty, still gonna send it");
            Table newTable = new Table();
            newTable.setHeading(_t.getHeading());
            newTable.setPrimKey(_t.getPrimKeyHeading());
            newTable.insertRow(toAdd);
            return newTable;
        }
    }

    //Same as above but returns the rows as a table where the values under the two headings are not equal
    private Table notEquals(String _s1, String _s2, Table _t) {
        if(_s1.isEmpty() || _s2.isEmpty() || _t == null){
            System.out.println("Error:Dbms:notEquals: one or more arguments passed is/are null, returning null");
            return null;
        }
        //Compares headers, calculates comparison, and returns table
        Vector<Integer> compareHeaders = new Vector<Integer>();
        for(int i = 0; i < _t.getHeading().size(); i++) {
            if(_t.getHeading().elementAt(i).contentEquals(_s1))
                compareHeaders.add(i);
            else if(_t.getHeading().elementAt(i).contentEquals(_s2))
                compareHeaders.add(i);
        }
        if(compareHeaders.size() != 2){
            System.out.println("Error:Dbms:notEquals: expected two headers, got " + compareHeaders.size() + ", returning null");
            return null;
        }
        Hashtable hs = _t.getTableData();
        Set<String> keys = hs.keySet();
        Vector<Row> toAdd = new Vector<Row>();
        String h1, h2;
        for(String k : keys) {
            h1 = (String)((Row) hs.get(k)).getDataAtIndex(compareHeaders.firstElement());
            h2 = (String)((Row) hs.get(k)).getDataAtIndex(compareHeaders.lastElement());
            if(!h1.contentEquals(h2))
                toAdd.add((Row) hs.get(k));
        }
        if(toAdd.isEmpty())
            System.out.println("Warning:Dbms:notEquals: table to be returned is empty, still gonna send it");
        Table newTable = new Table();
        newTable.setHeading(_t.getHeading());
        newTable.setPrimKey(_t.getPrimKeyHeading());
        newTable.insertRow(toAdd);
        return newTable;
    }

    //checks to see if the values in table _t in column _s are greater than, less than, etc (_compare) int _i
    private Table comparator(String _s, int _i, Table _t, String _compare) {
        if(_s.isEmpty() || _t == null || _compare.isEmpty()){
            System.out.println("Error:Dbms:comparator: one or more arguments passed is/are null, returning null");
            return null;
        }
        //Compares headers, calculates comparison, returns table
        int index = -1;
        for(int i = 0; i < _t.getHeading().size(); i++) {
            if(_t.getHeading().get(i).contentEquals(_s)) {
                index = i;
                i = _t.getHeading().size();
            }
        }
        if(index < 0){
            System.out.println("Error:Dbms:comparator: no heading matching " + _s + " found, returning null");
            return null;
        }
        Hashtable hs = _t.getTableData();
        Set<String> keys = hs.keySet();
        Vector<Row> toAdd = new Vector<Row>();
        Table newTable = new Table();
        newTable.setHeading(_t.getHeading());
        newTable.setPrimKey(_t.getPrimKeyHeading());
        switch(_compare) {
            case ">":
                for(String k : keys) {
                    Row tempRow = new Row(((Row) hs.get(k)).getData());
                    if(Integer.valueOf((String) tempRow.getDataAtIndex(index)) > _i)
                        toAdd.add((Row) hs.get(k));
                }
                break;
            case "<":
                for(String k : keys) {
                    Row tempRow = new Row(((Row) hs.get(k)).getData());
                    if(Integer.valueOf((String) tempRow.getDataAtIndex(index)) < _i)
                        toAdd.add((Row) hs.get(k));
                }
                break;
            case ">=":
                for(String k : keys) {
                    Row tempRow = new Row(((Row) hs.get(k)).getData());
                    if(Integer.valueOf((String) tempRow.getDataAtIndex(index)) >= _i)
                        toAdd.add((Row) hs.get(k));
                }
                break;
            case "<=":
                for(String k : keys) {
                    Row tempRow = new Row(((Row) hs.get(k)).getData());
                    if(Integer.valueOf((String) tempRow.getDataAtIndex(index)) <= _i)
                        toAdd.add((Row) hs.get(k));
                }
                break;
            default:
                System.out.println("Error:Dbms:comparator: comparator passed is incompatible, you should legit never see this error, returning null");
                return null;
        }
        if(toAdd.isEmpty())
            System.out.println("Warning:Dbms:comparator: table to be returned is empty, still gonna send it");
        newTable.insertRow(toAdd);
        return newTable;
    }

    //Returns a table of rows that are in table _a and table _b
    private Table and(Table _a, Table _b) {
        //Finds duplicates, calculates comparison, returns table
        if(_a == null || _b == null){
            System.out.println("Error:Dbms:and: one or both tables passed is/are null, returning null");
            return null;
        }
        Hashtable tableA = _a.getTableData();
        Hashtable tableB = _b.getTableData();
        Set<String> keysA = tableA.keySet();
        Set<String> keysB = tableB.keySet();
        Vector<String> duplicates = new Vector<String>();
        Table newTable = new Table();
        newTable.setHeading(_a.getHeading());
        newTable.setPrimKey(_a.getPrimKeyHeading());
        for(String ka : keysA) {
            for(String kb : keysB) {
                if(ka.contentEquals(kb)) {
                    duplicates.add(ka);
                    break;
                }
            }
        }
        Vector<Row> toAdd = new Vector<Row>();
        for(String ka : keysA) {
            if(duplicates.contains(ka))
                toAdd.add((Row) tableA.get(ka));
        }
        if(toAdd.isEmpty())
            System.out.println("Warning:Dbms:and: no overlap between passed tables, returned table will be null");
        newTable.insertRow(toAdd);
        return newTable;
    }

    //returns the table with the name _name
    public Table getTable(String _name) {
        //error checks
        if(_name.isEmpty()) {
            System.out.println("Error:Dbms:getTable:The passed argument is empty, nothing done");
            return null;
        }
        int i = getTableIndex(_name);
        if(i < 0) {
            //System.out.println("Error:Dbms:getTable:table " + _name + " not in tables vector, nothing done");
            return null;
        }

        //returns requested table
        return tables.elementAt(i);
    }

    //Saves passed table _t into the vector of tables and assigns it the name _name
    public void saveTable(String _name, Table _t) {
        if(_name.isEmpty() || _t == null){
            System.out.println("Error:Dbms:saveTable: one or both arguments passed is/are null, nothing done");
            return;
        }
        //Changes name of table and adds it to stack
        if(tables.contains(getTable(_name))){
            System.out.print("Warning:Dbms:saveTable:Table already exists with the same name, naming new table ");
            int i = 0;
            String tempName = _name;
            while(tables.contains(getTable(tempName))){
                i++;
                tempName = _name;
                tempName = tempName + i;
            }
            _name = tempName;
            System.out.println(_name);
        }
        _t.setName(_name);
        tables.add(_t);
    }

    //adds the rows from table _assignedFrom to the table _assignedTo, good for duplicating a table to a new table without any elements
    public void assign(Table _assignedTo, Table _assignedFrom) {
        if(_assignedFrom == null || _assignedTo == null){
            System.out.println("Error:Dbms:assign: one or both arguments passed is/are null, nothing done");
            return;
        }
        if(_assignedFrom.getTableData().isEmpty()){
            System.out.println("Warning:Dbms:assign: table _assignedFrom is empty, nothing done");
            return;
        }
        //Gets rows to insert, then inserts
        Vector<Row> toInsert = new Vector<Row>();
        Hashtable ht = _assignedFrom.getTableData();
        _assignedTo.setHeading(_assignedFrom.getHeading());
        _assignedTo.setPrimKey(_assignedFrom.getPrimKeyHeading());
        Set<String> keys = ht.keySet();
        for(String k : keys) {
            toInsert.add((Row) ht.get(k));
        }
        _assignedTo.insertRow(toInsert);
    }

    //Combines two rows into one row, used by product() function
    private Row combineRows(Row _a, Row _b) {
        if(_a.getData() == null || _b.getData() == null){
            System.out.println("Error:Dbms:combineRows: one or both rows passed is/are null, returning null");
            return null;
        }
        if(_a.getData().isEmpty() && _b.getData().isEmpty()){
            System.out.println("Warning:Dbms:combineRows: both rows passed are empty, returning empty row");
            return _a;
        }
        else if(_a.getData().isEmpty()){
            System.out.println("Warning:Dbms:combineRows: first row passed is empty, returning second row unmodified");
            return _b;
        }
        else if(_b.getData().isEmpty()){
            System.out.println("Warning:Dbms:combineRows: second row passed is empty, returning first row unmodified");
            return _a;
        }
        //gets data to combine then calculates and returns row
        Vector toCombine = new Vector();
        toCombine.addAll(_a.getData());
        toCombine.addAll(_b.getData());
        Row newRow = new Row(toCombine);
        return newRow;
    }

    //Gets the table named _name from the vector of tables and returns it's index in the vector of tables
    private int getTableIndex(String _name) {
        //Returns index in stack of given table
        for(int i = 0; i < tables.size(); i++) {
            if(tables.elementAt(i).getName().contentEquals(_name)) {
                return i;
            }
        }
        //System.out.println("Warning:Dbms:getTableIndex: table " + _name + " not in table vector");
        return -1;
    }

    //Pulled (and then modified) from stack overflow (https://stackoverflow.com/questions/15725370/write-a-mode-method-in-java-to-find-the-most-frequently-occurring-element-in-an), finds most common element in an array
    public String mode(List<Object> _l)
    {
        HashMap<String,Integer> hm = new HashMap<String, Integer>();
        int max  = 1;
        String temp = "";

        for(int i = 0; i < _l.size(); i++) {

            if (hm.get(_l.get(i)) != null) {

                int count = hm.get(_l.get(i));
                count++;
                hm.put(_l.get(i).toString(), count);

                if(count > max) {
                    max  = count;
                    temp = _l.get(i).toString();
                }
            }

            else
                hm.put(_l.get(i).toString(),1);
        }
        return temp;
    }
}