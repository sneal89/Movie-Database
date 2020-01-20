// Generated from C:/Users/SJ/IdeaProjects/DatabaseSystem/src/project1\Rules.g4 by ANTLR 4.7.2
package project1.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RulesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, INTEGER=31, 
		OP=32, IDENTIFIER=33, STRINGLITERAL=34, ALPHA=35, DIGIT=36, WS=37;
	public static final int
		RULE_program = 0, RULE_command = 1, RULE_query = 2, RULE_showcmd = 3, 
		RULE_createcmd = 4, RULE_updatecmd = 5, RULE_insertcmd = 6, RULE_deletecmd = 7, 
		RULE_expr = 8, RULE_atomicexpr = 9, RULE_selection = 10, RULE_projection = 11, 
		RULE_renaming = 12, RULE_union = 13, RULE_difference = 14, RULE_product = 15, 
		RULE_naturaljoin = 16, RULE_comparison = 17, RULE_condition = 18, RULE_conjunction = 19, 
		RULE_attributelist = 20, RULE_typedattributelist = 21, RULE_opencmd = 22, 
		RULE_closecmd = 23, RULE_writecmd = 24, RULE_exitcmd = 25, RULE_operand = 26, 
		RULE_literal = 27, RULE_relationname = 28, RULE_attributename = 29, RULE_type = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "command", "query", "showcmd", "createcmd", "updatecmd", "insertcmd", 
			"deletecmd", "expr", "atomicexpr", "selection", "projection", "renaming", 
			"union", "difference", "product", "naturaljoin", "comparison", "condition", 
			"conjunction", "attributelist", "typedattributelist", "opencmd", "closecmd", 
			"writecmd", "exitcmd", "operand", "literal", "relationname", "attributename", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<-'", "'SHOW'", "'CREATE TABLE'", "'('", "')'", "'PRIMARY KEY'", 
			"'UPDATE'", "'SET'", "'='", "','", "'WHERE'", "'INSERT INTO'", "'VALUES FROM'", 
			"'VALUES FROM RELATION'", "'DELETE FROM'", "'select'", "'project'", "'rename'", 
			"'+'", "'-'", "'*'", "'&'", "'||'", "'&&'", "'OPEN'", "'CLOSE'", "'WRITE'", 
			"'EXIT'", "'VARCHAR'", "'INTEGER'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "INTEGER", "OP", "IDENTIFIER", 
			"STRINGLITERAL", "ALPHA", "DIGIT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "project1/Rules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RulesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__6) | (1L << T__11) | (1L << T__14) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(64);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(62);
					query();
					}
					break;
				case T__1:
				case T__2:
				case T__6:
				case T__11:
				case T__14:
				case T__24:
				case T__25:
				case T__26:
				case T__27:
					{
					setState(63);
					command();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public OpencmdContext opencmd() {
			return getRuleContext(OpencmdContext.class,0);
		}
		public ClosecmdContext closecmd() {
			return getRuleContext(ClosecmdContext.class,0);
		}
		public WritecmdContext writecmd() {
			return getRuleContext(WritecmdContext.class,0);
		}
		public ExitcmdContext exitcmd() {
			return getRuleContext(ExitcmdContext.class,0);
		}
		public ShowcmdContext showcmd() {
			return getRuleContext(ShowcmdContext.class,0);
		}
		public CreatecmdContext createcmd() {
			return getRuleContext(CreatecmdContext.class,0);
		}
		public UpdatecmdContext updatecmd() {
			return getRuleContext(UpdatecmdContext.class,0);
		}
		public InsertcmdContext insertcmd() {
			return getRuleContext(InsertcmdContext.class,0);
		}
		public DeletecmdContext deletecmd() {
			return getRuleContext(DeletecmdContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				opencmd();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				closecmd();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				writecmd();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				exitcmd();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				showcmd();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 6);
				{
				setState(74);
				createcmd();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(75);
				updatecmd();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 8);
				{
				setState(76);
				insertcmd();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 9);
				{
				setState(77);
				deletecmd();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			relationname();
			setState(81);
			match(T__0);
			setState(82);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShowcmdContext extends ParserRuleContext {
		public AtomicexprContext atomicexpr() {
			return getRuleContext(AtomicexprContext.class,0);
		}
		public ShowcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showcmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterShowcmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitShowcmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitShowcmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowcmdContext showcmd() throws RecognitionException {
		ShowcmdContext _localctx = new ShowcmdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_showcmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__1);
			setState(85);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatecmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public TypedattributelistContext typedattributelist() {
			return getRuleContext(TypedattributelistContext.class,0);
		}
		public AttributelistContext attributelist() {
			return getRuleContext(AttributelistContext.class,0);
		}
		public CreatecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createcmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterCreatecmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitCreatecmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitCreatecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatecmdContext createcmd() throws RecognitionException {
		CreatecmdContext _localctx = new CreatecmdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_createcmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__2);
			setState(88);
			relationname();
			setState(89);
			match(T__3);
			setState(90);
			typedattributelist();
			setState(91);
			match(T__4);
			setState(92);
			match(T__5);
			setState(93);
			match(T__3);
			setState(94);
			attributelist();
			setState(95);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdatecmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public List<AttributenameContext> attributename() {
			return getRuleContexts(AttributenameContext.class);
		}
		public AttributenameContext attributename(int i) {
			return getRuleContext(AttributenameContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public UpdatecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updatecmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterUpdatecmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitUpdatecmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitUpdatecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdatecmdContext updatecmd() throws RecognitionException {
		UpdatecmdContext _localctx = new UpdatecmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_updatecmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__6);
			setState(98);
			relationname();
			setState(99);
			match(T__7);
			setState(100);
			attributename();
			setState(101);
			match(T__8);
			setState(102);
			literal();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(103);
				match(T__9);
				setState(104);
				attributename();
				setState(105);
				match(T__8);
				setState(106);
				literal();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(T__10);
			setState(114);
			condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertcmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InsertcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertcmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterInsertcmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitInsertcmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitInsertcmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertcmdContext insertcmd() throws RecognitionException {
		InsertcmdContext _localctx = new InsertcmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_insertcmd);
		int _la;
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(116);
				match(T__11);
				setState(117);
				relationname();
				setState(118);
				match(T__12);
				setState(119);
				match(T__3);
				setState(120);
				literal();
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(121);
					match(T__9);
					setState(122);
					literal();
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(128);
				match(T__4);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				match(T__11);
				setState(131);
				relationname();
				setState(132);
				match(T__13);
				setState(133);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeletecmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public DeletecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deletecmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterDeletecmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitDeletecmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitDeletecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeletecmdContext deletecmd() throws RecognitionException {
		DeletecmdContext _localctx = new DeletecmdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_deletecmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__14);
			setState(138);
			relationname();
			setState(139);
			match(T__10);
			setState(140);
			condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public AtomicexprContext atomicexpr() {
			return getRuleContext(AtomicexprContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public ProjectionContext projection() {
			return getRuleContext(ProjectionContext.class,0);
		}
		public RenamingContext renaming() {
			return getRuleContext(RenamingContext.class,0);
		}
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public DifferenceContext difference() {
			return getRuleContext(DifferenceContext.class,0);
		}
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public NaturaljoinContext naturaljoin() {
			return getRuleContext(NaturaljoinContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr);
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				atomicexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				selection();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				projection();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				renaming();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(146);
				union();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(147);
				difference();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(148);
				product();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(149);
				naturaljoin();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicexprContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtomicexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterAtomicexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitAtomicexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitAtomicexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicexprContext atomicexpr() throws RecognitionException {
		AtomicexprContext _localctx = new AtomicexprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atomicexpr);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				relationname();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				match(T__3);
				setState(154);
				expr();
				setState(155);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public AtomicexprContext atomicexpr() {
			return getRuleContext(AtomicexprContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__15);
			setState(160);
			match(T__3);
			setState(161);
			condition();
			setState(162);
			match(T__4);
			setState(163);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProjectionContext extends ParserRuleContext {
		public AttributelistContext attributelist() {
			return getRuleContext(AttributelistContext.class,0);
		}
		public AtomicexprContext atomicexpr() {
			return getRuleContext(AtomicexprContext.class,0);
		}
		public ProjectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterProjection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitProjection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitProjection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectionContext projection() throws RecognitionException {
		ProjectionContext _localctx = new ProjectionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_projection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__16);
			setState(166);
			match(T__3);
			setState(167);
			attributelist();
			setState(168);
			match(T__4);
			setState(169);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RenamingContext extends ParserRuleContext {
		public AttributelistContext attributelist() {
			return getRuleContext(AttributelistContext.class,0);
		}
		public AtomicexprContext atomicexpr() {
			return getRuleContext(AtomicexprContext.class,0);
		}
		public RenamingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_renaming; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterRenaming(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitRenaming(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitRenaming(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RenamingContext renaming() throws RecognitionException {
		RenamingContext _localctx = new RenamingContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_renaming);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__17);
			setState(172);
			match(T__3);
			setState(173);
			attributelist();
			setState(174);
			match(T__4);
			setState(175);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionContext extends ParserRuleContext {
		public List<AtomicexprContext> atomicexpr() {
			return getRuleContexts(AtomicexprContext.class);
		}
		public AtomicexprContext atomicexpr(int i) {
			return getRuleContext(AtomicexprContext.class,i);
		}
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			atomicexpr();
			setState(178);
			match(T__18);
			setState(179);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DifferenceContext extends ParserRuleContext {
		public List<AtomicexprContext> atomicexpr() {
			return getRuleContexts(AtomicexprContext.class);
		}
		public AtomicexprContext atomicexpr(int i) {
			return getRuleContext(AtomicexprContext.class,i);
		}
		public DifferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterDifference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitDifference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DifferenceContext difference() throws RecognitionException {
		DifferenceContext _localctx = new DifferenceContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_difference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			atomicexpr();
			setState(182);
			match(T__19);
			setState(183);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProductContext extends ParserRuleContext {
		public List<AtomicexprContext> atomicexpr() {
			return getRuleContexts(AtomicexprContext.class);
		}
		public AtomicexprContext atomicexpr(int i) {
			return getRuleContext(AtomicexprContext.class,i);
		}
		public ProductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_product; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitProduct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitProduct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProductContext product() throws RecognitionException {
		ProductContext _localctx = new ProductContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_product);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			atomicexpr();
			setState(186);
			match(T__20);
			setState(187);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NaturaljoinContext extends ParserRuleContext {
		public List<AtomicexprContext> atomicexpr() {
			return getRuleContexts(AtomicexprContext.class);
		}
		public AtomicexprContext atomicexpr(int i) {
			return getRuleContext(AtomicexprContext.class,i);
		}
		public NaturaljoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_naturaljoin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterNaturaljoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitNaturaljoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitNaturaljoin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NaturaljoinContext naturaljoin() throws RecognitionException {
		NaturaljoinContext _localctx = new NaturaljoinContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_naturaljoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			atomicexpr();
			setState(190);
			match(T__21);
			setState(191);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public TerminalNode OP() { return getToken(RulesParser.OP, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_comparison);
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case IDENTIFIER:
			case STRINGLITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				operand();
				setState(194);
				match(OP);
				setState(195);
				operand();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(T__3);
				setState(198);
				condition();
				setState(199);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			conjunction();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(204);
				match(T__22);
				setState(205);
				conjunction();
				}
				}
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConjunctionContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			comparison();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(212);
				match(T__23);
				setState(213);
				comparison();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributelistContext extends ParserRuleContext {
		public List<AttributenameContext> attributename() {
			return getRuleContexts(AttributenameContext.class);
		}
		public AttributenameContext attributename(int i) {
			return getRuleContext(AttributenameContext.class,i);
		}
		public AttributelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributelist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterAttributelist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitAttributelist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitAttributelist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributelistContext attributelist() throws RecognitionException {
		AttributelistContext _localctx = new AttributelistContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_attributelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			attributename();
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(220);
				match(T__9);
				setState(221);
				attributename();
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedattributelistContext extends ParserRuleContext {
		public List<AttributenameContext> attributename() {
			return getRuleContexts(AttributenameContext.class);
		}
		public AttributenameContext attributename(int i) {
			return getRuleContext(AttributenameContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypedattributelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedattributelist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterTypedattributelist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitTypedattributelist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitTypedattributelist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedattributelistContext typedattributelist() throws RecognitionException {
		TypedattributelistContext _localctx = new TypedattributelistContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typedattributelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			attributename();
			setState(228);
			type();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(229);
				match(T__9);
				setState(230);
				attributename();
				setState(231);
				type();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpencmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public OpencmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opencmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterOpencmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitOpencmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitOpencmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpencmdContext opencmd() throws RecognitionException {
		OpencmdContext _localctx = new OpencmdContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_opencmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__24);
			setState(239);
			relationname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClosecmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public ClosecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closecmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterClosecmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitClosecmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitClosecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosecmdContext closecmd() throws RecognitionException {
		ClosecmdContext _localctx = new ClosecmdContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_closecmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(T__25);
			setState(242);
			relationname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WritecmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public WritecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writecmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterWritecmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitWritecmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitWritecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WritecmdContext writecmd() throws RecognitionException {
		WritecmdContext _localctx = new WritecmdContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_writecmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(T__26);
			setState(245);
			relationname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExitcmdContext extends ParserRuleContext {
		public ExitcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exitcmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterExitcmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitExitcmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitExitcmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitcmdContext exitcmd() throws RecognitionException {
		ExitcmdContext _localctx = new ExitcmdContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_exitcmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandContext extends ParserRuleContext {
		public AttributenameContext attributename() {
			return getRuleContext(AttributenameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_operand);
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				attributename();
				}
				break;
			case INTEGER:
			case STRINGLITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRINGLITERAL() { return getToken(RulesParser.STRINGLITERAL, 0); }
		public TerminalNode INTEGER() { return getToken(RulesParser.INTEGER, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==STRINGLITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationnameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(RulesParser.IDENTIFIER, 0); }
		public RelationnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterRelationname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitRelationname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitRelationname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationnameContext relationname() throws RecognitionException {
		RelationnameContext _localctx = new RelationnameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_relationname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributenameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(RulesParser.IDENTIFIER, 0); }
		public AttributenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterAttributename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitAttributename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitAttributename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributenameContext attributename() throws RecognitionException {
		AttributenameContext _localctx = new AttributenameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_attributename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(RulesParser.INTEGER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RulesListener ) ((RulesListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RulesVisitor ) return ((RulesVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_type);
		try {
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(T__28);
				setState(260);
				match(T__3);
				setState(261);
				match(INTEGER);
				setState(262);
				match(T__4);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				match(T__29);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u010d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\7\2C\n\2\f\2\16\2F\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3Q"+
		"\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7o\n\7\f\7\16\7r\13\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b~\n\b\f\b\16\b\u0081\13\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u008a\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0099\n\n\3\13\3\13\3\13\3\13\3\13\5\13\u00a0"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00cc"+
		"\n\23\3\24\3\24\3\24\7\24\u00d1\n\24\f\24\16\24\u00d4\13\24\3\25\3\25"+
		"\3\25\7\25\u00d9\n\25\f\25\16\25\u00dc\13\25\3\26\3\26\3\26\7\26\u00e1"+
		"\n\26\f\26\16\26\u00e4\13\26\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00ec"+
		"\n\27\f\27\16\27\u00ef\13\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\5\34\u00fe\n\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3 \3 \3 \5 \u010b\n \3 \2\2!\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>\2\3\4\2!!$$\2\u0109\2D\3\2\2\2\4P\3\2\2\2"+
		"\6R\3\2\2\2\bV\3\2\2\2\nY\3\2\2\2\fc\3\2\2\2\16\u0089\3\2\2\2\20\u008b"+
		"\3\2\2\2\22\u0098\3\2\2\2\24\u009f\3\2\2\2\26\u00a1\3\2\2\2\30\u00a7\3"+
		"\2\2\2\32\u00ad\3\2\2\2\34\u00b3\3\2\2\2\36\u00b7\3\2\2\2 \u00bb\3\2\2"+
		"\2\"\u00bf\3\2\2\2$\u00cb\3\2\2\2&\u00cd\3\2\2\2(\u00d5\3\2\2\2*\u00dd"+
		"\3\2\2\2,\u00e5\3\2\2\2.\u00f0\3\2\2\2\60\u00f3\3\2\2\2\62\u00f6\3\2\2"+
		"\2\64\u00f9\3\2\2\2\66\u00fd\3\2\2\28\u00ff\3\2\2\2:\u0101\3\2\2\2<\u0103"+
		"\3\2\2\2>\u010a\3\2\2\2@C\5\6\4\2AC\5\4\3\2B@\3\2\2\2BA\3\2\2\2CF\3\2"+
		"\2\2DB\3\2\2\2DE\3\2\2\2E\3\3\2\2\2FD\3\2\2\2GQ\5.\30\2HQ\5\60\31\2IQ"+
		"\5\62\32\2JQ\5\64\33\2KQ\5\b\5\2LQ\5\n\6\2MQ\5\f\7\2NQ\5\16\b\2OQ\5\20"+
		"\t\2PG\3\2\2\2PH\3\2\2\2PI\3\2\2\2PJ\3\2\2\2PK\3\2\2\2PL\3\2\2\2PM\3\2"+
		"\2\2PN\3\2\2\2PO\3\2\2\2Q\5\3\2\2\2RS\5:\36\2ST\7\3\2\2TU\5\22\n\2U\7"+
		"\3\2\2\2VW\7\4\2\2WX\5\24\13\2X\t\3\2\2\2YZ\7\5\2\2Z[\5:\36\2[\\\7\6\2"+
		"\2\\]\5,\27\2]^\7\7\2\2^_\7\b\2\2_`\7\6\2\2`a\5*\26\2ab\7\7\2\2b\13\3"+
		"\2\2\2cd\7\t\2\2de\5:\36\2ef\7\n\2\2fg\5<\37\2gh\7\13\2\2hp\58\35\2ij"+
		"\7\f\2\2jk\5<\37\2kl\7\13\2\2lm\58\35\2mo\3\2\2\2ni\3\2\2\2or\3\2\2\2"+
		"pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rp\3\2\2\2st\7\r\2\2tu\5&\24\2u\r\3\2\2"+
		"\2vw\7\16\2\2wx\5:\36\2xy\7\17\2\2yz\7\6\2\2z\177\58\35\2{|\7\f\2\2|~"+
		"\58\35\2}{\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7\7\2\2\u0083\u008a\3\2\2"+
		"\2\u0084\u0085\7\16\2\2\u0085\u0086\5:\36\2\u0086\u0087\7\20\2\2\u0087"+
		"\u0088\5\22\n\2\u0088\u008a\3\2\2\2\u0089v\3\2\2\2\u0089\u0084\3\2\2\2"+
		"\u008a\17\3\2\2\2\u008b\u008c\7\21\2\2\u008c\u008d\5:\36\2\u008d\u008e"+
		"\7\r\2\2\u008e\u008f\5&\24\2\u008f\21\3\2\2\2\u0090\u0099\5\24\13\2\u0091"+
		"\u0099\5\26\f\2\u0092\u0099\5\30\r\2\u0093\u0099\5\32\16\2\u0094\u0099"+
		"\5\34\17\2\u0095\u0099\5\36\20\2\u0096\u0099\5 \21\2\u0097\u0099\5\"\22"+
		"\2\u0098\u0090\3\2\2\2\u0098\u0091\3\2\2\2\u0098\u0092\3\2\2\2\u0098\u0093"+
		"\3\2\2\2\u0098\u0094\3\2\2\2\u0098\u0095\3\2\2\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\23\3\2\2\2\u009a\u00a0\5:\36\2\u009b\u009c\7\6\2"+
		"\2\u009c\u009d\5\22\n\2\u009d\u009e\7\7\2\2\u009e\u00a0\3\2\2\2\u009f"+
		"\u009a\3\2\2\2\u009f\u009b\3\2\2\2\u00a0\25\3\2\2\2\u00a1\u00a2\7\22\2"+
		"\2\u00a2\u00a3\7\6\2\2\u00a3\u00a4\5&\24\2\u00a4\u00a5\7\7\2\2\u00a5\u00a6"+
		"\5\24\13\2\u00a6\27\3\2\2\2\u00a7\u00a8\7\23\2\2\u00a8\u00a9\7\6\2\2\u00a9"+
		"\u00aa\5*\26\2\u00aa\u00ab\7\7\2\2\u00ab\u00ac\5\24\13\2\u00ac\31\3\2"+
		"\2\2\u00ad\u00ae\7\24\2\2\u00ae\u00af\7\6\2\2\u00af\u00b0\5*\26\2\u00b0"+
		"\u00b1\7\7\2\2\u00b1\u00b2\5\24\13\2\u00b2\33\3\2\2\2\u00b3\u00b4\5\24"+
		"\13\2\u00b4\u00b5\7\25\2\2\u00b5\u00b6\5\24\13\2\u00b6\35\3\2\2\2\u00b7"+
		"\u00b8\5\24\13\2\u00b8\u00b9\7\26\2\2\u00b9\u00ba\5\24\13\2\u00ba\37\3"+
		"\2\2\2\u00bb\u00bc\5\24\13\2\u00bc\u00bd\7\27\2\2\u00bd\u00be\5\24\13"+
		"\2\u00be!\3\2\2\2\u00bf\u00c0\5\24\13\2\u00c0\u00c1\7\30\2\2\u00c1\u00c2"+
		"\5\24\13\2\u00c2#\3\2\2\2\u00c3\u00c4\5\66\34\2\u00c4\u00c5\7\"\2\2\u00c5"+
		"\u00c6\5\66\34\2\u00c6\u00cc\3\2\2\2\u00c7\u00c8\7\6\2\2\u00c8\u00c9\5"+
		"&\24\2\u00c9\u00ca\7\7\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c3\3\2\2\2\u00cb"+
		"\u00c7\3\2\2\2\u00cc%\3\2\2\2\u00cd\u00d2\5(\25\2\u00ce\u00cf\7\31\2\2"+
		"\u00cf\u00d1\5(\25\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0"+
		"\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\'\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00da\5$\23\2\u00d6\u00d7\7\32\2\2\u00d7\u00d9\5$\23\2\u00d8\u00d6\3"+
		"\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		")\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00e2\5<\37\2\u00de\u00df\7\f\2\2"+
		"\u00df\u00e1\5<\37\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3+\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5"+
		"\u00e6\5<\37\2\u00e6\u00ed\5> \2\u00e7\u00e8\7\f\2\2\u00e8\u00e9\5<\37"+
		"\2\u00e9\u00ea\5> \2\u00ea\u00ec\3\2\2\2\u00eb\u00e7\3\2\2\2\u00ec\u00ef"+
		"\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee-\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f1\7\33\2\2\u00f1\u00f2\5:\36\2\u00f2/\3\2\2\2"+
		"\u00f3\u00f4\7\34\2\2\u00f4\u00f5\5:\36\2\u00f5\61\3\2\2\2\u00f6\u00f7"+
		"\7\35\2\2\u00f7\u00f8\5:\36\2\u00f8\63\3\2\2\2\u00f9\u00fa\7\36\2\2\u00fa"+
		"\65\3\2\2\2\u00fb\u00fe\5<\37\2\u00fc\u00fe\58\35\2\u00fd\u00fb\3\2\2"+
		"\2\u00fd\u00fc\3\2\2\2\u00fe\67\3\2\2\2\u00ff\u0100\t\2\2\2\u01009\3\2"+
		"\2\2\u0101\u0102\7#\2\2\u0102;\3\2\2\2\u0103\u0104\7#\2\2\u0104=\3\2\2"+
		"\2\u0105\u0106\7\37\2\2\u0106\u0107\7\6\2\2\u0107\u0108\7!\2\2\u0108\u010b"+
		"\7\7\2\2\u0109\u010b\7 \2\2\u010a\u0105\3\2\2\2\u010a\u0109\3\2\2\2\u010b"+
		"?\3\2\2\2\21BDPp\177\u0089\u0098\u009f\u00cb\u00d2\u00da\u00e2\u00ed\u00fd"+
		"\u010a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}