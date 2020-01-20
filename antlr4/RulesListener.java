// Generated from C:/Users/SJ/IdeaProjects/DatabaseSystem/src/project1\Rules.g4 by ANTLR 4.7.2
package project1.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RulesParser}.
 */
public interface RulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RulesParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(RulesParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(RulesParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(RulesParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(RulesParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(RulesParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(RulesParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#showcmd}.
	 * @param ctx the parse tree
	 */
	void enterShowcmd(RulesParser.ShowcmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#showcmd}.
	 * @param ctx the parse tree
	 */
	void exitShowcmd(RulesParser.ShowcmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#createcmd}.
	 * @param ctx the parse tree
	 */
	void enterCreatecmd(RulesParser.CreatecmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#createcmd}.
	 * @param ctx the parse tree
	 */
	void exitCreatecmd(RulesParser.CreatecmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#updatecmd}.
	 * @param ctx the parse tree
	 */
	void enterUpdatecmd(RulesParser.UpdatecmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#updatecmd}.
	 * @param ctx the parse tree
	 */
	void exitUpdatecmd(RulesParser.UpdatecmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#insertcmd}.
	 * @param ctx the parse tree
	 */
	void enterInsertcmd(RulesParser.InsertcmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#insertcmd}.
	 * @param ctx the parse tree
	 */
	void exitInsertcmd(RulesParser.InsertcmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#deletecmd}.
	 * @param ctx the parse tree
	 */
	void enterDeletecmd(RulesParser.DeletecmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#deletecmd}.
	 * @param ctx the parse tree
	 */
	void exitDeletecmd(RulesParser.DeletecmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(RulesParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(RulesParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#atomicexpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomicexpr(RulesParser.AtomicexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#atomicexpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomicexpr(RulesParser.AtomicexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(RulesParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(RulesParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#projection}.
	 * @param ctx the parse tree
	 */
	void enterProjection(RulesParser.ProjectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#projection}.
	 * @param ctx the parse tree
	 */
	void exitProjection(RulesParser.ProjectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#renaming}.
	 * @param ctx the parse tree
	 */
	void enterRenaming(RulesParser.RenamingContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#renaming}.
	 * @param ctx the parse tree
	 */
	void exitRenaming(RulesParser.RenamingContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnion(RulesParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnion(RulesParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#difference}.
	 * @param ctx the parse tree
	 */
	void enterDifference(RulesParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#difference}.
	 * @param ctx the parse tree
	 */
	void exitDifference(RulesParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#product}.
	 * @param ctx the parse tree
	 */
	void enterProduct(RulesParser.ProductContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#product}.
	 * @param ctx the parse tree
	 */
	void exitProduct(RulesParser.ProductContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#naturaljoin}.
	 * @param ctx the parse tree
	 */
	void enterNaturaljoin(RulesParser.NaturaljoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#naturaljoin}.
	 * @param ctx the parse tree
	 */
	void exitNaturaljoin(RulesParser.NaturaljoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(RulesParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(RulesParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(RulesParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(RulesParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(RulesParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(RulesParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#attributelist}.
	 * @param ctx the parse tree
	 */
	void enterAttributelist(RulesParser.AttributelistContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#attributelist}.
	 * @param ctx the parse tree
	 */
	void exitAttributelist(RulesParser.AttributelistContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#typedattributelist}.
	 * @param ctx the parse tree
	 */
	void enterTypedattributelist(RulesParser.TypedattributelistContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#typedattributelist}.
	 * @param ctx the parse tree
	 */
	void exitTypedattributelist(RulesParser.TypedattributelistContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#opencmd}.
	 * @param ctx the parse tree
	 */
	void enterOpencmd(RulesParser.OpencmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#opencmd}.
	 * @param ctx the parse tree
	 */
	void exitOpencmd(RulesParser.OpencmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#closecmd}.
	 * @param ctx the parse tree
	 */
	void enterClosecmd(RulesParser.ClosecmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#closecmd}.
	 * @param ctx the parse tree
	 */
	void exitClosecmd(RulesParser.ClosecmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#writecmd}.
	 * @param ctx the parse tree
	 */
	void enterWritecmd(RulesParser.WritecmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#writecmd}.
	 * @param ctx the parse tree
	 */
	void exitWritecmd(RulesParser.WritecmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#exitcmd}.
	 * @param ctx the parse tree
	 */
	void enterExitcmd(RulesParser.ExitcmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#exitcmd}.
	 * @param ctx the parse tree
	 */
	void exitExitcmd(RulesParser.ExitcmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(RulesParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(RulesParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(RulesParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(RulesParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#relationname}.
	 * @param ctx the parse tree
	 */
	void enterRelationname(RulesParser.RelationnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#relationname}.
	 * @param ctx the parse tree
	 */
	void exitRelationname(RulesParser.RelationnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#attributename}.
	 * @param ctx the parse tree
	 */
	void enterAttributename(RulesParser.AttributenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#attributename}.
	 * @param ctx the parse tree
	 */
	void exitAttributename(RulesParser.AttributenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RulesParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(RulesParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RulesParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(RulesParser.TypeContext ctx);
}