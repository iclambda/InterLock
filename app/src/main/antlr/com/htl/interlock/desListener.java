// Generated from D:/Source/InterLock/app/src/main/antlr\des.g4 by ANTLR 4.5
package com.htl.interlock;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link desParser}.
 */
public interface desListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link desParser#des}.
	 * @param ctx the parse tree
	 */
	void enterDes(@NotNull desParser.DesContext ctx);
	/**
	 * Exit a parse tree produced by {@link desParser#des}.
	 * @param ctx the parse tree
	 */
	void exitDes(@NotNull desParser.DesContext ctx);
	/**
	 * Enter a parse tree produced by {@link desParser#child}.
	 * @param ctx the parse tree
	 */
	void enterChild(@NotNull desParser.ChildContext ctx);
	/**
	 * Exit a parse tree produced by {@link desParser#child}.
	 * @param ctx the parse tree
	 */
	void exitChild(@NotNull desParser.ChildContext ctx);
}