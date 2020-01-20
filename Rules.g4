grammar Rules;
program: (query | command)*;

/****BATCH 5****/
command: opencmd | closecmd | writecmd | exitcmd | showcmd | createcmd | updatecmd | insertcmd | deletecmd;
query: relationname '<-' expr;

/****BATCH 4****/
showcmd: 'SHOW' atomicexpr;
createcmd: 'CREATE TABLE' relationname'('typedattributelist')' 'PRIMARY KEY' '('attributelist')';
updatecmd: 'UPDATE' relationname 'SET' attributename '=' literal(',' attributename '=' literal)* 'WHERE' condition;
insertcmd: ('INSERT INTO' relationname 'VALUES FROM' '('literal(','literal)*')') | 'INSERT INTO' relationname 'VALUES FROM RELATION' expr;
deletecmd: 'DELETE FROM' relationname 'WHERE' condition;

/****BATCH 3****/

expr: atomicexpr | selection | projection | renaming | union | difference | product | naturaljoin;
atomicexpr: relationname | '('expr')';
selection: 'select' '('condition')' atomicexpr;
projection: 'project' '('attributelist')' atomicexpr;
renaming: 'rename' '('attributelist')' atomicexpr;
union: atomicexpr '+' atomicexpr;
difference: atomicexpr '-' atomicexpr;
product: atomicexpr '*' atomicexpr;
naturaljoin: atomicexpr '&' atomicexpr;

/****BATCH 2****/
comparison: operand OP operand | '('condition')';
condition: conjunction ('||' conjunction)*;
conjunction: comparison ('&&' comparison)*;

/****BATCH 1****/
attributelist: attributename (','attributename)*;
typedattributelist: attributename type (','attributename type)*;
opencmd: 'OPEN' relationname;
closecmd: 'CLOSE' relationname;
writecmd: 'WRITE' relationname;
exitcmd: 'EXIT';
operand: attributename | literal;
literal: STRINGLITERAL | INTEGER;
relationname: IDENTIFIER;
attributename: IDENTIFIER;
type: 'VARCHAR' '('INTEGER')' | 'INTEGER';
INTEGER: [1-9]DIGIT*|'0';

/****BATCH 0****/
OP: '=='|'!='|'<'|'>'|'<='|'>=';
IDENTIFIER: ALPHA (ALPHA|DIGIT)*;
STRINGLITERAL: '"'(ALPHA|DIGIT)+'"';
ALPHA: [A-Za-z_];
DIGIT: [0-9];
WS: [ \t\r\n;]+ -> skip;