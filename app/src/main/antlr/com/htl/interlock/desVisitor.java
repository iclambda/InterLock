// Generated from D:/Source/InterLock/app/src/main/antlr\des.g4 by ANTLR 4.5
package com.htl.interlock;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link desParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface desVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link desParser#des}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDes(@NotNull desParser.DesContext ctx);
	/**
	 * Visit a parse tree produced by {@link desParser#child}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChild(@NotNull desParser.ChildContext ctx);
}