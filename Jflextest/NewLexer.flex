package Jflextest;
import static Jflextest.Token.*;
%%
%class NewLexer
%type Token
L = [A-Z]
D = [0-9]
P = [a-zA-Z0-9]


Nombre = ({L})+([a-z])*+"_"+({L})+([a-z])*?"_"({L})+([a-z])*?({L})+([a-z])*
Telefono = ("("{D}{D}")""-")?{D}{D}"-"{D}{D}"-"{D}{D}"-"{D}{D}
Celular = ("["{D}{D}{D}"]""-"|{D}{D}{D}"-")?{D}{D}"-"{D}{D}"-"{D}{D}"-"{D}{D}"-"{D}{D}
Email = ({L} | [a-z])+([a-zA-Z0-9"_""-""."])*+"@"+({L} | [a-z]) +([a-zA-Z"."])*
Mastercard = ("51"|"52"|"53"|"54"|"55"|"56"){D}{D}{D}{D}{D}{D}{D}{D}{D}{D}{D}{D}{D}{D}
Visa = ("4"){D}{D}{D}{D}{D}{D}{D}{D}{D}{D}{D}{D}{D}{D}{D}
white=[ \t\r\n]+
%{
	public String lexeme;
%}
%%
{white} {/*Ignore*/}
{Nombre} {lexeme =yytext(); return Nombre;}
{Telefono} {lexeme =yytext(); return Telefono;}
{Celular} {lexeme =yytext(); return Celular;}
{Email} {lexeme =yytext(); return Email;}
{Mastercard} {lexeme =yytext(); return Mastercard;}
{Visa} {lexeme =yytext(); return Visa;}

. {return ERROR;}