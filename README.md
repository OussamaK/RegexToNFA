RegexToNFA
==========

This piece of programme's job is to create an a nondeterministic finite automata from a given regular expression.
I used this grammar:

S->TL
L->+TL
L->`epsilon`
T->MD
D->.MD
D->`epsilon`
M->ZX
X->*
X->`epsilon`
Z->GIVEN
Z->(S)
