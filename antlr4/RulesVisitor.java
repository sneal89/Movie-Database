// Generated from C:/Users/SJ/IdeaProjects/DatabaseSystem/src/project1\Rules.g4 by ANTLR 4.7.2
package project1.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RulesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RulesParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(RulesParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(RulesParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(RulesParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#showcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowcmd(RulesParser.ShowcmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#createcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatecmd(RulesParser.CreatecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#updatecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatecmd(RulesParser.UpdatecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#insertcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertcmd(RulesParser.InsertcmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#deletecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeletecmd(RulesParser.DeletecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(RulesParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#atomicexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicexpr(RulesParser.AtomicexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(RulesParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#projection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjection(RulesParser.ProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#renaming}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenaming(RulesParser.RenamingContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(RulesParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#difference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifference(RulesParser.DifferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#product}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProduct(RulesParser.ProductContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#naturaljoin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturaljoin(RulesParser.NaturaljoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(RulesParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(RulesParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(RulesParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#attributelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributelist(RulesParser.AttributelistContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#typedattributelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedattributelist(RulesParser.TypedattributelistContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#opencmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpencmd(RulesParser.OpencmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#closecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosecmd(RulesParser.ClosecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#writecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritecmd(RulesParser.WritecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#exitcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitcmd(RulesParser.ExitcmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(RulesParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(RulesParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#relationname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationname(RulesParser.RelationnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#attributename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributename(RulesParser.AttributenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link RulesParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(RulesParser.TypeContext ctx);
}