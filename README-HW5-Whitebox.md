# Whitebox Testing HW:
## 1. Test Set Methods
- toArray() Input Options for full branch coverage:
    1. Size of a is zero, does not hit for loop
    2. Size of a > zero, hits every line 
    
- insert() Input Options for full branch coverage: 
    1. Size of a is > x hits hits first if
    2. Size of a is < x hits else statement
    3. Size of a is zero, skips statements
    
- member() Input Options for full branch coverage: 
    1. An element of a is > than x (an element of a that is indexed before an element > x can't be equal to x) 
    possibly a bug? Why is there no documentation? It should only be a bug if there was actually documentation describing what it is supposed to do. Even 'member' should probably be isMember
    2. An element of a is equal to x where a previously indexed element of a is not > x  
    3. Size of a is zero, should return false
    
- section() Input Options for full branch coverage: 
    1. 