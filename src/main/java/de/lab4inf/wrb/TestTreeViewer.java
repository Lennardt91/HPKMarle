package de.lab4inf.wrb;

import java.util.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.gui.*;

public class TestTreeViewer {
    public static void main(String[] args) {
        try {
            showTree("./input");//TODO: Wahrscheinlich sehr unsicher einen relativen Pfad zu benutzen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void showTree(String path) throws Exception{
        ANTLRInputStream input = new ANTLRFileStream(path);
        WRBLexer lexer = new WRBLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        WRBParser parser = new WRBParser(tokens);
        ParseTree tree = parser.programm();
        List<String> ruleNames = Arrays.asList(WRBParser.ruleNames);
        TreeViewer view = new TreeViewer(ruleNames, tree);
        view.open();
    };
}