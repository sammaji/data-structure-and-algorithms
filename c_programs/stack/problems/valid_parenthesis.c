#include <stdio.h>
#include <stdbool.h>

#define MAX_SIZE 999

char stack[999];
int top = -1;

void push(int element)
{
    stack[top++] = element;
}

char pop()
{
    int value = stack[top];
    top--;
    return value;
}

char peek()
{
    if (top <= 0)
        return NULL;
    else
        return stack[top];
}

bool isMatchingPair(char ch1, char ch2)
{
    return ((ch1 == '(' && ch2 == ')') || (ch2 == '(' && ch1 == ')') || (ch1 == '{' && ch2 == '}') || (ch2 == '}' && ch1 == '{') || (ch1 == ']' && ch2 == '[') || (ch2 == '[' && ch1 == ']'));
}

bool isValid(char *s)
{
    for (int i = 0; s[i] != '\0'; i++)
    {
        if (s[i] == '(' || s[i] == '{' || s[i] == '[')
        {
            push(s[i]);
        }
        else if (isMatchingPair(s[i], peek()))
        {
            pop();
        }
    }

    return top == -1;
}