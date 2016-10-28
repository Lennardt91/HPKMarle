// Generated from de/lab4inf/wrb/WRBParser.g4 by ANTLR 4.5
package de.lab4inf.wrb;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WRBParser}.
 */
public interface WRBParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WRBParser#programm}.
	 * @param ctx the parse tree
	 */
	void enterProgramm(WRBParser.ProgrammContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#programm}.
	 * @param ctx the parse tree
	 */
	void exitProgramm(WRBParser.ProgrammContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#state}.
	 * @param ctx the parse tree
	 */
	void enterState(WRBParser.StateContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#state}.
	 * @param ctx the parse tree
	 */
	void exitState(WRBParser.StateContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#funcdec}.
	 * @param ctx the parse tree
	 */
	void enterFuncdec(WRBParser.FuncdecContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#funcdec}.
	 * @param ctx the parse tree
	 */
	void exitFuncdec(WRBParser.FuncdecContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#vardec}.
	 * @param ctx the parse tree
	 */
	void enterVardec(WRBParser.VardecContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#vardec}.
	 * @param ctx the parse tree
	 */
	void exitVardec(WRBParser.VardecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterDiv(WRBParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitDiv(WRBParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAdd(WRBParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAdd(WRBParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bracket}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBracket(WRBParser.BracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bracket}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBracket(WRBParser.BracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSub(WRBParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSub(WRBParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Expo}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpo(WRBParser.ExpoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Expo}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpo(WRBParser.ExpoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterMult(WRBParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitMult(WRBParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Func}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFunc(WRBParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Func}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFunc(WRBParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVar(WRBParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVar(WRBParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Num}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNum(WRBParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNum(WRBParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(WRBParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(WRBParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(WRBParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(WRBParser.SignContext ctx);
}