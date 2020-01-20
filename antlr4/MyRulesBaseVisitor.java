package project1.antlr4;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import project1.Dbms;
import project1.Table;

import java.util.*;


public class MyRulesBaseVisitor<Object> extends RulesBaseVisitor<Object> {
    Dbms myDbms;

    public MyRulesBaseVisitor() {
        myDbms = new Dbms();
    }

    @Override
    /*DONE*/public Object visitProgram(RulesParser.ProgramContext ctx) {
        myDbms.clearStack();
        for(int i = 0; i < ctx.getChildCount(); i++){
            return visit(ctx.getChild(i));
        }
        return null;
    }

    @Override
    /*DONE*/public Object visitQuery(RulesParser.QueryContext ctx) {
        Table temp1;
        Object tempObj = visit(ctx.getChild(2));
        if (tempObj instanceof String)
            temp1 = myDbms.getTable((String) tempObj);
        else
            temp1 = (Table) tempObj;
        myDbms.saveTable(ctx.getChild(0).getText(), temp1);
        return null;
    }

    @Override
    /*DONE*/public Object visitExpr(RulesParser.ExprContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    /*DONE*/public Object visitAtomicexpr(RulesParser.AtomicexprContext ctx) {
        if(ctx.getChildCount() > 1)
            return visit(ctx.getChild(1));
        else
            return visit(ctx.getChild(0));
    }

    @Override
    /*DONE*/public Object visitSelection(RulesParser.SelectionContext ctx) {
        Table temp1;
        Object tempObj = visit(ctx.getChild(4));
        if (tempObj instanceof String)
            temp1 = myDbms.getTable((String) tempObj);
        else
            temp1 = (Table) tempObj;
        myDbms.pushStack(temp1);
        Object temp = visit(ctx.getChild(2));
        myDbms.popStack();
        return temp;
    }

    @Override
    /*DONE*/public Object visitProjection(RulesParser.ProjectionContext ctx) {
        Table temp1;
        Object tempObj = visit(ctx.getChild(4));
        if (tempObj instanceof String)
            temp1 = myDbms.getTable((String) tempObj);
        else
            temp1 = (Table) tempObj;
        return (Object) myDbms.project((Vector<String>) visit(ctx.getChild(2)), temp1);
    }

    @Override
    /*DONE*/public Object visitProduct(RulesParser.ProductContext ctx) {
        return (Object) myDbms.select(myDbms.getTable((String) visit(ctx.getChild(0))), myDbms.getTable((String)visit(ctx.getChild(2))), ctx.getChild(1).getText(), null);
    }

    @Override
    /*DONE*/public Object visitComparison(RulesParser.ComparisonContext ctx) {
        if(ctx.getChild(0).getText().contentEquals("(") || ctx.getChild(2).getText().contentEquals(")"))
            return visit(ctx.getChild(1));
        else
            return (Object) myDbms.select(visit(ctx.getChild(0)),visit(ctx.getChild(2)), ctx.getChild(1).getText(), myDbms.peekStack());
    }

    @Override
    /*DONE*/public Object visitCondition(RulesParser.ConditionContext ctx) {
        Table temp = (Table) visit(ctx.getChild(0));
        if(ctx.getChildCount() == 1)
            return (Object) temp;
        else{
            for(int i = 2; i < ctx.getChildCount(); i++){
                if(i % 2 == 0)
                    temp = myDbms.select(temp,(Table) visit(ctx.getChild(i)), ctx.getChild(i - 1).getText(), null);
            }
            return (Object) temp;
        }
    }

    @Override
    /*DONE*/public Object visitConjunction(RulesParser.ConjunctionContext ctx) {
        Table temp = (Table) visit(ctx.getChild(0));
        if(ctx.getChildCount() == 1)
            return (Object) temp;
        else{
            for(int i = 2; i < ctx.getChildCount(); i++){
                if(i % 2 == 0)
                    temp = myDbms.select(temp,(Table) visit(ctx.getChild(i)), ctx.getChild(i - 1).getText(), null);
            }
            return (Object) temp;
        }
    }

    @Override
    /*DONE*/public Object visitAttributelist(RulesParser.AttributelistContext ctx) {
        Vector<String> attrNames = new Vector<String>();
        for(int i = 0; i < ctx.getChildCount(); i++){
            if (i % 2 == 0)
                attrNames.add((String) visit(ctx.getChild(i)));
        }
        return (Object) attrNames;
    }

    @Override
    /*DONE*/public Object visitOperand(RulesParser.OperandContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    /*DONE*/public Object visitRelationname(RulesParser.RelationnameContext ctx) {
        return (Object) ctx.getText();
    }

    @Override
    /*DONE*/public Object visitAttributename(RulesParser.AttributenameContext ctx) {
        return (Object) ctx.getText();
    }

    @Override
    /*DONE*/public Object visitCommand(RulesParser.CommandContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    /*DONE*/public Object visitShowcmd(RulesParser.ShowcmdContext ctx) {
        myDbms.show((String) visit(ctx.getChild(1)));
        return null;
    }

    @Override
    /*DONE*/public Object visitCreatecmd(RulesParser.CreatecmdContext ctx) {
        myDbms.create((String) visit(ctx.getChild(1)), (Vector<String>) visit(ctx.getChild(3)), (Vector<String>) visit(ctx.getChild(7)));
        return null;
    }

    @Override
    /*DONE*/public Object visitUpdatecmd(RulesParser.UpdatecmdContext ctx) {
        Table temp = myDbms.getTable((String) visit(ctx.getChild(1)));
        myDbms.pushStack(temp);
        myDbms.update((String) visit(ctx.getChild(3)), visit(ctx.getChild(5)), temp, (Table) visit(ctx.getChild(7)));
        myDbms.popStack();
        return null;
    }

    @Override
    /*DONE*/public Object visitInsertcmd(RulesParser.InsertcmdContext ctx) {
        if(ctx.getChild(2).getText().contentEquals("VALUES FROM")) {
            Vector<String> toInsert = new Vector<String>();
            for(int i = 4; i < ctx.getChildCount(); i++){
                if(i % 2 == 0)
                    toInsert.add((String) visit(ctx.getChild(i)));
            }
            myDbms.insert((String) visit(ctx.getChild(1)), toInsert);
            return null;
        }
        else{
            myDbms.assign(myDbms.getTable((String) visit(ctx.getChild(1))), (Table) visit(ctx.getChild(3)));
            return null;
        }
    }

    @Override
    /*DONE*/public Object visitDeletecmd(RulesParser.DeletecmdContext ctx) {
        Table temp = myDbms.getTable((String) visit(ctx.getChild(1)));
        myDbms.pushStack(temp);
        myDbms.delete(temp, (Table) visit(ctx.getChild(3)));
        myDbms.popStack();
        return null;
    }

    @Override
    /*DONE*/public Object visitRenaming(RulesParser.RenamingContext ctx) {
        return (Object) myDbms.rename((Vector<String>)visit(ctx.getChild(2)), (Table) visit(ctx.getChild(4)));
    }

    @Override
    /*DONE*/public Object visitUnion(RulesParser.UnionContext ctx) {
        Table temp1;
        Object tempObj1 = visit(ctx.getChild(0));
        Table temp2;
        Object tempObj2 = visit(ctx.getChild(2));

        if(tempObj1 instanceof String)
            temp1 = myDbms.getTable((String) tempObj1);
        else
            temp1 = (Table) tempObj1;
        if(tempObj2 instanceof String)
            temp2 = myDbms.getTable((String) tempObj2);
        else
            temp2 = (Table) tempObj2;
        return (Object) myDbms.union(temp1, temp2);
    }

    @Override
    /*DONE, check implimentation*/public Object visitDifference(RulesParser.DifferenceContext ctx) {
        return (Object) myDbms.difference((Table) visit(ctx.getChild(0)), (Table) visit(ctx.getChild(2)));
    }

    @Override
    /*TODO - not required for teams of 4*/public Object visitNaturaljoin(RulesParser.NaturaljoinContext ctx) {
        System.out.println("Warning: naturalJoin not implemented");
        return null;
    }

    @Override
    /*DONE*/public Object visitTypedattributelist(RulesParser.TypedattributelistContext ctx) {
        Vector<String> toReturn = new Vector<String>();
        for(int i = 0; i < ctx.getChildCount(); i++){
            if( i % 3 == 0)
                toReturn.add((String) visit(ctx.getChild(i)));
        }
         return (Object) toReturn;
    }

    @Override
    /*DONE*/public Object visitOpencmd(RulesParser.OpencmdContext ctx) {
        myDbms.open((String) visit(ctx.getChild(1)));
        return null;
    }

    @Override
    /*DONE*/public Object visitClosecmd(RulesParser.ClosecmdContext ctx) {
        myDbms.close((String) visit(ctx.getChild(1)));
        return null;
    }

    @Override
    /*DONE*/public Object visitWritecmd(RulesParser.WritecmdContext ctx) {
        //myDbms.write((String) visit(ctx.getChild(1)));
        myDbms.write((String) ctx.getChild(1).getText());
        return null;
    }

    @Override
    /*DONE*/public Object visitExitcmd(RulesParser.ExitcmdContext ctx) {
        myDbms.exit();
        return null;
    }

    @Override
    /*DONE*/public Object visitLiteral(RulesParser.LiteralContext ctx) {
        return (Object) ctx.getChild(0).getText();
    }

    @Override
    /*DONE - not used but it works*/public Object visitType(RulesParser.TypeContext ctx) {
        if(ctx.getChildCount() == 1)
            return (Object) ctx.getChild(0).getText();
        else{
            Vector toReturn = new Vector();
            toReturn.add(ctx.getChild(0).getText());
            toReturn.add(ctx.getChild(2).getText());
            return (Object) toReturn;
        }
    }
}
