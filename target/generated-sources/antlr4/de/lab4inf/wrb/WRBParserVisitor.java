// Generated from de/lab4inf/wrb/WRBParser.g4 by ANTLR 4.5
package de.lab4inf.wrb;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WRBParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WRBParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WRBParser#programm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramm(WRBParser.ProgrammContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#state}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState(WRBParser.StateContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#funcdec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncdec(WRBParser.FuncdecContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardec(WRBParser.VardecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(WRBParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(WRBParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bracket}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracket(WRBParser.BracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(WRBParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expo}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpo(WRBParser.ExpoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(WRBParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Func}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(WRBParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(WRBParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link WRBParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(WRBParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(WRBParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(WRBParser.SignContext ctx);
}