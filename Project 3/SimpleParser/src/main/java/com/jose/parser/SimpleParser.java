package com.jose.parser;

import org.jparsec.Parser;
import org.jparsec.Parsers;
import org.jparsec.Scanners;
import org.jparsec.Terminals;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleParser {
    private static final Parser<Void> IGNORED = Scanners.WHITESPACES.skipMany();
    protected static Terminals OPERATORS = Terminals.operators(Arrays.asList("+", "-", "*", "/", "(", ")"));
    protected static Parser<?> TOKENIZER = Parsers.or(OPERATORS.tokenizer(), Terminals.DecimalLiteral.TOKENIZER);

    static Parser<Double> getExpressionParser() {
        Parser.Reference<Double> parserReference = Parser.newReference();
        Parser<Double> parser = parserReference.lazy();
        Parser<Double> numberParser =  Parsers.or(getNumberExpression(), getParenthesisExpression(parser));
        Parser<Double> expressionParser = Parsers.or(
                getAdditionExpression(parser, numberParser),
                getSubstractionExpression(parser, numberParser),
                numberParser
        );
        parserReference.set(expressionParser);
        return expressionParser;
    }

    private static Parser<Double> getNumberExpression() {
        return Terminals.DecimalLiteral.PARSER.map(Double::parseDouble);
    }

    private static Parser<Double> getParenthesisExpression(Parser<Double> expressionParser) {
        return expressionParser.between(OPERATORS.token("("), OPERATORS.token(")"));
    }

    private static Parser<Double> getMathOperatorExpression(Parser<Double> expressionParser) {
        return Parsers.or(
                getMultiplicationExpression(expressionParser),
                getDivisionExpression(expressionParser)
        );
    }

    private static Parser<Double> getAdditionExpression(Parser<Double> expressionParser, Parser<Double> numberParser) {
       return Parsers.sequence(numberParser,
               Parsers.sequence(OPERATORS.token("+"), expressionParser).many1(),
               (a, b) -> {
           double x = a;
           for (Double y : b){
               x += y;
           }
           return x;
       });
    }

    private static Parser<Double> getSubstractionExpression(Parser<Double> expressionParser, Parser<Double> numberParser) {
        return Parsers.sequence(numberParser,
                Parsers.sequence(OPERATORS.token("-"), expressionParser).many1(),
                (a, b) -> {
                    double x = a;
                    for (Double y : b){
                        x -= y;
                    }
                    return x;
                });
    }

    private static Parser<Double> getMultiplicationExpression(Parser<Double> expressionParser) {
        return expressionParser.infixl(OPERATORS.token("*").map(a -> (l, r) -> l + r));
    }

    private static Parser<Double> getDivisionExpression(Parser<Double> expressionParser) {
        return expressionParser.infixl(OPERATORS.token("/").map(a -> (l, r) -> l + r));
    }


    public static void main(String[] args) {
        Parser<Double> mathParser = getExpressionParser().from(TOKENIZER, IGNORED);
        System.out.print(mathParser.parse("2 - 12 + 7 - 3.4 + 12"));
    }
}
