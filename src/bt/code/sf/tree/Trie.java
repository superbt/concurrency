package bt.code.sf.tree;

public class Trie {

    private Trie[] children ;
    private boolean isWorld ;

    public Trie(){
        this.isWorld =false ;
        this.children = new Trie[26];
    }

    public void insert(String word){
        Trie next = this ;
        for(char c: word.toCharArray()){
            if(next.children[c - 'a'] ==null){
                next.children[c - 'a'] = new Trie();
            }
            next = next.children[c -'a'];
        }
        next.isWorld = true ;
    }

    public boolean search(String word){
        Trie next = this ;
        for(char c: word.toCharArray()){
            if(next.children[c - 'a'] ==null){
               return  false ;
            }
            next = next.children[c -'a'];
        }
        return next.isWorld;
    }

    public boolean startWith(String prefix){
        Trie next = this ;
        for(char c: prefix.toCharArray()){
            if(next.children[c - 'a'] ==null){
                return  false ;
            }
            next = next.children[c -'a'];
        }
        return  true ;
    }
}
